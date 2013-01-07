module Depth where

import Company

depth :: Company -> Int
depth (Company _ ds) = max' (map depth' ds)
  where
    max' = foldr max 0
    depth' :: Department -> Int
    depth' (Department _ _ sus) = 1 + max' (map depth'' sus)
    depth'' :: SubUnit -> Int
    depth'' (EUnit _) = 0
    depth'' (DUnit d) = depth' d
