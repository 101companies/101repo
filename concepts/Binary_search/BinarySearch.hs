module BinarySearch where

-- Polymorphic binary search
search :: Ord a => [a] -> a -> Bool
search [] _ = False
search xs x =
  if x < b then search a x
  else if x > b then search c x
  else True
  where
    (a,b:c) = split xs

-- Helper for right-biased halving
split :: [a] -> ([a],[a])
split [] = ([],[])
split [x] = ([],[x])
split (x:y:zs) = (x:xs,y:ys)
  where
    (xs,ys) = split zs
