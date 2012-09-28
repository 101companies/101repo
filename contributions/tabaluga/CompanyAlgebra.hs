module CompanyAlgebra where

import Company
import Data.Monoid

data CompanyAlgebra c d e = CompanyAlgebra {
  atCompany :: Name -> [d] -> c,
  atDepartment :: Name -> e -> [d] -> [e] -> d,
  atEmployee :: Name -> Address -> Salary -> e
}

foldCompany :: CompanyAlgebra c d e -> Company -> c
foldCompany f (Company n ds) = atCompany f n ds'
 where
  ds' = map (foldDepartment f) ds

foldDepartment :: CompanyAlgebra c d e -> Department -> d
foldDepartment f (Department n m ds es) = atDepartment f n m' ds' es'
 where
  m' = foldEmployee f m
  ds' = map (foldDepartment f) ds
  es' = map (foldEmployee f) es

foldEmployee :: CompanyAlgebra c d e -> Employee -> e
foldEmployee f (Employee n w s) = atEmployee f n w s
 
mapCompany :: CompanyAlgebra Company Department Employee
mapCompany = CompanyAlgebra {
  atCompany = Company,
  atDepartment = Department,
  atEmployee = Employee
}

mconcatCompany ::
    Monoid m 
 => CompanyAlgebra m m m
mconcatCompany = CompanyAlgebra {
  atCompany
        = \n ds ->
             mconcat ds,
  atDepartment 
        = \n m ds es -> 
             mappend m (mappend
                       (mconcat ds)
                       (mconcat es)),
  atEmployee
        = \n w s ->
             mempty
}
