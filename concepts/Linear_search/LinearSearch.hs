module LinearSearch where

-- Polymorphic linear search
search :: Eq a => [a] -> a -> Bool
search [] _ = False
search (x:xs) y = x==y || search xs y
