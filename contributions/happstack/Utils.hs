module Utils where
 
import Company
import Focus

flattenDeptsC :: Company -> [Department]
flattenDeptsC = concat.(map flattenDeptsD).depts

flattenDeptsD :: Department -> [Department]
flattenDeptsD d = d : (concat $ map flattenDeptsD $ dus d)
    
    
flattenEmployeesC :: Company -> [Employee]
flattenEmployeesC = concat.(map flattenEmployeesD).depts

flattenEmployeesD :: Department -> [Employee]
flattenEmployeesD d = manager d : eus d ++ (concat $ map flattenEmployeesD $ dus d)   