module Cut where

import Company
import Deriving
import Data.Generics

cut :: Company -> Company
cut = everywhere (extT id (/(2::Float)))
