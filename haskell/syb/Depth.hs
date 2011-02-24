module Depth where

import Company
import Data.Generics


-- Computing nesting depth of departments

depth :: Company -> Int
depth = depth'
 where
  depth' :: GenericQ Int
  depth' x = recurse x
           + mkQ 0 atDept x
   where
    recurse :: GenericQ Int
    recurse = foldr max 0 . gmapQ depth'
    atDept :: Dept -> Int
    atDept = const 1
