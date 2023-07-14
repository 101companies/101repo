{-

A simple example demonstrating the Maybe monad.
The demo is about error handling within an interpreter.
Eventually, we also switch from Maybe to the list monad.
In this manner, we can also show nondeterminism.

-}

import Prelude hiding (Maybe, Nothing, Just, maybe)
import Control.Applicative
import Control.Monad hiding (guard)

-- Simple arithmetic expressions
data Expr
  = Constant Float
  | Add Expr Expr
  | Sqrt Expr -- Beware of negative operands
  | Choice Expr Expr -- Nondeterminism
 deriving (Eq, Show, Read)

-- OK ample terms -- evaluates to 42
sampleOk = Add (Constant 38) (Sqrt (Constant 16))

-- Term with negative square root
sampleError = Add (Constant 38) (Sqrt (Constant (-1)))

-- Term with intended recovery from negative square root
sampleRecover = Choice (Sqrt (Constant (-1))) (Constant 42)

-- Term with nondeterminism
sampleNondet = Choice (Constant 41) (Constant 43)

-- A straightforward interpreter
eval :: Expr -> Float
eval (Constant f) = f
eval (Add e1 e2) = eval e1 + eval e2
eval (Sqrt e) = sqrt (eval e)
eval (Choice e _) = eval e -- No useful implementation

-- The Maybe type constructor.
-- It is repeated here so that we can define type class instances.
data Maybe a = Nothing | Just a
 deriving (Read, Show, Eq)

-- A fold function for maybes
maybe :: b -> (a -> b) -> Maybe a -> b
maybe b _ Nothing = b
maybe _ f (Just a) = f a

-- An interpreter using a Maybe type for partiality
eval' :: Expr -> Maybe Float
eval' (Constant f) = Just f
eval' (Add e1 e2) = 
  case eval' e1 of
    Nothing -> Nothing
    Just f1 ->
      case eval' e2 of
        Nothing -> Nothing 
        Just f2 -> Just (f1 + f2)
eval' (Sqrt e) =
  case eval' e of
    Nothing -> Nothing
    Just f -> if f < 0.0
                then Nothing
                else Just (sqrt f)
eval' (Choice e1 e2) =
  case eval' e1 of
    Just f -> Just f
    Nothing -> eval' e2

-- An interpreter using fold over maybe
eval'' :: Expr -> Maybe Float
eval'' (Constant f) = Just f
eval'' (Add e1 e2) = 
  maybe Nothing
        (\f1 -> maybe Nothing
               (\f2 -> Just (f1 + f2))
               (eval'' e2)) 
        (eval'' e1)
eval'' (Sqrt e) = 
  maybe Nothing
        (\f -> if f < 0.0 then Nothing else Just (sqrt f))
        (eval'' e)    
eval'' (Choice e1 e2) =
  maybe (eval' e2) Just (eval' e1)

-- A monadic style interpreter
evalM :: MonadPlus m => Expr -> m Float
evalM (Constant f) = return f
evalM (Add e1 e2) =
  evalM e1 >>= \f1 ->
  evalM e2 >>= \f2 ->
  return (f1 + f2)
evalM (Sqrt e) =
  evalM' e >>= \f ->
  guard (f >= 0.0) >>
  return (sqrt f)
evalM (Choice e1 e2) =
  evalM e1 `mplus` evalM e2

-- A monadic style interpreter in do notation
evalM' :: MonadPlus m => Expr -> m Float
evalM' (Constant f) = return f
evalM' (Add e1 e2) = do
  f1 <- evalM' e1
  f2 <- evalM' e2
  return (f1 + f2)
evalM' (Sqrt e) = do
  f <- evalM' e
  guard (f >= 0.0)
  return (sqrt f)
evalM' (Choice e1 e2) =
  evalM' e1 `mplus` evalM' e2

{-

Please note that the important type class instances are these:
* Monad Maybe
* MonadPlus Maybe
The following instances are needed because of the Haskell library:
* Functor Maybe
* Applicative Maybe
* Alternative Maybe
They are all trivial.
They are needed because of comtemporary superclass constraints.
That is, monads are expected to applicative functors.
Also, monads with plus are expected to be "alternatives".


-}

-- Functor instance for Maybe
instance Functor Maybe
  where
    fmap _ Nothing = Nothing
    fmap f (Just x) = Just (f x)

-- Applicative instance for Maybe
instance Applicative Maybe
  where
    pure = Just
    f <*> x = maybe Nothing (flip fmap x) f

-- Monad instance for Maybe
instance Monad Maybe
  where
    return = pure
    Nothing >>= f = Nothing
    (Just x) >>= f = f x

-- Alternative instance for Maybe
instance Alternative Maybe
  where
    empty = Nothing
    Nothing <|> x = x
    x <|> _ = x

-- MonadPlus instance for Maybe
instance MonadPlus Maybe
  where
    mzero = Nothing
    Nothing `mplus` y = y
    x `mplus` _ = x

-- Succeed or fail 
guard :: MonadPlus m => Bool -> m ()
guard b = if b then return () else mzero

-- Let's use Maybe and List monads!
evalM_maybe :: Expr -> Maybe Float
evalM_maybe = evalM
evalM_maybe' :: Expr -> Maybe Float
evalM_maybe' = evalM'
evalM_list :: Expr -> [Float]
evalM_list = evalM
evalM_list' :: Expr -> [Float]
evalM_list' = evalM'

-- Test interpretation
main = do
  guard $ 42.0 == eval sampleOk
  guard $ isNaN (eval sampleError)
  -- Examples with the Maybe monad
  guard $ Just 42.0 == eval' sampleOk
  guard $ Nothing == eval' sampleError
  guard $ Just 42.0 == eval' sampleRecover
  guard $ Just 41.0 == eval' sampleNondet
  guard $ Just 42.0 == eval'' sampleOk
  guard $ Nothing == eval'' sampleError
  guard $ Just 42.0 == eval'' sampleRecover
  guard $ Just 41.0 == eval'' sampleNondet
  guard $ Just 42.0 == evalM_maybe sampleOk
  guard $ Nothing == evalM_maybe sampleError
  guard $ Just 42.0 == evalM_maybe sampleRecover
  guard $ Just 41.0 == evalM_maybe sampleNondet
  guard $ Just 42.0 == evalM_maybe' sampleOk
  guard $ Nothing == evalM_maybe' sampleError
  guard $ Just 42.0 == evalM_maybe' sampleRecover
  guard $ Just 41.0 == evalM_maybe' sampleNondet
  -- Examples with the List monad
  -- We can also recover from errors.
  -- However, in addition, we may produce multiple results.
  guard $ [42.0] == evalM_list sampleOk
  guard $ [] == evalM_list sampleError
  guard $ [42.0] == evalM_list sampleRecover
  guard $ [41.0, 43.0] == evalM_list sampleNondet
  guard $ [42.0] == evalM_list' sampleOk
  guard $ [] == evalM_list' sampleError
  guard $ [42.0] == evalM_list' sampleRecover
  guard $ [41.0, 43.0] == evalM_list' sampleNondet
