module Quicksort where

-- Polymorphic sorting
quicksort :: Ord a => [a] -> [a]
quicksort [] = []
quicksort (pivot:rest) = 
             (quicksort lesser)
          ++ [pivot] 
          ++ (quicksort greater)
  where
    lesser  = filter (< pivot) rest
    greater = filter (>= pivot) rest
