module InsertionSort where

-- Polymorphic sorting
sort :: Ord a => [a] -> [a]
sort xs = inserts xs []

-- Insert given elements in an emerging result
inserts :: Ord a => [a] -> [a] -> [a]
inserts [] r = r
inserts (x:xs) r = inserts xs (insert x r)

-- Insert a given element in a list
insert :: Ord a => a -> [a] -> [a]
insert x [] = [x]
insert x (y:ys) =
  if x <= y
    then x : y : ys
    else y : insert x ys
