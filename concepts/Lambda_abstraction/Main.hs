{- Exercise lambda abstraction in the context of incrementing all elements in a list -}

-- Sample input
sample = [1,3,5,7,11,13,17]
-- Expected output
expected = [2,4,6,8,12,14,18]

-- Use a plain increment function
output = map inc sample
  where
    inc :: Int -> Int
    inc x = x + 1

-- Use an anonymous increment function
output' = map (\x -> x + 1) sample

-- Use partial application of (+) for increment
output'' = map ((+) 1) sample

-- Use a section for increment
output''' = map (+1) sample

main = do
  -- Evaluate tests
  print $ and [
      expected == output,
      expected == output',
      expected == output'',
      expected == output'''
    ] -- True means tests pass
