module Total where

import Company
import Data.Generics

total :: Company -> Float
total = everything (+) (extQ (const 0) id)
