module Total where

import Company

totalCompany :: Company -> Float
totalCompany (Company _ depts) = sum $ map totalDept depts 

totalDept :: Department -> Float
totalDept (Department _ m dus eus) = sum [totalEmployee m, sum $ map totalDept dus, sum $ map totalEmployee eus]
totalEmployee :: Employee -> Float
totalEmployee (Employee _ _ s) = s
                                                 