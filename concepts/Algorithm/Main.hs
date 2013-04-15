import Prelude hiding (gcd)

-- Operands are supposed to be positive integers.
gcd :: Int -> Int -> Int
gcd x y | x > y = gcd (x-y) y
        | x < y = gcd x (y-x)
	| otherwise = x

main = print $ gcd 15 6
