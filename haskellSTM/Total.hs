module Total where

import Control.Concurrent
import Control.Concurrent.STM
import Control.Monad

import Company
import CompanySTM
import Types
import Focus

type TTotal = TMVar Float

total :: Company -> IO Float
total c = startTransactions c 0.0 (addSalary c)


-- transaction from one salary in a list of salary to a total of salariesTEST
addSalary :: Company -> TFocusProgress -> TTotal -> STM Bool
addSalary c tprogress ttotal = companyTransaction c tprogress ttotal f 
    where f c currentFocus currentTotal = currentTotal + (salary (readEM currentFocus c))