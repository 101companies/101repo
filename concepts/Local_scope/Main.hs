-- Split a list into halves
split :: [Int] -> ([Int],[Int])
split xs = (take len xs, drop len xs)
  where
    len = length xs `div` 2

-- Splitting without using local scope
split' :: [Int] -> ([Int],[Int])
split' xs =
  ( take (length xs `div` 2) xs, 
    drop (length xs `div` 2) xs )

-- Illustrate splitting
main = do
  print $ split [] -- ([],[])
  print $ split [1] -- ([],[1])
  print $ split [1,2] -- ([1],[2])
  print $ split [1,2,3] -- ([1],[2,3])
  print $ split [1,2,3,4] -- ([1,2],[3,4])

