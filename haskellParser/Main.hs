module Main where

import Company
import SampleCompany
import Total
import Cut
import Parser
import Text.Parsec
import Control.Monad (liftM)

rightApplyPrint :: Show a => Either ParseError Company -> (Company -> a) -> IO ()
rightApplyPrint (Right c) f = print $ f c
rightApplyPrint (Left e) _ = print e

main 
 = do
      -- read sample file and parse content
      parsedCompany <- liftM parseCompany $ readFile "sample.Company"
      
      -- Test wether parsing returns the expected company
      rightApplyPrint parsedCompany (== company)

      -- Total all salaries
      rightApplyPrint parsedCompany total

      -- Cut and total all salaries
      rightApplyPrint parsedCompany $ total.cut
