import Control.Monad
import Data.Monoid

-- Simple Boolean expressions
data Expr = Const Bool | And Expr Expr | Or Expr Expr
  deriving (Eq, Show, Read)

-- Plain interpreter
eval :: Expr -> Bool
eval (Const b) = b
eval (And e1 e2) = eval e1 && eval e2
eval (Or e1 e2) = eval e1 || eval e2

-- Interpreter with counting operations
eval' :: Expr -> (Bool, Int)
eval' (Const b) = (b, 0)
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

-- A Writer computation consists of output and a value.
newtype Writer w a = Writer { runWriter :: (a, w) }

-- We set up the Monad type-class instance for writers.
instance Monoid w => Monad (Writer w)
  where
    return a = Writer (a, mempty)
    (Writer (a, w)) >>= f =
      let (Writer (b, w')) = f a in
        (Writer (b, w `mappend` w'))

-- Writer monads are monads with a tell action.
tell :: w -> Writer w ()
tell w = Writer ((), w)

-- Monadic style interpreter
evalM :: Expr -> Writer (Sum Int) Bool
evalM (Const b) = return b
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
evalM' (Const b) = return b
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

-- A sample term with two operations
sample = And (Const True) (Or (Const False) (Const True))

-- Test interpretation
main = do
  print $ eval sample
  print $ eval' sample
  print $ runWriter (evalM sample)
  print $ runWriter (evalM' sample)
