{- 

Testing monoid laws.
First, we cover the monoid of lists of ints.
Second, we define a monoid for summation with the help of a newtype. 
We start from polymorphic properties.
Once we seek generation, we make the monomorphic, as we have to commit to specific types.

-}

module Main where

import Test.QuickCheck

-- Associativity
prop_associative :: (Monoid m, Eq m) => m -> m -> m -> Bool
prop_associative xs ys zs =
  (xs `mappend` ys) `mappend` zs == xs `mappend` (ys `mappend` zs)

-- Left and right identity
prop_identity :: (Monoid m, Eq m) => m -> Bool
prop_identity x =
  mempty <> x == x && x <> mempty == x

-- A newtype to model summation of "numbers" with a monoid
newtype Sum a = Sum a
  deriving (Eq, Show)

-- We need to start with a semigroup
instance Num a => Semigroup (Sum a) where
  Sum x <> Sum y = Sum (x + y)

-- We get mappend from the semigroup
instance Num a => Monoid (Sum a) where
  mempty = Sum 0

-- Trivial generation enabler
instance Arbitrary a => Arbitrary (Sum a) where
  arbitrary = Sum <$> arbitrary

-- Monomorphic versions of the properties
prop_ListIntAssociative :: [Int] -> [Int] -> [Int] -> Bool
prop_SumIntAssociative :: Sum Int -> Sum Int -> Sum Int -> Bool
prop_ListIntIdentity :: [Int] -> Bool
prop_SumIntIdentity :: Sum Int -> Bool
prop_ListIntAssociative = prop_associative
prop_ListIntIdentity = prop_identity
prop_SumIntAssociative = prop_associative
prop_SumIntIdentity = prop_identity

main = do
  quickCheck prop_ListIntAssociative
  quickCheck prop_ListIntIdentity
  quickCheck prop_SumIntAssociative
  quickCheck prop_SumIntIdentity

{-

ghci> main
+++ OK, passed 100 tests.
+++ OK, passed 100 tests.
+++ OK, passed 100 tests.
+++ OK, passed 100 tests.

-}
