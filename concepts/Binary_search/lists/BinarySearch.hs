module BinarySearch where

-- Polymorphic binary search
-- Assume that input list is sorted
search :: Ord a => [a] -> a -> Bool
search [] _ = False
search xs x =
   if x < y then search ys1 x
   else if x > y then search ys2 x
   else True
  where
    ys1 = take l xs
    (y:ys2) = drop l xs
    l = length xs `div` 2
