module Precedence where

import Company
import Data.Generics

-- Check that precedence constraint hold

precedence :: Company -> Bool
precedence (Company _ ds) = and (map department ds)
 where

  -- Test department
  department :: Department -> Bool
  department (Department n m sus)
   =  and (  map subunit sus
          ++ map ((>) (getSalary m)) (map getTopSalary sus))

  -- Test subunit
  subunit :: SubUnit -> Bool
  subunit (DUnit d) = department d
  subunit (EUnit e) = True

  -- Project employee to salary
  getSalary :: Employee -> Salary
  getSalary (Employee _ _ s _) = s

  -- Retrieve presumably highest salary for subunit
  getTopSalary :: SubUnit -> Salary
  getTopSalary (DUnit (Department _ m _)) = getSalary m
  getTopSalary (EUnit e) = getSalary e
