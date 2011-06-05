module Total where

import Control.Concurrent
import Control.Monad

import Company
import Utils
             
totalCompany :: Company -> IO Float
totalCompany (Company _ depts) = do
    mvars <- forM depts $ \d -> do
        mvar' <- newEmptyMVar
        forkIO $ totalDept mvar' d
        return mvar'
    totals <- takeAllMVars mvars
    return $ sum totals

totalDept :: MVar Float -> Department -> IO ()
totalDept mvar (Department _ m dus eus) = do
    mvars <- forM dus $ \d -> do
        mvar' <- newEmptyMVar
        forkIO $ totalDept mvar' d
        return mvar'
    dusTotals <- takeAllMVars mvars
    putMVar mvar $ totalEmployee m  + sum dusTotals + sum (map totalEmployee eus)
        
totalEmployee :: Employee -> Float 
totalEmployee (Employee _ _ salary) = salary
