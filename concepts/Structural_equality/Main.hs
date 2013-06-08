-- Simple arithmetic expressions
data Expr = Const Int | Add Expr Expr

-- Uniform (structural) equality
instance Eq Expr
  where
    (Const i) == (Const j) = i == j
    (Add e1 e2) == (Add e3 e4) = e1 == e3 && e2 == e4
    _ == _ = False

