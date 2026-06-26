{- Testing good and bad sorting -}

module Main where

import Data.List (sort)
import Test.QuickCheck

prop_sortIdempotent :: ([Int] -> [Int]) -> [Int] -> Bool
prop_sortIdempotent sort xs =
  sort (sort xs) == sort xs

prop_sortPreservesLength :: ([Int] -> [Int]) -> [Int] -> Bool
prop_sortPreservesLength sort xs =
  length (sort xs) == length xs

-- Satisfies the two properties above, but not the following ones!
badSort :: [Int] -> [Int]
badSort xs = xs

prop_sortMinimumFirst ::  ([Int] -> [Int]) -> [Int] -> Property
prop_sortMinimumFirst sort xs =
  not (null xs) ==>
    head (sort xs) == minimum xs

prop_sortSpec :: ([Int] -> [Int]) -> [Int] -> Bool
prop_sortSpec sort xs =
  isSorted ys && all (\x -> count x ys == count x xs) xs
  where
    ys = sort xs

isSorted :: Ord a => [a] -> Bool
isSorted []       = True
isSorted [_]      = True
isSorted (x:y:xs) = x <= y && isSorted (y:xs)

count :: Eq a => a -> [a] -> Int
count x = length . filter (== x)

-- Commented out runs fail!
main = do
  quickCheck (prop_sortIdempotent sort)
  quickCheck (prop_sortIdempotent badSort)
  quickCheck (prop_sortPreservesLength sort)
  quickCheck (prop_sortPreservesLength badSort)
  quickCheck (prop_sortMinimumFirst sort)
  -- quickCheck (prop_sortMinimumFirst badSort)
  quickCheck (prop_sortSpec sort)
  -- quickCheck (prop_sortSpec badSort)

{-

ghci> quickCheck (prop_sortSpec sort)
+++ OK, passed 100 tests.
ghci> quickCheck (prop_sortSpec badSort)
*** Failed! Falsified (after 4 tests and 1 shrink):     
[0,-1]

-}
