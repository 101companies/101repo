module Main where

import Company
import Total
import Cut
import SampleCompany

main 
 = do
      -- Test that show followed by read returns the same company
      print $ sample == read (show sample)

      -- Total all salaries
      print $ total employees

      -- Cut all salaries
      print $ total (cut employees)

      -- Total all salaries per department
      let per = totalPerDepartment employees
      print $ per

      -- Check the alternative approaches
      print $ per == totalPerDepartment' employees
      print $ per == totalPerDepartment'' employees
