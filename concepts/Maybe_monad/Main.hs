import Prelude hiding (Maybe, Nothing, Just, maybe)
import Control.Monad (ap)
-- import Control.Applicative

-- Simple arithmetic expressions
data Expr = Constant Float | Add Expr Expr | Sqrt Expr
  deriving (Eq, Show, Read)

-- Sample terms
sample = Sqrt (Constant 4)
sample' = Sqrt (Constant (-1))

-- A straightforward interpreter
eval :: Expr -> Float
eval (Constant f) = f
eval (Add e1 e2) = eval e1 + eval e2
eval (Sqrt e) = sqrt (eval e)

-- The Maybe type constructor; repeated from the library
data Maybe a = Nothing | Just a
 deriving (Read, Show, Eq)

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

-- A fold function for maybes
maybe :: b -> (a -> b) -> Maybe a -> b
maybe b _ Nothing = b
maybe _ f (Just a) = f a

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

-- A monadic style interpreter
evalM :: Expr -> Maybe Float
evalM (Constant f) = return f
evalM (Add e1 e2) =
  evalM e1 >>= \f1 ->
  evalM e2 >>= \f2 ->
  return (f1 + f2)
evalM (Sqrt e) =
  evalM e >>= \f ->
  guard (f >= 0.0) >>
  return (sqrt f)

-- A monadic style interpreter in do notation
evalM' :: Expr -> Maybe Float
evalM' (Constant f) = return f
evalM' (Add e1 e2) = do
  f1 <- evalM' e1
  f2 <- evalM' e2
  return (f1 + f2)
evalM' (Sqrt e) = do
  f <- evalM' e
  guard (f >= 0.0)
  return (sqrt f)

-- Monad instance for Maybe
instance Monad Maybe
  where
    return = Just
    Nothing >>= f = Nothing
    (Just x) >>= f = f x

-- Type class MonadPlus (see Control.Monad)
class Monad m => MonadPlus m
  where
    mzero :: m a
    mplus :: m a -> m a -> m a

-- MonadPlus instance for Maybe
instance MonadPlus Maybe
  where
    mzero = Nothing
    Nothing `mplus` y = y
    x `mplus` _ = x

-- Succeed or fail 
guard :: MonadPlus m => Bool -> m ()
guard b = if b then return () else mzero

-- Applicative instance for Maybe
-- These days, Applicative is now a superclass of Monad.
instance Applicative Maybe
  where
    pure x = return x
    (<*>) = ap

-- Functor instance for Maybe
-- These days, Functor is a superclass of Applicative.
instance Functor Maybe
  where
    fmap _ Nothing = Nothing
    fmap f (Just x) = Just (f x)

-- Test interpretation
main = do
  print $ eval sample
  print $ eval sample'
  print $ eval' sample
  print $ eval' sample'
  print $ eval'' sample
  print $ eval'' sample'
  print $ evalM sample
  print $ evalM sample'
  print $ evalM' sample
  print $ evalM' sample'
