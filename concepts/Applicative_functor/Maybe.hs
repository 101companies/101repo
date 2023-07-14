{-

A simple example demonstrating Maybe as an applicative (functor).
The demo is about handling the partiality within an interpreter.

-}

import Control.Monad (guard)

-- Trivial expression language
data Exp
  = CInt Int
  | CStr String
  | Add Exp Exp
  | Conc Exp Exp
 deriving (Show)

-- Value domain (results of expression evaluation)
data Val
  = VInt Int
  | VStr String
 deriving (Show, Eq)

-- Basic style without using an applicative functor
eval :: Exp -> Maybe Val
eval (CInt i) = Just $ VInt i
eval (CStr s) = Just $ VStr s
eval (Add e1 e2)
  = case (eval e1, eval e2) of
      (Just (VInt i1), Just (VInt i2)) -> Just (VInt (i1+i2))
      _ -> Nothing
eval (Conc e1 e2)
  = case (eval e1, eval e2) of
      (Just (VStr s1), Just (VStr s2)) -> Just (VStr (s1++s2))
      _ -> Nothing

-- Applicative functor style
eval' :: Exp -> Maybe Val
eval' (CInt i) = pure $ VInt i
eval' (CStr s) = pure $ VStr s
-- https://stackoverflow.com/questions/26786511/how-to-compose-a-binary-function-with-a-unary-function
eval' (Add e1 e2) = (VInt.) . (+) <$> evalInt e1 <*> evalInt e2
eval' (Conc e1 e2) = (VStr.) . (++) <$> evalStr e1 <*> evalStr e2

-- Eval to an Int
evalInt :: Exp -> Maybe Int
evalInt e = maybe Nothing toInt (eval' e)

-- Eval to an String
evalStr :: Exp -> Maybe String
evalStr e = maybe Nothing toStr (eval' e)

-- Projection to Int
toInt :: Val -> Maybe Int
toInt v = case v of (VInt i) -> Just i; _ -> Nothing

-- Projection to String
toStr :: Val -> Maybe String
toStr v = case v of (VStr s) -> Just s; _ -> Nothing

-- Testing is due
addOk = Add (CInt 20) (CInt 22)
concOk = Conc (CStr "4") (CStr "2")
addError = Add (CStr "20") (CInt 22)
main = do
  guard $ Just (VInt 42) == eval addOk
  guard $ Just (VStr "42") == eval concOk
  guard $ Nothing == eval addError
  guard $ Just (VInt 42) == eval' addOk
  guard $ Just (VStr "42") == eval' concOk
  guard $ Nothing == eval' addError
