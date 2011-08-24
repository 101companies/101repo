module Cut where

import Database.HDBC 

cut :: IConnection conn => conn -> String -> IO ()
cut conn cName = do
    stmt <- prepare conn "UPDATE employee SET salary = salary / 2 WHERE employee.cid = (SELECT id FROM Company WHERE name = ?)"
    execute stmt [toSql cName] 
    commit conn