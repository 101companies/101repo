{-

A simple example demonstrating a state monad.
The demo is about handling logging within an interpreter.
In particular, we count operations performed.
Logging is complicated enough that a state monad is needed.
That is, we also need to reset the counter potentially.
(A writer monad would not be sufficient.)
We show a trivial implementation of a state monad.

Please note: We ignore today's library for the Monad type class.
That is, we bypass the superclass constraint Applicative.

The example goes through this milestones:
* Baseline interpreter without counting.
* Non-monadic interpreter with counting.
* Monadic interpreter with counting.
* Variation on monadic interpreter with do notation.

-}
import Prelude hiding (Monad, return, (>>=), (>>))
import Control.Monad (guard)

-- Simple Boolean expressions
-- We add a special construct "Hide".
-- The expectation is that operations under Hide are not counted.
data Expr
  = Constant Bool
  | And Expr Expr
  | Or Expr Expr
  | Hide Expr
 deriving (Eq, Show, Read)

-- A sample term with two operations
sample =
  And
    (Constant True)
    (Or
      (Constant True)
      (Hide (And
        (Constant False)
        (Constant False))))

-- A straightforward interpreter
eval :: Expr -> Bool
eval (Constant b) = b
eval (And e1 e2) = eval e1 && eval e2
eval (Or e1 e2) = eval e1 || eval e2
eval (Hide e) = eval e -- No useful implementation

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
eval' (Hide e) i = (fst (eval' e i), i)

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
evalM (Hide e) =
  get >>= \i ->
  evalM e >>= \b ->
  put i >>= \() ->
  return b

-- Data type for the state monad repeated from the library
newtype State s a = State { runState :: s -> (a,s) }

-- Important State operations: get/put state
get :: State s s
get = State (\s -> (s, s))

put :: s -> State s ()
put s = State (\_ -> ((), s))

-- Composition of get and put
modify :: (s -> s) -> State s ()
modify f = get >>= \x -> put (f x)

-- We define the Monad type class from scratch.
-- In particular, we omit the superclass constraint Applicative.
class Monad m
  where
    return :: a -> m a
    (>>=) :: m a -> (a -> m b) -> m b
    -- Optional
    (>>) :: m a -> m b -> m b
    c >> c' = c >>= (\_ -> c')

-- Monad instance for State
instance Monad (State s)
  where
    return x = State (\s -> (x, s))
    c >>= f =
      State (\s ->
        let (x,s') = runState c s in
          runState (f x) s')

-- Test interpretation
main = do
  guard $ True == eval sample
  guard $ (True, 2) == eval' sample 0
  guard $ (True, 2) == runState (evalM sample) 0
