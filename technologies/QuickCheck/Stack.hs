{-# LANGUAGE FlexibleInstances #-}

module Main where

import Test.QuickCheck
import SimpleStackADT

fromList :: [a] -> Stack a
fromList = foldr push empty

toList :: Stack a -> [a]
toList s
  | isEmpty s = []
  | otherwise = top s : toList (pop s)

instance Arbitrary a => Arbitrary (Stack a) where
  arbitrary = fromList <$> arbitrary
  shrink s = fromList <$> shrink (toList s)

instance Show a => Show (Stack a) where
  show s = "fromList " ++ show (toList s)

prop_emptyIsEmpty :: Bool
prop_emptyIsEmpty =
  isEmpty (empty :: Stack Int)

prop_emptySize :: Bool
prop_emptySize =
  size (empty :: Stack Int) == 0

prop_pushNotEmpty :: Int -> Stack Int -> Bool
prop_pushNotEmpty x s =
  not (isEmpty (push x s))

prop_pushIncreasesSize :: Int -> Stack Int -> Bool
prop_pushIncreasesSize x s =
  size (push x s) == size s + 1

prop_topPush :: Int -> Stack Int -> Bool
prop_topPush x s =
  top (push x s) == x

prop_popPush :: Int -> Stack Int -> Bool
prop_popPush x s =
  toList (pop (push x s)) == toList s

prop_fromListToList :: [Int] -> Bool
prop_fromListToList xs =
  toList (fromList xs) == xs

prop_sizeToList :: Stack Int -> Bool
prop_sizeToList s =
  size s == length (toList s)

prop_popDecreasesSize :: Stack Int -> Property
prop_popDecreasesSize s =
  not (isEmpty s) ==>
    size (pop s) == size s - 1

prop_popDecreasesSize_push :: Int -> Stack Int -> Bool
prop_popDecreasesSize_push x s =
  size (pop (push x s)) == size s

prop_topAfterTwoPushes :: Int -> Int -> Stack Int -> Bool
prop_topAfterTwoPushes x y s =
  top (push x (push y s)) == x

prop_popRevealsPreviousTop :: Int -> Int -> Stack Int -> Bool
prop_popRevealsPreviousTop x y s =
  top (pop (push x (push y s))) == y

main = do
  quickCheck prop_emptyIsEmpty
  quickCheck prop_emptySize
  quickCheck prop_pushNotEmpty
  quickCheck prop_pushIncreasesSize
  quickCheck prop_topPush
  quickCheck prop_popPush
  quickCheck prop_fromListToList
  quickCheck prop_sizeToList
  quickCheck prop_popDecreasesSize
  quickCheck prop_popDecreasesSize_push
  quickCheck prop_topAfterTwoPushes
  quickCheck prop_popRevealsPreviousTop

{-

ghci> main
+++ OK, passed 100 tests.
+++ OK, passed 100 tests.
+++ OK, passed 100 tests.
+++ OK, passed 100 tests.
+++ OK, passed 100 tests.
+++ OK, passed 100 tests.
+++ OK, passed 100 tests.
+++ OK, passed 100 tests.
+++ OK, passed 100 tests; 15 discarded.
+++ OK, passed 100 tests.
+++ OK, passed 100 tests.
+++ OK, passed 100 tests.

-}
