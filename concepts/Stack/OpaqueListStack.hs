{-| 

An opaque list-based implementation of stacks in Haskell.
That is, the representation type is hidden. 

-}

module OpaqueListStack (
  Stack,
  empty,
  isEmpty,
  push,
  top,
  pop,
  size
) where

-- | Data structure for representation of stacks
newtype Stack = Stack { getStack :: [Int] }
 
{- Operations on stacks -}
 
-- | Return the empty stack
empty :: Stack
empty = Stack []
 
-- | Test for the empty stack
isEmpty :: Stack -> Bool
isEmpty = null . getStack
 
-- | Push an element onto the stack
push :: Int -> Stack -> Stack
push x s = Stack ( x : getStack s)
 
-- | Retrieve the top-of-stack, if available
top :: Stack -> Int
top = head . getStack
 
-- | Remove the top-of-stack, if available
pop :: Stack -> Stack
pop = Stack . tail . getStack

-- | Compute size of stack
size :: Stack -> Int
size = length . getStack
