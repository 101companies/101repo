module Main where

import Prelude hiding (log)
import Control.Monad.Writer

import Company
import SampleCompany
import Types
import Cut

main = do
    -- cutting
    let (cutC, log) = runWriter $ cutLogCompany company
    putStrLn $ ppLog log
