import Prelude hiding (filter)

-- Define filter via pattern matching
filter :: (a -> Bool) -> [a] -> [a]
filter p [] = []
filter p (x:xs) = if p x then x : ys else ys
  where
    ys = filter p xs

-- Define filter via foldr
filter' p = foldr f []
  where
    f x = if p x then (:) x else id

-- Define filter via list comprehension
filter'' :: (a -> Bool) -> [a] -> [a]
filter'' p xs = [ x | x <- xs, p x]

