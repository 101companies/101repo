module Main where

import Company
import Total
import Cut
import Depth

main 
 = do

      -- De-serialize sample company via read
      txt <- readFile "sampleCompany.txt"
      let company = read txt

      -- Test that show followed by read returns the same company
      print $ company == read (show company)

      -- Total all salaries
      print $ total company

      -- Cut all salaries
      print $ total (cut company)

      -- Compute depth of department nesting
      print $ depth company

