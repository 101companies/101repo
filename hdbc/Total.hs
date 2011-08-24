module Total where

import Database.HDBC 

total :: IConnection conn => conn -> String -> IO (Maybe Double)
total conn cName = do
     stmt <- prepare conn "SELECT sum(salary) FROM employee, company WHERE company.name = ? and company.id = employee.cid"
     execute stmt [toSql cName]
     res <- fetchAllRows' stmt
     return (toMaybe $ head $ head res)
        where
            toMaybe total@(SqlDouble _) = Just (fromSql total :: Double)
            toMaybe SqlNull = Nothing
    
                  