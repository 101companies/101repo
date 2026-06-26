{- Working with classification -}

module Main where

import Test.QuickCheck

-- From Bool to Property -- note "==="
prop_reverseReverse_classified :: [Int] -> Property
prop_reverseReverse_classified xs =
  classify (null xs) "empty" $
  classify (length xs == 1) "singleton" $
  classify (length xs > 10) "long" $
    reverse (reverse xs) === xs

main = do
  quickCheck prop_reverseReverse_classified

{-

ghci> quickCheck prop_reverseReverse_classified
+++ OK, passed 100 tests:
66% long
 6% singleton
 3% empty

-}
