import Prelude hiding (odd, even)

-- Test an Int to be even
even :: Int -> Bool
even x = x `mod` 2 == 0

-- Test an Int to be odd
odd :: Int -> Bool
odd = not . even

main = do
  print $ even 1
  print $ odd 1
  print $ even 2
  print $ odd 2
  print $ even 3
  print $ odd 3
