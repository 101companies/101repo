module Depth where

import Company
import CompanyAlgebra
import Data.Monoid

depth :: Company -> Int
depth = getPosMax . foldCompany depthAlgebra
  where
    depthAlgebra :: CompanyAlgebra (PosMax Int) (PosMax Int) (PosMax Int)
    depthAlgebra
      = mconcatCompany {
          atCompany = \n ds -> mconcat ds,
          atDepartment = \n _ ds es -> PosMax (1 + getPosMax (mconcat ds))
        }


-- The monoid for maxima on non-negative numbers

data (Ord x, Num x) => PosMax x = PosMax { getPosMax :: x }

instance (Ord x, Num x) => Monoid (PosMax x)
  where
    mempty = PosMax 0
    x `mappend` y = PosMax (getPosMax x `max` getPosMax y)
