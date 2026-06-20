module Main where

import Test.QuickCheck

-- Some expression forms
data Expr
  = Lit Int
  | Add Expr Expr
  | Neg Expr
  deriving (Eq, Show)

-- A simple evaluator -- with a bug!
eval :: Expr -> Int
eval (Lit n)     = n
eval (Add x y)   = eval x + eval y
-- eval (Neg x)     = negate (eval x)
eval (Neg x)     = eval x

-- A generator for expressions
instance Arbitrary Expr where
  arbitrary = sized expr
    where
      expr 0 =
        Lit <$> arbitrary
      expr n =
        oneof
          [ Lit <$> arbitrary
          , Add <$> expr (n `div` 2) <*> expr (n `div` 2)
          , Neg <$> expr (n - 1)
          ]

prop_addZero :: Expr -> Bool
prop_addZero e =
  eval (Add e (Lit 0)) == eval e

prop_doubleNegation :: Expr -> Bool
prop_doubleNegation e =
  eval (Neg (Neg e)) == eval e

-- This property can catch the bug!
prop_negLit :: Int -> Bool
prop_negLit n =
  eval (Neg (Lit n)) == negate n

prop_addCommutative :: Expr -> Expr -> Bool
prop_addCommutative x y =
  eval (Add x y) == eval (Add y x)

-- Commented out runs fail!
main = do
  quickCheck prop_addZero
  quickCheck prop_doubleNegation
  -- quickCheck prop_negLit

{-

ghci> 
ghci> quickCheck prop_negLit
*** Failed! Falsified (after 2 tests and 1 shrink):     
1
-}
