-- Example inspired by https://www.staff.city.ac.uk/~ross/papers/Applicative.pdf

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

-- More point-free, combinatorial interpreter hiding some environment passing
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

-- A bit of testing code
-- "42" should be printed in all cases.
sampleExp = Add (Var "x") (Val 22)
sampleEnv = [("x", 20)]
main = do
  print $ eval sampleExp sampleEnv
  print $ eval' sampleExp sampleEnv
  print $ eval'' sampleExp sampleEnv
