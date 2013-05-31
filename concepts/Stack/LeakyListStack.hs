{-| 

A leaky list-based implementation of stacks in Haskell.
That is, the representation type is not hidden.

-}

module LeakyListStack (
  Stack,
  empty,
  isEmpty,
  push,
  top,
  pop,
  size
) where

-- | Data structure for representation of stacks
type Stack = [Int]
 
{- Operations on stacks -}
 
-- | Return the empty stack
empty :: Stack
empty = []
 
-- | Test for the empty stack
isEmpty :: Stack -> Bool
isEmpty = null
 
-- | Push an element onto the stack
push :: Int -> Stack -> Stack
push = (:)
 
-- | Retrieve the top-of-stack, if available
top :: Stack -> Int
top = head
 
-- | Remove the top-of-stack, if available
pop :: Stack -> Stack
pop = tail

-- | Compute size of stack
size :: Stack -> Int
size = length
