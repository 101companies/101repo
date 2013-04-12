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

-- Illustrate sorting
main = do
  let input = [2,4,3,1,4]
  print $ quicksort input -- [1,2,3,4,4]
