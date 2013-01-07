module Total where

import Company

total :: Company -> Float
total (n, ds) = totalDs ds

totalDs :: [Department] -> Float
totalDs [] = 0
totalDs (d:ds) = totalD d + totalDs ds

totalD :: Department -> Float
totalD (_, m, es) = totalE m + totalEs es

totalEs :: [Employee] -> Float
totalEs [] = 0
totalEs (e:es) = totalE e + totalEs es

totalE :: Employee -> Float
totalE (_, _, s) = s
