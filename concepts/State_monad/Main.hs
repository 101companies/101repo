import Control.Monad (ap)
-- import Control.Applicative

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
eval' :: Expr -> Int -> (Bool, Int)
eval' (Constant b) i = (b, i)
eval' (And e1 e2) i = 
  let 
   (b1,i') = eval' e1 i
   (b2,i'') = eval' e2 i'
  in (b1 && b2, i''+1) 
eval' (Or e1 e2) i = 
  let 
   (b1,i') = eval' e1 i
   (b2,i'') = eval' e2 i'
  in (b1 || b2, i''+1) 

-- Monadic style interpreter
evalM :: Expr -> State Int Bool
evalM (Constant b) = return b
evalM (And e1 e2) = 
  evalM e1 >>= \b1 ->
  evalM e2 >>= \b2 ->
  modify (+1) >> 
  return (b1 && b2)
evalM (Or e1 e2) = 
  evalM e1 >>= \b1 ->
  evalM e2 >>= \b2 ->
  modify (+1) >> 
  return (b1 || b2)

-- Monadic style interpreter in do notation
evalM' :: Expr -> State Int Bool
evalM' (Constant b) = return b
evalM' (And e1 e2) = do
  b1 <- evalM' e1
  b2 <- evalM' e2
  modify (+1)
  return (b1 && b2)
evalM' (Or e1 e2) = do
  b1 <- evalM' e1
  b2 <- evalM' e2
  modify (+1)
  return (b1 || b2)

-- Data type for the state monad repeated from the library
newtype State s a = State { runState :: s -> (a,s) }

-- Monad instance for State
instance Monad (State s)
  where
    return x = State (\s -> (x, s))
    c >>= f = State (\s -> let (x,s') = runState c s in runState (f x) s')

-- Modification of state
modify :: (s -> s) -> State s ()
modify f = State (\s -> ((), f s))

-- Applicative instance for State
-- These days, Applicative is now a superclass of Monad.
instance Applicative (State s)
  where
    pure x = return x
    (<*>) = ap

-- Functor instance for State
-- These days, Functor is a superclass of Applicative.
instance Functor (State s)
  where
    fmap f c = State (\s -> let (x, s') = runState c s in (f x, s'))

-- Test interpretation
main = do
  print $ eval sample
  print $ eval' sample 0
  print $ runState (evalM sample) 0
  print $ runState (evalM' sample) 0
