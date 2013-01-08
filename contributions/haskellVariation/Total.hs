module Total where

import Company

total :: Company -> Float
total (Company _ ds) = sum (map totalD ds)
  where
    totalD :: Department -> Float
    totalD (Department _ m sus) = sum (totalE m : map totalS sus)
      where
        totalE :: Employee -> Float
        totalE (Employee _ _ s) = s
        totalS :: SubUnit -> Float
        totalS (EUnit e) = totalE e
        totalS (DUnit d) = totalD d
