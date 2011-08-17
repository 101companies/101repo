module Cut where
 
import Data.Array.Parallel.PArray
 
import Company
import SalaryFlattener
import CutV

cut :: Company -> Company
cut c = (consumeSalaries c) (toList $ cutV $ fromList $ flattenSalaries c)

