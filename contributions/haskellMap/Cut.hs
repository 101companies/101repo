module Cut where

import Company

cut :: Company -> Company
cut (n, ds) = (n, (map dep ds))
 where
  dep :: Department -> Department
  dep (n, m, es)
   = (n, (emp m), (map emp es))
   where
    emp :: Employee -> Employee
    emp (n, a, s) = (n, a, (s/2))
