module Pickler where

import Text.XML.HXT.Arrow.Pickle.Xml

import Company

-- instance declarations per company data type
instance XmlPickler Company where
    xpickle = xpCompany
    
instance XmlPickler Department where
    xpickle = xpDepartment
  
instance XmlPickler Employee where
    xpickle = xpEmployee
  
instance XmlPickler SubUnit where
    xpickle = xpSubUnit

-- pickle company    
xpCompany :: PU Company
xpCompany 
      = xpElem "company" $
        xpWrap ( uncurry Company
               , \c -> ( cname c
                       , depts c
                       )
                ) $
        xpPair  (xpAttr "name" xpText)
                (xpList xpickle)

-- pickle department                
xpDepartment :: PU Department
xpDepartment 
      = xpElem "department" $
        xpWrap ( \(n,m,ss) -> Department n m ss
               , \d -> ( dname d
                       , manager d
                       , subunits d
                       )  
               ) $
        xpTriple (xpAttr "name" xpText)
                (xpElem "manager" xpEmployee)
                (xpList xpickle)
                
-- pickle employee
xpEmployee :: PU Employee
xpEmployee 
      = xpWrap ( \(n,a,s) -> Employee n a s
               , \e -> ( ename e
                       , address e
                       , salary e
                       )
               ) $
        xpTriple (xpElem "name" xpText)
                 (xpElem "address" xpText)
                 (xpElem "salary" xpPrim)
       
-- pickle subunit
xpSubUnit :: PU SubUnit
xpSubUnit 
      = xpAlt tag ps
          where
            tag (EUnit _ ) = 0
            tag (DUnit _ ) = 1
            ps = [xpEUnit, xpDUnit]
              where
                xpEUnit =
                  xpWrap ( EUnit
                         , employee
                         ) $
                   xpElem "employee" xpEmployee
                xpDUnit =
                  xpWrap ( DUnit
                         , department
                         ) $
                  xpickle
                  
              


                   