module Align where

import Company

align :: Company -> Bool
align (Company _ ds) = and (map (align' Nothing) ds)
  where
    align' :: Maybe Float -> Department -> Bool
    align' v (Department _ m sus)
      =  maybe True (>getSalary m) v
      && and (map (align'' (getSalary m)) sus) 
    align'' :: Float -> SubUnit -> Bool
    align'' v (EUnit e) = v > getSalary e
    align'' v (DUnit d) = align' (Just v) d
    getSalary :: Employee -> Float
    getSalary (Employee _ _ s) = s
