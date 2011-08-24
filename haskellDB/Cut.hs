module Cut(cut)  where

import Database.HaskellDB
import Database.HaskellDB.DBLayout

import qualified DBDesc.Employee as E
import qualified DBDesc.Company as C
import MyConnection

-- cut update
cut :: String -> Database -> IO ()
cut cname db = do
       [res] <- withDB $ \db -> query db (getcid cname)  
       update db E.employee
          (\r -> r!E.cid .==.  (fromNull (constant (-1)) (constant (res!C.xid))))
          (\r -> E.salary << (r!E.salary) ./. constant 2)          

-- query cname by id          
getcid cname = do 
  cs <- table C.company
  restrict (cs!C.name .==. constant cname)
  project (C.xid << cs!C.xid)
