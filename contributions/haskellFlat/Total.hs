module Total where

import Company
import Data.Map (empty, insertWith, Map)

-- Total all salaries (perhaps even of several companies)
total :: [Employee] -> Float
total = sum . map (\(_e, _d, _c, _a, s, _m) -> s)

-- Total all salaries grouped by company times department
totalPerDepartment :: [Employee] -> Map (Name, Name) Float
totalPerDepartment = foldr insert empty
 where
  insert (_e, d, c, _a, s, _m) m
   = insertWith (+) (c, d) s m 
