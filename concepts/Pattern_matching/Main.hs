import Prelude hiding (length)

-- Project a pair to first component
fst :: (a,b) -> a
fst (x,_) = x

-- Project a pair to second component
snd :: (a,b) -> b
snd (_,x) = x

-- Retrieve head (first element) of a list
head :: [a] -> a
head (x:_) = x

-- Retrieve tail (all but first element) of a list
tail :: [a] -> [a]
tail (_:xs) = xs

-- Determine length of list
length :: [a] -> Int
length [] = 0
length (_:xs) = length xs + 1

--- Use case instead of equations
length' :: [a] -> Int
length' l = case l of 
              [] -> 0
              (_:xs) -> length' xs + 1
