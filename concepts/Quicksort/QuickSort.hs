module QuickSort where

-- Polymorphic sorting
sort :: Ord a => [a] -> [a]
sort [] = []
sort (pivot:rest) = 
             (sort lesser)
          ++ [pivot] 
          ++ (sort greater)
  where
    lesser  = filter (< pivot) rest
    greater = filter (>= pivot) rest
