module Cut where

import Control.Concurrent
import Control.Concurrent.STM
import Control.Monad

import Company
import CompanySTM
import Types
import Focus

type TCompany = TMVar Company

cut :: Company -> IO Company
cut c = startTransactions c c cutSalary

-- transaction from one salary in a list of salary to a total of salariesTEST
cutSalary :: TFocusProgress -> TCompany -> STM Bool
cutSalary tprogress tcompany = do
    currentCompany <- readTMVar tcompany
    companyTransaction currentCompany tprogress tcompany f 
    where 
        f _ currentFocus currentCompany = (writeEM currentFocus currentCompany) (cutEmployee $ readEM currentFocus currentCompany)
        cutEmployee (Employee n a s) = Employee n a (s/2)

