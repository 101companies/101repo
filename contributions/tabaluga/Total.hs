module Total where

import Company
import CompanyAlgebra
import Data.Monoid

total :: Company -> Float
total = getSum . foldCompany totalAlgebra
 where
  totalAlgebra
    = mconcatCompany {
        atEmployee = \n a s -> Sum s     
      }
