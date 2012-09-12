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

      -- Total all salaries per department
      print $ totalPerDepartment employees

      -- Cut all salaries
      print $ total (cut employees)

