import Prelude hiding (Maybe, Nothing, Just, maybe)

-- The Maybe type constructor
data Maybe a = Nothing | Just a
 deriving (Read, Show, Eq)

-- Simple arithmetic expressions
data Expr = Const Float | Add Expr Expr | Sqrt Expr
  deriving (Eq, Show, Read)

-- An interpreter with a potential NaN (not a number) result
eval :: Expr -> Float
eval (Const f) = f
eval (Add e1 e2) = eval e1 + eval e2
eval (Sqrt e) = sqrt (eval e)

-- An interpreter using a Maybe type for partiality
eval' :: Expr -> Maybe Float
eval' (Const f) = Just f
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
eval'' (Const f) = Just f
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

-- A monadic style interpreter
evalM :: Expr -> Maybe Float
evalM (Const f) = return f
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
evalM' (Const f) = return f
evalM' (Add e1 e2) = do
  f1 <- evalM' e1
  f2 <- evalM' e2
  return (f1 + f2)
evalM' (Sqrt e) = do
  f <- evalM' e
  guard (f >= 0.0)
  return (sqrt f)

-- Sample terms
sample = Sqrt (Add (Const 2) (Const 2))
sample' = Sqrt (Add (Const (-2)) (Const (-2)))

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
