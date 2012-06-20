module Mentoring where

import Prelude hiding (null)
import Company
import Data.Generics hiding (empty)
import Data.Set

-- Check that mentoring constraint hold

mentoring :: Company -> Bool
mentoring c = mentors `isSubsetOf` employees
 where
  mentors :: Set Name
  mentors = everything union (mkQ empty f) c
   where
    f (Employee _ _ _ (Just n)) = singleton n
    f _ = empty
  employees :: Set Name
  employees = everything union (mkQ empty f) c
   where
    f (Employee n _ _ _) = singleton n
    
