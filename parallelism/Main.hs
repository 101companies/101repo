module Main where

import Company
import SampleCompany
import Total
import Cut

main = do
   oldTotal <- totalCompany company
   print oldTotal
   
   cutCompany <- cutCompany company
   
   newTotal <- totalCompany cutCompany
   print newTotal