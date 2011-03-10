module Total where

import Company

total :: Company -> Float
total = sum . map dept . snd
 where
  dept :: Dept -> Float
  dept (Dept _ m sus) = sum (employee m : map subunit sus)
  employee :: Employee -> Float
  employee (Employee _ _ s) = s
  subunit :: SubUnit -> Float
  subunit (PU e) = employee e
  subunit (DU d) = dept d
