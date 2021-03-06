{-| 

A leaky list-based implementation of stacks in Haskell.
That is, the representation type is not hidden.

-}

module StacksAsLists (
  Stack,
  empty,
  push,
  isEmpty,
  size,
  top,
  pop
) where

-- | Data structure for representation of stacks
type Stack a = [a]
 
{- Operations on stacks -}
 
-- | Return the empty stack
empty :: Stack a
empty = []
 
-- | Push an element onto the stack
push :: a -> Stack a -> Stack a
push = (:)

-- | Test for the empty stack
isEmpty :: Stack a -> Bool
isEmpty = null

-- | Compute size of stack
size :: Stack a -> Int
size = length

-- | Retrieve the top-of-stack, if available
top :: Stack a -> Maybe a
top s = if null s then Nothing else Just (head s)
 
-- | Remove the top-of-stack, if available
pop :: Stack a -> Maybe (Stack a)
pop s = if null s then Nothing else Just (tail s)
