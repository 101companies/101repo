module Fibonacci.Efficient (
  fib
) where

-- The Fibonacci numbers
fib :: Int -> Int
fib x = fib2 x 0 1

-- Helper function for efficient Fibonacci numbers
fib2 :: Int -> Int -> Int -> Int
fib2 0 y _ = y
fib2 1 _ y = y
fib2 x y1 y2 = fib2 (x-1) y2 (y1+y2)

