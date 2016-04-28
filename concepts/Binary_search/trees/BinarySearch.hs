module BinarySearch where

-- Binary trees
data Tree a = Empty | Fork a (Tree a) (Tree a)
  deriving (Show, Eq)

-- Polymorphic binary search
-- Assume that input tree is sorted
search :: Ord a => Tree a -> a -> Bool
search Empty _ = False
search (Fork x1 l r) x2 =
  if x2 < x1
    then search l x2
    else if x2 > x1
      then search r x2
      else True

