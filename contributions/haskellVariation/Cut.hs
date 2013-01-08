module Cut where

import Company

cut :: Company -> Company
cut (Company n ds) = (Company n (map cutD ds))
  where
    cutD :: Department -> Department
    cutD (Department n m sus) = Department n (cutE m) (map cutS sus)
      where
        cutE :: Employee -> Employee
        cutE (Employee n a s) = Employee n a (s/2)
        cutS :: SubUnit -> SubUnit
        cutS (EUnit e) = EUnit (cutE e)
        cutS (DUnit d) = DUnit (cutD d)
