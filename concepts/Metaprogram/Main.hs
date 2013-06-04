-- Simple arithmetic expressions
data Expr = Const Int | Add Expr Expr
  deriving (Eq, Show)

-- Simplification for unit law of addition
simplify :: Expr -> Expr
simplify t@(Const c) = t
simplify (Add (Const 0) x) = simplify x
simplify (Add x (Const 0)) = simplify x
simplify t@(Add x y) = 
   if t==t'
     then t
     else simplify t'
  where
    t' = Add (simplify x) (simplify y)

main = do
    print
  $ simplify 
  $ Add (Add (Const 0) (Const 42)) (Add (Const 0) (Const 0))
