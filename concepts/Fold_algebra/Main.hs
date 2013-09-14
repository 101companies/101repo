import Prelude hiding (foldr)

-- Recalling the foldr combinator
foldr :: (a -> b -> b) -> b -> [a] -> b
foldr f z [] = z
foldr f z (x:xs) = f x (foldr f z xs)

{-

> foldr (+) 0 [1,2,3]
6

-}

-- An explicit declaration of lists
data List a = Nil | Cons a (List a)

-- The fold algebra for lists
data ListAlg a b
   = ListAlg {
       nil :: b,
       cons :: a -> b -> b
     }

-- The algebraic list fold
foldList :: ListAlg a b -> [a] -> b
foldList alg [] = nil alg
foldList alg (x:xs) = cons alg x (foldList alg xs)

-- A fold algebra for summation
sumAlg :: Num a => ListAlg a a
sumAlg = ListAlg { nil = 0, cons = (+) }

{-

> foldList sumAlg [1,2,3]
6

-}

-- A datatype for expression forms
data Expr = Literal Int 
          | Add Expr Expr
  deriving (Eq, Show, Read)

-- The fold algebra for expressions
data ExprAlg a
   = ExprAlg {
       literal :: Int -> a,
       add :: a -> a -> a
     }

-- Folds over expressions
foldExpr :: ExprAlg a -> Expr -> a
foldExpr alg (Literal i) = literal alg i
foldExpr alg (Add x y)
  = add alg (foldExpr alg x) (foldExpr alg y)

-- A fold algebra for evaluation
evalAlg :: ExprAlg Int
evalAlg = ExprAlg {
    literal = id,
    add = (+) 
  }

{-

> foldExpr evalAlg (Add (Add (Literal 20) (Literal 2)) (Literal 20))
42

-}
