module Main where

import Company
import Align
import Total
import Cut
import Depth

main 
 = do

      -- De-serialize sample company via read
      txt <- readFile "sampleCompany.txt"
      let company = read txt

      -- Test that salaries align with hierarchy
      if not (align company)
        then error "constraint violated"
        else return ()

      -- Test that show followed by read returns the same company
      print $ company == read (show company)

      -- Total all salaries
      print $ total company

      -- Cut all salaries
      let company' = cut company

      -- Test that salaries align with hierarchy
      if not (align company')
        then error "constraint violated"
        else return ()

      -- Total after cut
      print $ total company'

      -- Compute depth of department nesting
      print $ depth company
