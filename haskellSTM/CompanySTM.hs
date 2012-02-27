module CompanySTM where

import Control.Concurrent
import Control.Concurrent.STM
import Control.Monad

import Types
import Company
import Focus

startTransactions :: Company -> b -> (TFocusProgress -> TMVar b -> STM Bool) -> IO b
startTransactions c initb trans = do
    case firstEmployeeFocus c of
        (Just firstFocus) -> do
            tprogress <- newTMVarIO (Do firstFocus)
            tb <- newTMVarIO initb
            forM [1..3] $ \_ -> 
                forkIO $ repeatTransaction (trans tprogress tb)
            atomically $ getResult tprogress tb
        Nothing -> return initb

getResult :: TFocusProgress -> TMVar a -> STM a
getResult tprogress ta = do
    currentProgress <- readTMVar tprogress
    case currentProgress of
        (Do _) -> retry
        Done    -> do
            result <- readTMVar ta
            return result

-- generic company transaction based on a step-wise focus
companyTransaction :: Company -> TFocusProgress -> TMVar b -> (Company -> Focus -> b -> b) -> STM Bool
companyTransaction c tprogress tb f = do
    currentProgress <- readTMVar tprogress
    case currentProgress of
        (Do currentFocus) -> do
            currentB <- readTMVar tb
            let newB = f c currentFocus currentB
            swapTMVar tb newB
            case nextEmployeeFocus c currentFocus of
                Just newFocus -> do
                    swapTMVar tprogress (Do newFocus)
                    return False
                Nothing -> do
                    swapTMVar tprogress Done
                    return True
        Done -> return False

repeatTransaction :: STM Bool -> IO ()
repeatTransaction t = do
	done <- atomically t
	unless done $ repeatTransaction t