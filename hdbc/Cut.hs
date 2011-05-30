module Cut where

import Database.HDBC 
import Database.HDBC.Sqlite3

cut :: String -> String -> IO ()
cut dbName cName = do 
    conn <- connectSqlite3 dbName
    run conn ("UPDATE employee SET salary = salary / 2 WHERE employee.cid = (SELECT id FROM Company WHERE name = \"" ++ cName ++ "\")") []
    commit conn
    return ()