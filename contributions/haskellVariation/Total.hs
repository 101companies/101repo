module Total where

import Company

total :: Company -> Float
total (Company n ds) = sum (map dep ds)
  where
   dep :: Department -> Float
   dep (Department _ m sus) = sum (emp m : map subunit sus)
     where
       emp :: Employee -> Float
       emp (Employee _ _ s) = s
       subunit :: SubUnit -> Float
       subunit (EUnit e) = emp e
       subunit (DUnit d) = dep d
