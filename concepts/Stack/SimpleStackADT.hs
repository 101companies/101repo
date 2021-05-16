{-| A simple implementation of stacks in Haskell -}

module SimpleStackADT (
  Stack,
  empty,
  isEmpty,
  push,
  top,
  pop,
  size
) where

-- | Data structure for representation of stacks
data Stack a = Empty | Push a (Stack a)
 
{- Operations on stacks -}
 
-- | Return the empty stack
empty :: Stack a
empty = Empty
 
-- | Test for the empty stack
isEmpty :: Stack a -> Bool
isEmpty Empty = True
isEmpty (Push _ _) = False
 
-- | Push an element onto the stack
push :: a -> Stack a -> Stack a
push = Push
 
-- | Retrieve the top-of-stack, if available
top :: Stack a -> Maybe a
top Empty = Nothing
top (Push x s) = Just x
 
-- | Remove the top-of-stack, if available
pop :: Stack a -> Maybe (Stack a)
pop Empty = Nothing
pop (Push x s) = Just s

-- | Compute size of stack
size :: Stack a -> Int
size Empty = 0
size (Push _ s) = 1 + size s
