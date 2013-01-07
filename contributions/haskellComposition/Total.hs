module Total where

import Company

total :: Company -> Float
total (Company n ds) = sum (map dep ds)
  where
   dep :: Department -> Float
   dep (Department _ m ds es)
     = sum (emp m : map dep ds ++ map emp es)
     where
       emp :: Employee -> Float
       emp (Employee _ _ s) = s
