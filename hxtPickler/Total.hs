module Total where

import Company

total :: Company -> Float
total (Company _ ds )= sum $ map totalDept ds

totalDept :: Department -> Float
totalDept (Department _ m sus) = sum $ concat [ [totalEmployee m]
                                                  , map totalSubunit sus]
  
totalEmployee :: Employee -> Float
totalEmployee (Employee _ _ s) = s

totalSubunit :: SubUnit -> Float
totalSubunit (EUnit e) = totalEmployee e
totalSubunit (DUnit d) = totalDept d