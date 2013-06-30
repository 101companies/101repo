import Data.List (sort)
import Data.Monoid
import Test.QuickCheck

-- Double negation is the identity
prop_double_negation x = not (not x) == x

-- Addition on number types is commutative
prop_addition_commutative x y = x + y == y + x

-- A monoid's mempty is a unit (identity)
prop_identity x = prop_left_identity && prop_right_identity
 where
  prop_left_identity = mempty `mappend` x == x
  prop_right_identity = x `mappend` mempty == x

-- An Arbitrary instance for the summation monoid
instance (Num x, Arbitrary x) => Arbitrary (Sum x)
  where
    arbitrary = do
      x <- arbitrary
      return (Sum x)

-- Simple expression forms
data Expr = Const Int | Add Expr Expr
 deriving (Eq, Show, Read)

-- Evaluation of expressions
eval :: Expr -> Int
eval (Const x) = x
eval (Add x y) = eval x + eval y

-- Simplification based on the unit law for addition
simplify :: Expr -> Expr
simplify (Add (Const 0) x) = simplify x
simplify (Add x (Const 0)) = simplify x
simplify x = x

-- Simplification preserves evaluation
prop_simplify x = eval x == eval (simplify x)

-- A generator for expressions
instance Arbitrary Expr
  where
    arbitrary = do
      -- Pick either "Const" or "Add"
      n <- choose (0, 1) :: Gen Int
      case n of
        0 -> do
          -- Pick a constant in the range [0..10]
          x <- choose (0,10) :: Gen Int
          return (Const x)
        1 -> do
          -- Pick "arbitrary" operands for addition
          x <- arbitrary 
          y <- arbitrary
          return (Add x y)

-- An unreasonable property for take
no'prop_take n l = length (take n l) == n

-- A reasonable property for take
prop_take n l = length (take n l) <= n

-- Data.list.sort sorts
prop_sorting :: [Int] -> Bool
prop_sorting x = sorted y && permutation x y

  where
    y = sort x

    -- Test for two lists to be permutations of each other
    permutation [] [] = True
    permutation (x:xs) ys = remove ys []
      where
        -- Repeat removal of equal elements
        remove [] _ = False
        remove (y:ys) zs =
          if (x==y)
            then permutation xs (zs++ys)
            else remove ys (y:zs)

    -- Test for a list to be sort
    sorted [] = True
    sorted [x] = True
    sorted (x1:x2:xs) = x1 <= x2 && sorted (x2:xs)
