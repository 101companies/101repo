module Depth where

import Company

depth :: Company -> Int
depth (Company _ ds) = max' (map depth' ds)
  where
    max' = foldr max 0
    depth' :: Department -> Int
    depth' (Department _ _ ds _) = 1 + max' (map depth' ds)
