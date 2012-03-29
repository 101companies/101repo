module Cut where
 
import Text.XML.HXT.Core

-- find all salary nodes' children and change texts by cutting salary values
cut :: ArrowXml a => a XmlTree XmlTree
cut = processTopDown cutSalaryNode
        where
          cutSalaryNode = processChildren (changeText (show.(/2).read))  
                         `when`    
                          hasName "salary"