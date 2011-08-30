module Total(totalLogCompany) where

import Control.Monad.Writer

import Company
import Types             

-- total a company's salaries while logging
totalLogCompany :: Company -> Writer Log Float
totalLogCompany (Company name depts) = do
    tell ["Totaling Company \"" ++ name ++ "\""]           
    totals <- mapM (totalLogDept 1) depts
    tell ["Done totaling Company \"" ++ name ++ "\""]  
    return $ sum totals

totalLogDept :: Int -> Department -> Writer Log Float
totalLogDept n (Department name m dus eus) = do
    tell [replicate n '\t' ++ "Totaling Department \"" ++ name ++ "\""] 
    mTotal <- totalLogEmployee (n + 1) m  
    dusTotals <- mapM (totalLogDept (n + 1)) dus                           
    eusTotals <- mapM (totalLogEmployee (n + 1)) eus
    let ttl = mTotal + (sum dusTotals) + (sum eusTotals)                    
    tell [replicate n '\t' ++ "Done totaling Department \"" ++ name ++ "\". Result = " ++ show ttl]                   
    return ttl   

totalLogEmployee :: Int -> Employee -> Writer Log Float
totalLogEmployee n (Employee name _ sal) = do
    tell [replicate n '\t' ++ ("Totaling Employee \"" ++ name ++ "\"")]
    let ttl = sal
    tell [replicate n '\t' ++ ("Done totaling Employee \"" ++ name ++ "\". Result = " ++ show ttl)]
    return ttl