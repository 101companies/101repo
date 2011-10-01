module Total where

import Database.HDBC 

total :: IConnection conn => conn -> String -> IO Double
total conn cName = do
     stmt <- prepare conn "SELECT salary FROM employee, company WHERE company.name = ? and company.id = employee.cid"
     execute stmt [toSql cName]
     res <- fetchAllRows stmt
     return $ sum (map (fromSql.head) res)            