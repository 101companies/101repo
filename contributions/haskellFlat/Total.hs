module Total where

import Company
import Data.Map (Map, empty, insertWith, fromListWith)
import MapReduce

-- Total all salaries (perhaps even of several companies)
total :: [Employee] -> Float
total = sum . map (\(_e, _d, _c, _a, s, _m) -> s)

-- Total all salaries grouped by company times department
totalPerDepartment :: [Employee] -> Map (Name, Name) Float
totalPerDepartment = foldr insert empty
 where
  insert (_e, d, c, _a, s, _m)
   = insertWith (+) (c, d) s 

-- As before, but with a map step factored out
totalPerDepartment' :: [Employee] -> Map (Name, Name) Float
totalPerDepartment' = fromListWith (+) . map extract
 where
  extract (_e, d, c, _a, s, _m) = ((c, d), s)

-- As before, but with factored map, grouping, and reduction
totalPerDepartment'' :: [Employee] -> Map (Name, Name) Float
totalPerDepartment''
 = reducePerKey reduce
 . groupByKey
 . map extract
 where
  extract (_e, d, c, _a, s, _m) = ((c, d), s)
  reduce _ = sum
