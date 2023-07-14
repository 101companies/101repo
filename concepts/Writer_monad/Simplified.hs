{-

A simple example demonstrating a writer monad.
The demo is about handling logging within an interpreter.
We show a trivialized implementation of a writer monad.

Please note: We ignore today's library for the Monad type class.
That is, we bypass the superclass constraint Applicative.

Other concerns regarding the illustration at hand:
- Monad transformers are not used.
- No designated type class is defined for writer monads.
- Typical convenience operations of writer monads are omitted.
- The issue of laziness vs. strictness is neglected.

See here for a proper implementation:
http://hackage.haskell.org/packages/archive/mtl/latest/doc/html/Control-Monad-Writer.html

The example goes through this milestones:
* Baseline interpreter without logging.
* Non-monadic interpreter with logging.
* Monadic interpreter with logging.
* Variation on monadic interpreter with do notation.

-}

import Prelude hiding (Monad, return, (>>=), (>>))
import Control.Monad (guard)
import Data.Monoid

-- Simple Boolean expressions
data Expr = Constant Bool | And Expr Expr | Or Expr Expr
  deriving (Eq, Show, Read)

-- A sample term with two operations
sample = And (Constant True) (Or (Constant False) (Constant True))

-- A straightforward interpreter
eval :: Expr -> Bool
eval (Constant b) = b
eval (And e1 e2) = eval e1 && eval e2
eval (Or e1 e2) = eval e1 || eval e2

-- Interpreter with counting operations
eval' :: Expr -> (Bool, Int)
eval' (Constant b) = (b, 0)
eval' (And e1 e2) = 
  let 
   (b1,i) = eval' e1
   (b2,i') = eval' e2
  in (b1 && b2, i+i'+1) 
eval' (Or e1 e2) = 
  let 
   (b1,i) = eval' e1
   (b2,i') = eval' e2
  in (b1 || b2, i+i'+1) 

-- Monadic style interpreter
evalM :: Expr -> Writer (Sum Int) Bool
evalM (Constant b) = return b
evalM (And e1 e2) = 
  evalM e1 >>= \b1 ->
  evalM e2 >>= \b2 ->
  tell (Sum 1) >> 
  return (b1 && b2)
evalM (Or e1 e2) = 
  evalM e1 >>= \b1 ->
  evalM e2 >>= \b2 ->
  tell (Sum 1) >> 
  return (b1 || b2)

-- Computations as pairs of value and "output"
newtype Writer w a = Writer { runWriter :: (a, w) }

-- Important Writer operation: tell to produce output
tell :: w -> Writer w ()
tell w = Writer ((), w)

-- We define the Monad type class from scratch.
-- In particular, we omit the superclass constraint Applicative.
class Monad m
  where
    return :: a -> m a
    (>>=) :: m a -> (a -> m b) -> m b
    -- Optional
    (>>) :: m a -> m b -> m b
    c >> c' = c >>= (\_ -> c')

-- Monad instance for Writer
instance Monoid w => Monad (Writer w)
  where
    return x = Writer (x, mempty)
    (Writer (x, w)) >>= f = Writer (y, w `mappend` w')
      where
        Writer (y, w') = f x

-- Test interpretation
main = do
  guard $ True == eval sample
  guard $ (True, 2) == eval' sample
  guard $ (True,Sum 2) == runWriter (evalM sample)
