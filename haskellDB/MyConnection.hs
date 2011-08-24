module MyConnection where

import Database.HaskellDB.HDBC.ODBC
import Database.HaskellDB.Database
import Database.HaskellDB.DBDirect

-- connecting to the underlining database
withDB :: (Database -> IO a) -> IO a
withDB = connect driver conf
  where           
    conf = [ ("Driver","MySQL ODBC 5.1 Driver")
           , ("Port","3306")
           , ("Server", "localhost")
           , ("User", "root")
           , ("Database", "101companies") ]
