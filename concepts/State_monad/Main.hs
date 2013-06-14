-- Simple Boolean expressions
data Expr = Const Bool | And Expr Expr | Or Expr Expr
  deriving (Eq, Show, Read)

-- Plain interpreter
eval :: Expr -> Bool
eval (Const b) = b
eval (And e1 e2) = eval e1 && eval e2
eval (Or e1 e2) = eval e1 || eval e2

-- Interpreter with counting operations
eval' :: Expr -> Int -> (Bool, Int)
eval' (Const b) i = (b, i)
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

-- Data type for the state monad
newtype State s a = State { runState :: s -> (a,s) }

-- Monad instance for State
instance Monad (State s)
  where
    return x = State (\s -> (x, s))
    c >>= f = State (\s -> let (x,s') = runState c s in runState (f x) s')

-- Modification of state
modify :: (s -> s) -> State s ()
modify f = State (\s -> ((), f s))

-- Monadic style interpreter
evalM :: Expr -> State Int Bool
evalM (Const b) = return b
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
evalM' (Const b) = return b
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

-- A sample term with two operations
sample = And (Const True) (Or (Const False) (Const True))

-- Test interpretation
main = do
  print $ eval sample
  print $ eval' sample 0
  print $ runState (evalM sample) 0
  print $ runState (evalM' sample) 0
