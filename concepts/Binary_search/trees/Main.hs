import BinarySearch

-- Illustrate binary search
main = do
  let input = Fork 3 (Fork 1 Empty Empty) (Fork 42 Empty Empty)
  print $ search input 1 -- True
  print $ search input 3 -- True
  print $ search input 42 -- True
  print $ search input 88 -- False
