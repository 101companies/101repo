module Cut where

import Company
import CompanyAlgebra

cut :: Company -> Company
cut = foldCompany cutAlgebra
 where
  cutAlgebra
    = mapCompany {
        atEmployee = \n a s -> Employee n a (s/2)      
      }
