module Main where

import Company
import Total
import Cut
import Parser

main 
 = do
      -- Parse sample company
      txt <- readFile "sampleCompany.txt"
      let either = parseCompany txt

      -- Handle parse error
      case either of 
       (Left e) -> print e
       (Right company) -> do

        -- Total all salaries
        print $ total company

        -- Cut all salaries
        let company' = cut company

        -- Total after cut
        print $ total company'
