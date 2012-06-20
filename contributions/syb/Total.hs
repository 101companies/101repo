module Total where

import Company
import Deriving
import Data.Generics

total :: Company -> Float
total = everything (+) (extQ (const 0) id)
