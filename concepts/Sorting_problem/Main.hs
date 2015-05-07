-- Test for two lists to be permutations of each other
permutation :: Eq a => [a] -> [a] -> Bool
permutation [] ys = null ys
permutation (x:xs) ys = remove ys []
  where
    -- Repeat removal of equal elements
    remove [] _ = False
    remove (y:ys) zs =
      if (x==y)
        then permutation xs (zs++ys)
        else remove ys (y:zs)

-- Test for a list to be sort
sorted :: Ord a => [a] -> Bool
sorted [] = True
sorted [x] = True
sorted (x1:x2:xs) = x1 <= x2 && sorted (x2:xs)

-- Illustrate list properties
main = do
  let l1 = [2,4,3,1,4]
  let l2 = [1,2,3,4,4]
  let l3 = [1,8,2,7,4]
  print $ sorted l1 -- False
  print $ sorted l2 -- True
  print $ sorted l3 -- False
  print $ permutation l1 l2 -- True
  print $ permutation l1 l3 -- False

