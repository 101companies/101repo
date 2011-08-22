module Total where

import Company

totalCompany :: Company -> Float
totalCompany (Company _ ds )= sum $ map totalDept ds

totalDept :: Department -> Float
totalDept (Department _ m dus eus) = sum $ concat [ [totalEmployee m]
                                                  , map totalDept dus
                                                  , map totalEmployee eus]
  
totalEmployee :: Employee -> Float
totalEmployee (Employee _ _ s) = s

