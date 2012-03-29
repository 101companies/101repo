module SalaryFlattener (flattenSalaries, consumeSalaries) where

import Prelude hiding (Float)
import Data.Array.Parallel.Prelude.Float

import Company
import SampleCompany

-- flat the company tree to a flat salary list
flattenSalaries :: Company -> [Float]
flattenSalaries = concat.(map fsDept).depts

fsDept :: Department -> [Float]
fsDept (Department _ m sus) = concat [ fsEmployee m 
                                     , concat (map fsSubUnit sus)
                                     ]

fsSubUnit :: SubUnit -> [Float]                                     
fsSubUnit (EUnit e) = fsEmployee e
fsSubUnit (DUnit d) = fsDept d

fsEmployee :: Employee -> [Float]
fsEmployee (Employee _ _ s) = [s]
    
            
-- consume a salary list by setting new salaries

consumeSalaries :: Company -> [Float] -> Company 
consumeSalaries (Company n ds) ss = Company n ((reverse.fst) nds)
  where
    nds = foldl (\(nds',ss') d -> (fst (csDepartment d ss') : nds', snd (csDepartment d ss'))) ([],ss) ds  

csDepartment :: Department -> [Float] -> (Department, [Float])
csDepartment (Department n m sus) ss = (Department n (fst nm) ((reverse.fst) nsus), snd nsus) 
  where
    nm = csEmployee m ss
    nsus = foldl (\(nsus',ss') su -> (fst (csSubUnit su ss') : nsus',snd (csSubUnit su ss'))) ([],(snd nm)) sus

csSubUnit :: SubUnit -> [Float] -> (SubUnit, [Float])        
csSubUnit (EUnit e) ss = (EUnit (fst ne), (snd ne))
  where
    ne = csEmployee e ss
csSubUnit (DUnit d) ss = (DUnit (fst nd), (snd nd))
  where
    nd = csDepartment d ss

csEmployee :: Employee -> [Float] -> (Employee, [Float])
csEmployee (Employee m a _) ss = ((Employee m a (head ss)), (tail ss))



