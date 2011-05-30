module Total where

import Database.HDBC 
import Database.HDBC.Sqlite3

total :: String -> String -> IO (Maybe Double)
total dbName cName = do
     conn <- connectSqlite3 dbName
     res <- quickQuery' conn ("SELECT sum(salary) FROM employee, company WHERE company.name = \"" ++ cName ++ "\" and company.id = employee.cid") []
     disconnect conn
     return (toMaybe $ head $ head res)
        where
            toMaybe total@(SqlByteString s) = Just (fromSql total :: Double)
            toMaybe SqlNull = Nothing
    
                  