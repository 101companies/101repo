{-

A simple example demonstrating a state monad.
The demo is about handling logging within an interpreter.
We show a trivialized implementation of a writer monad.
See here for a proper implementation:
http://hackage.haskell.org/packages/archive/mtl/latest/doc/html/Control-Monad-Writer.html
Concerns ignored by our illustrative implementation:
- Monad transformers are not used.
- No designated type class is defined for writer monads.
- Typical convenience operations of writer monads are omitted.
- The issue of laziness vs. strictness is neglected.

The example goes through this milestones:
* Baseline interpreter without logging.
* Non-monadic interpreter with logging.
* Monadic interpreter with logging.
* Variation on monadic interpreter with do notation.

-}

import Control.Applicative
import Control.Monad
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

-- Monadic style interpreter in do notation
evalM' :: Expr -> Writer (Sum Int) Bool
evalM' (Constant b) = return b
evalM' (And e1 e2) = do
  b1 <- evalM' e1
  b2 <- evalM' e2
  tell (Sum 1)
  return (b1 && b2)
evalM' (Or e1 e2) = do
  b1 <- evalM' e1
  b2 <- evalM' e2
  tell (Sum 1)
  return (b1 || b2)

-- Computations as pairs of value and "output"
newtype Writer w a = Writer { runWriter :: (a, w) }

-- Important Writer operation: tell to produce output
tell :: w -> Writer w ()
tell w = Writer ((), w)

-- Functor instance for Writer
instance Functor (Writer w)
  where
    fmap f c = Writer (f x, w)
      where
        (x, w) = runWriter c
        

-- Applicative instance for Writer
instance Monoid w => Applicative (Writer w)
  where
    pure x = Writer (x, mempty)
    f <*> x = Writer (g y, w1 `mappend` w2)
      where
        (g, w1) = runWriter f
        (y, w2) = runWriter x

-- Monad instance for Writer
instance Monoid w => Monad (Writer w)
  where
    return = pure
    (Writer (x, w)) >>= f = Writer (y, w `mappend` w')
      where
        Writer (y, w') = f x

-- Test interpretation
main = do
  guard $ True == eval sample
  guard $ (True, 2) == eval' sample
  guard $ (True,Sum 2) == runWriter (evalM sample)
  guard $ (True,Sum 2) == runWriter (evalM' sample)
