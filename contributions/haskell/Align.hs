module Align where

import Company

align :: Company -> Bool
align (Company _ ds) = and (map (align' Nothing) ds)
  where
    align' :: Maybe Float -> Department -> Bool
    align' v (Department _ m ds es)
      =  maybe True (>getSalary m) v
      && and (map (align' (Just (getSalary m))) ds)
      && and (map ((<getSalary m) . getSalary) es)
    getSalary :: Employee -> Float
    getSalary (Employee _ _ s) = s
