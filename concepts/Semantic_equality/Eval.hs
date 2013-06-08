import Data

-- Equality based on evaluation
instance Eq Expr
  where
    x == y = eval x == eval y
      where
        eval (Const i) = i
        eval (Add e1 e2) = eval e1 + eval e2


