module Main where

import Text.XML.HXT.Core
import System.Exit

import Company
import Pickler
import Total
import Cut

getCompany :: [Company] -> IO Company
getCompany cs = do
    
    -- exit on deserialization failure
    if (null cs || length cs /= 1) 
      then exitWith (ExitFailure (-1))
      else return () 
    
    -- extract company from arrow result
    return $ head cs


main = do
    -- deserializing from XML
    cs <- runX ( xunpickleDocument xpCompany [withRemoveWS yes] "sampleCompany.xml" )
    
    -- extract company from arrow results
    company1 <- getCompany cs 
    
    -- cut
    let cutCompany = cut company1
    
    -- print total
    print $ total company1   
    
    -- serilize and deserialize
    cs2 <- runX ( constA cutCompany -- lifts company 
                  >>>
	                xpickleDocument xpCompany [withIndent yes] "sampleCompanyCut.xml"
	                >>>
	                xunpickleDocument xpCompany [withRemoveWS yes] "sampleCompanyCut.xml"  
                  )
         
    company2 <- getCompany cs2 
    
    -- print total
    print $ total company2    
    
    
       