import BinarySearch

-- Illustrate binary search
main = do
  let input = [1,2,3,4,4]
  print $ search input 1 -- True
  print $ search input 2 -- True
  print $ search input 3 -- True
  print $ search input 4 -- True
  print $ search input 5 -- False
