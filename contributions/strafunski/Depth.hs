module Depth where

import Company
import Deriving
import Data.Monoid
import Control.Monad.Identity
import Data.Generics.Strafunski.StrategyLib.StrategyPrelude

depth :: Company -> Int
depth = runIdentity . applyTU depth'
  where
    depth' :: TU Int Identity
    depth' = op2TU (+) recurse (constTU 0 `adhocTU` atDept)
      where
        recurse :: TU Int Identity
        recurse = allTU max 0 depth'
        atDept :: Department -> Identity Int
        atDept = const $ return 1
