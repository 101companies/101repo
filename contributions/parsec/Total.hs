module Total where

import Company

total :: Company -> Float
total = sum . map dept . snd
 where
  dept :: Department -> Float
  dept (Department _ m sus) = sum (employee m : map subunit sus)
  employee :: Employee -> Float
  employee (Employee _ _ s) = s
  subunit :: SubUnit -> Float
  subunit (EUnit e) = employee e
  subunit (DUnit d) = dept d
