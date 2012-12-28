module Cut where

import Company

cut :: [Employee] -> [Employee]
cut = map (\(e, d, c, a, s, m) -> (e, d, c, a, s/2, m))
