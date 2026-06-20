module Main where

import Test.QuickCheck

-- Important property, but not deep
prop_reverseReverse :: [Int] -> Bool
prop_reverseReverse xs =
  reverse (reverse xs) == xs

-- Stupid property
prop_reverseLength :: [Int] -> Bool
prop_reverseLength xs =
  length (reverse xs) == length xs

-- Deeper property
prop_reverseAppend :: [Int] -> [Int] -> Bool
prop_reverseAppend xs ys =
  reverse (xs ++ ys) == reverse ys ++ reverse xs

main = do
  quickCheck prop_reverseReverse
  quickCheck prop_reverseLength
  quickCheck prop_reverseAppend

{-

ghci> main
+++ OK, passed 100 tests.
+++ OK, passed 100 tests.
+++ OK, passed 100 tests.

-}
