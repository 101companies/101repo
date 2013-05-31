import Prelude hiding (foldr, foldl)

-- The higher-order function foldr for lists
foldr :: (a -> b -> b) -> b -> [a] -> b
foldr f z []     = z 
foldr f z (x:xs) = f x (foldr f z xs)

-- The higher-order function foldl for lists
foldl :: (b -> a -> b) -> b -> [a] -> b
foldl f z []     = z 
foldl f z (x:xs) = foldl f (f z x) xs
