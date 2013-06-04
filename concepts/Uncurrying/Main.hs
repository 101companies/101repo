import Prelude hiding (uncurry)

add :: Num a => (a, a) -> a
add (x,y) = x + y

uncurry :: (a -> b -> c) -> (a, b) -> c
uncurry f (a,b) = f a b

add' :: Num a => (a, a) -> a
add' = uncurry (+)
