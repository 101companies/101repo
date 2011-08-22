module Utils where
 
import Company
import API

flattenDeptsC :: Company -> [Department]
flattenDeptsC = concat.(map flattenDeptsD).getDepts

flattenDeptsD :: Department -> [Department]
flattenDeptsD d = d : (concat $ map flattenDeptsD $ getDus d)
    
    
flattenEmployeesC :: Company -> [Employee]
flattenEmployeesC = concat.(map flattenEmployeesD).getDepts

flattenEmployeesD :: Department -> [Employee]
flattenEmployeesD d = getManager d : getEus d ++ (concat $ map flattenEmployeesD $ getDus d)   