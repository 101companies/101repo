module Total where
 
import Data.Array.Parallel.PArray
 
import Company
import SalaryFlattener
import TotalV

total :: Company -> Float
total = totalV.fromList.flattenSalaries

