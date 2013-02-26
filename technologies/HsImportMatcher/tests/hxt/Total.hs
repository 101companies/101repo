module Total where
 
import Text.XML.HXT.Core
import Control.Arrow.ArrowList (listA)

-- use ArrowList's listA to collect all salaries' (as strings) and sum up
total :: ArrowXml a => a XmlTree Float
total = listA (deep $ hasName "salary"
               >>> 
               getChildren  
               >>> 
               getText)     
        >>>
        arr (sum.(map read)) 