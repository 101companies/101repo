module MergeSort where

-- Polymorphic sorting
sort :: Ord a => [a] -> [a]
sort [] = []
sort [x] = [x]
sort xs = merge (sort ys) (sort zs)
  where
    (ys,zs) = split xs

-- Split a list into halves
split :: [a] -> ([a],[a])
split xs = (take len xs, drop len xs)
  where
    len = length xs `div` 2

-- Merge sorted sublists
merge :: Ord a => [a] -> [a] -> [a]
merge [] ys = ys
merge xs [] = xs
merge (x:xs) (y:ys) =
  if x<=y 
    then x : merge xs (y:ys)
    else y : merge (x:xs) ys
