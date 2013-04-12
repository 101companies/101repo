{- A simple implementation of stacks in Haskell -}

module Stack (
  Stack,
  empty,
  isEmpty,
  push,
  top,
  pop
) where

-- Data structure for representation of stacks
data Stack = Empty | Push Int Stack
 
{- Operations on stacks -}
 
-- Return the empty stack
empty = Empty
 
-- Test for the empty stack
isEmpty :: Stack -> Bool
isEmpty Empty = True
isEmpty (Push _ _) = False
 
-- Push an element onto the stack
push :: Int -> Stack -> Stack
push x s = Push x s
 
-- Retrieve the top-of-stack, if available
top :: Stack -> Int
top (Push x s) = x
 
-- Remove the top-of-stack, if available
pop :: Stack -> Stack
pop (Push x s) = s
