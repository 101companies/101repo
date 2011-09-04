module Main where

import Database.HDBC 
import Database.HDBC.ODBC

import Total
import Cut

main = do
    -- connect
    let connString = "Driver={MySQL ODBC 5.1 Driver};"
              ++ "Server=localhost;"
              ++ "Port=3306;"
              ++ "Database=101companies;"
              ++ "User=root;"
    conn <- connectODBC connString
    
    -- company name
    let cName = "meganalysis" 
    
    --total
    oldTotal <- total conn cName
    print oldTotal
    
    -- cut 
    cut conn "meganalysis"
    
    -- new total
    newTotal <- total conn cName
    print newTotal