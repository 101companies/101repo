module Main where

import Company
import SampleCompany
import Total
import Cut
import Parser
import Text.Parsec
import Control.Monad (liftM)

eitherPrint :: Show a => Either ParseError Company -> (Company -> a) -> IO ()
eitherPrint (Right c) f = print $ f c
eitherPrint (Left e) _ = print e

main 
 = do
	-- read sample file and parse content
	parsedCompany <- liftM parseCompany $
		readFile "sample.Company"
		
	-- Test wether parsing returns the expected company
	eitherPrint parsedCompany (== company)

	-- Total all salaries
	eitherPrint parsedCompany total

	-- Cut and total all salaries
	eitherPrint parsedCompany $ total.cut
