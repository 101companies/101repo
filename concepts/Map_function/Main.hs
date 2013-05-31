import Prelude hiding (map)

-- Define map via pattern matching
map :: (a -> b) -> [a] -> [b]
map f [] = []
map f (x:xs) = f x : map f xs

-- Define map via foldr
map' :: (a -> b) -> [a] -> [b]
map' f = foldr ((:) . f) []

-- Define map via list comprehension
map'' :: (a -> b) -> [a] -> [b]
map'' f xs = [ f x | x <- xs ]
