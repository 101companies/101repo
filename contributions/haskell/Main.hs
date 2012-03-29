module Main where

import Company
import Total
import Cut
import SampleCompany

main 
 = do
      -- Test that show followed by read returns the same company.
      print $ company == read (show company)

      -- Total all salaries
      print $ total company

      -- Cut all salaries
      print $ total (cut company)
