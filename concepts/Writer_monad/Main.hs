import Control.Monad (ap)
-- import Control.Applicative
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

{-

This is a trivialized implementation of a writer monad.

See here for a proper implementation:

http://hackage.haskell.org/packages/archive/mtl/latest/doc/html/Control-Monad-Writer.html

The present implementation is kept as simple as possible; specifically:
- Monad transformers are not used.
- No designated type class is defined for writer monads.
- Typical convenience operations of writer monads are omitted.
- The issue of laziness and strictness is neglected.
- ...

-}

-- Computations as pairs of value and "output"
newtype Writer w a = Writer { runWriter :: (a, w) }

-- Monad instance for Writer
instance Monoid w => Monad (Writer w)
  where
    return a = Writer (a, mempty)
    (Writer (a, w)) >>= f =
      let (Writer (b, w')) = f a in
        (Writer (b, w `mappend` w'))

-- Produce output
tell :: w -> Writer w ()
tell w = Writer ((), w)

-- Applicative instance for Writer
-- These days, Applicative is now a superclass of Monad.
instance Monoid w => Applicative (Writer w)
  where
    pure x = return x
    (<*>) = ap

-- Functor instance for Writer
-- These days, Functor is a superclass of Applicative.
instance Functor (Writer w)
  where
    fmap f c = Writer (let (x, w) = runWriter c in (f x, w))

-- Test interpretation
main = do
  print $ eval sample
  print $ eval' sample
  print $ runWriter (evalM sample)
  print $ runWriter (evalM' sample)
