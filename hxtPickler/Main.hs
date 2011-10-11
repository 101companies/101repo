module Main where

import Text.XML.HXT.Core
import System.Exit

import Company
import Pickler
import Total
import Cut


main = do
    -- deserializing from XML
    [company1] <- runX ( xunpickleDocument xpCompany [withRemoveWS yes] "sampleCompany.xml" )
    
    -- cut
    let cutCompany = cut company1
    
    -- print total
    print $ total company1   
    
    -- serilize and deserialize
    [company2] <- runX ( constA cutCompany -- lifts company 
                  >>>
	                xpickleDocument xpCompany [withIndent yes] $
                  "sampleCompanyCut.xml"
	                >>>
	                xunpickleDocument xpCompany [withRemoveWS yes] $ 
                  "sampleCompanyCut.xml"  
                  )
          
    -- print total
    print $ total company2    
    
    
       