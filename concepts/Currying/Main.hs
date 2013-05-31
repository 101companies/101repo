import Prelude hiding (curry)

inc :: Int -> Int
inc = (+) 1

add :: Num a => (a, a) -> a
add (x,y) = x+y

add' :: Num a => a -> a -> a
add' x y = add (x,y)

curry :: ((a, b) -> c) -> a -> b -> c
curry f a b = f (a,b)

add'' :: Num a => a -> a -> a
add'' = curry add

