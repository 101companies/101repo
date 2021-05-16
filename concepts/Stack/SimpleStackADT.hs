{-| A simple implementation of stacks in Haskell -}

module SimpleStackADT (
  Stack,
  empty,
  push,
  isEmpty,
  size,
  top,
  pop
) where

-- | Data structure for representation of stacks
data Stack a = Empty | Push a (Stack a)
 
{- Operations on stacks -}
 
-- | Return the empty stack
empty :: Stack a
empty = Empty
 
-- | Push an element onto the stack
push :: a -> Stack a -> Stack a
push = Push

-- | Test for the empty stack
isEmpty :: Stack a -> Bool
isEmpty Empty = True
isEmpty (Push _ _) = False

-- | Compute size of stack
size :: Stack a -> Int
size Empty = 0
size (Push _ s) = 1 + size s

-- | Retrieve the top-of-stack, if available
top :: Stack a -> Maybe a
top Empty = Nothing
top (Push x s) = Just x
 
-- | Remove the top-of-stack, if available
pop :: Stack a -> Maybe (Stack a)
pop Empty = Nothing
pop (Push x s) = Just s
