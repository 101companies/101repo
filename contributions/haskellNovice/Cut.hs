module Cut where

import Company

cut :: Company -> Company
cut (n, ds) = (n, (cutDs ds))

cutDs :: [Department] -> [Department]
cutDs [] = []
cutDs (d:ds) = cutD d : cutDs ds

cutD :: Department -> Department
cutD (n, m, es) = (n, cutE m, cutEs es)

cutEs :: [Employee] -> [Employee]
cutEs [] = []
cutEs (e:es) = cutE e : cutEs es

cutE :: Employee -> Employee
cutE (n, a, s) = (n, a, (s/2))
