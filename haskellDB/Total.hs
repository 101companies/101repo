module Total(total,ttl)  where

import Database.HaskellDB
import Database.HaskellDB.DBLayout

import qualified DBDesc.Employee as E
import qualified DBDesc.Company as C

-- Ttl field to store the total salary
data Ttl = Ttl

instance FieldTag Ttl where fieldName _ = "ttl"
  
ttl :: Attr Ttl Double
ttl = mkAttr Ttl  

-- total query
total :: String -> Query (Rel (RecCons Ttl (Expr Double) RecNil))
total cname = do 
  es <- table E.employee
  cs <- table C.company

  restrict $
    ( fromNull (constant 0) (cs!C.xid) .==. es!E.cid 
      .&&. 
      cs!C.name .==. constant cname )

  project (ttl << _sum (es!E.salary))