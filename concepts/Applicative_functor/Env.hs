{-

A simple example demonstrating "->a" as an applicative (functor).
"->a" can be thought of as enabling environment passing.
The demo is about interpretation with the use of an environment.
The example inspired by the original paper on applicative functors:
https://www.staff.city.ac.uk/~ross/papers/Applicative.pdf

-}

-- For illustrative puproses, we define and instantiate Functor and Applicative from scratch.
import Prelude hiding (Functor, fmap, (<$>), Applicative, pure, (<*>))
import Control.Monad (guard)

infixl 4 <$>
infixl 4 <*>

class Functor f where
  fmap :: (a -> b) -> f a -> f b

(<$>) :: Functor f => (a -> b) -> f a -> f b
(<$>) = fmap

class Functor f => Applicative f where
  pure :: a -> f a
  (<*>) :: f (a -> b) -> f a -> f b

instance Functor ((->) r) where
  fmap = (.)

instance Applicative ((->) r) where
  pure x = \_ -> x
  f <*> g = \x -> f x (g x)

-- Some expression forms to be interpreted
data Exp
  = Var String
  | Val Int
  | Add Exp Exp

-- Environments with a fetch (lookup) function
type Env = [(String, Int)]
fetch x ((y,v):n) = if x==y then v else fetch x n

-- Straightforward interpreter; we take care of environment passing
eval :: Exp -> Env -> Int
eval (Var x) n = fetch x n
eval (Val v) _ = v
eval (Add e1 e2) n = eval e1 n + eval e2 n

-- Beware -- a bit tough!
-- A point-free, combinatorial interpreter hiding some environment passing
eval' :: Exp -> Env -> Int
eval' (Var x) = fetch x
eval' (Val v) = k v -- aka const
eval' (Add e1 e2) = k (+) `s` eval' e1 `s` eval' e2

-- https://en.wikipedia.org/wiki/SKI_combinator_calculus
i :: a -> a
i x = x -- aka id
k :: a -> b -> a
k x y = x -- aka const
s :: (a -> b -> c) -> (a -> b) -> a -> c
s x y z = x z (y z) -- aka <*> of applicative

-- Switch to applicative functor style, thereby demonstrating a general pattern
eval'' :: Exp -> Env -> Int
eval'' (Var x) = fetch x
eval'' (Val v) = pure v
eval'' (Add e1 e2) = pure (+) <*> eval'' e1 <*> eval'' e2

-- Testing is due
sampleExp = Add (Var "x") (Val 22)
sampleEnv = [("x", 20)]
main = do
  guard $ 42 == eval sampleExp sampleEnv
  guard $ 42 == eval' sampleExp sampleEnv
  guard $ 42 == eval'' sampleExp sampleEnv
