module Main where
 
import Text.XML.HXT.Core
import System.Exit

import Cut
import Total
 
-- general arrow for reading, processing and writing XML data
readProWrite :: String -> String -> IOSArrow XmlTree XmlTree -> IOSArrow XmlTree Int
readProWrite src dest arrow
  = readDocument [] src        
    >>>
    processChildren (arrow `when` isElem)        -- only process the XML root 
    >>>
    writeDocument [] dest 
    >>>
    getErrStatus 
 
main :: IO ()
main = do
      [ttl] <- runX ( readDocument [] "sampleCompany.xml" 
                      >>> total )
      print ttl
      
      [rcode] <- runX (readProWrite "sampleCompany.xml" "sampleCompanyCut.xml" cut)
      exitOnError rcode
      
      [ttl] <- runX ( readDocument [] "sampleCompanyCut.xml" 
                      >>> total )
      print ttl
      
        where
          exitOnError rcode = if rcode >= c_err  then exitWith (ExitFailure (-1)) else return ()