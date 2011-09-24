module Utils where

import Control.Concurrent

takeAllMVars ::  [MVar a] -> IO [a]
takeAllMVars = mapM takeMVar