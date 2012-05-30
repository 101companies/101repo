module Main where

import Prelude hiding (log)
import Control.Monad.Writer

import Company
import SampleCompany
import Types
import Total
import Cut

main = do
    -- totaling
    let (ttl,log) = runWriter $ totalLogCompany company
    print $ ttl
    putStrLn $ ppLog log
    
    -- cutting
    let (cutC, log) = runWriter $ cutLogCompany company
    putStrLn $ ppLog log
    
    -- totaling
    let (ttl, log) = runWriter $ totalLogCompany cutC
    print $ ttl
    putStrLn $ ppLog log