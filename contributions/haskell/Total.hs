module Total where

import Company

total :: Company -> Float
total (Company n ds) = sum (map dept ds)
 where
  dept :: Department -> Float
  dept (Department _ m sus) = sum (employee m : map subunit sus)
  employee :: Employee -> Float
  employee (Employee _ _ s) = s
  subunit :: SubUnit -> Float
  subunit (EUnit e) = employee e
  subunit (DUnit d) = dept d
