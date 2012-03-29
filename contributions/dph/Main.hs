module Main where

import Company
import Total
import Cut
import SampleCompany

main = do
      -- print total
      print $ total company

      -- print cut total
      print $ total (cut company)
