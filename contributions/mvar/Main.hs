module Main where

import Company
import SampleCompany
import Total
import Cut

main = do
   oldTotal <- totalCompany company
   print oldTotal
   
   cutC <- cutCompany company
   
   newTotal <- totalCompany cutC
   print newTotal