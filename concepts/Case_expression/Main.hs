import Prelude hiding (length)

length :: [a] -> Int
length [] = 0
length (_:xs) = 1 + length xs

length' :: [a] -> Int
length' l =
  case l of
    [] -> 0
    (_:xs) -> 1 + length' xs
