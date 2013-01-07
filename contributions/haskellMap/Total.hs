module Total where

import Company

total :: Company -> Float
total (n, ds) = sum (map dep ds)
 where
  dep :: Department -> Float
  dep (_, m, es)
   = sum (emp m : map emp es)
   where
    emp :: Employee -> Float
    emp (_, _, s) = s
