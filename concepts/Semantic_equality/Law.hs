import Data

-- Lawful equality
instance Eq Expr
  where
    x == y = eq (normalize x) (normalize y)
      where

        -- Associate addition to the right
        normalize :: Expr -> Expr
        normalize x@(Const i) = x
        normalize (Add x@(Const i) y) = Add x (normalize y)
        normalize (Add (Add x y) z) = normalize (Add x (Add y z))

        -- Uniform (structural) equality
        eq :: Expr -> Expr -> Bool
        eq (Const i) (Const j) = i == j
        eq (Add e1 e2) (Add e3 e4) = eq e1 e3 && eq e2 e4
        eq _ _ = False




