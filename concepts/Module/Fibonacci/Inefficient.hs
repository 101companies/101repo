module Fibonacci.Inefficient where

-- The Fibonacci numbers
fib :: Int -> Int
fib 0 = 0 
fib 1 = 1
fib x = fib (x-2) + fib (x-1)

