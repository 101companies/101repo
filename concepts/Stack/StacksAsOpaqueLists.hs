{-| 

An opaque list-based implementation of stacks in Haskell.
That is, the representation type is hidden. 

-}

module StacksAsOpaqueLists (
  Stack,
  empty,
  push,
  isEmpty,
  size,
  top,
  pop
) where

-- | Data structure for representation of stacks
newtype Stack a = Stack { getStack :: [a] }
 
{- Operations on stacks -}
 
-- | Return the empty stack
empty :: Stack a
empty = Stack []
 
-- | Push an element onto the stack
push :: a -> Stack a -> Stack a
push x s = Stack ( x : getStack s)

-- | Test for the empty stack
isEmpty :: Stack a -> Bool
isEmpty = null . getStack

-- | Compute size of stack
size :: Stack a -> Int
size = length . getStack

-- | Retrieve the top-of-stack, if available
top :: Stack a -> Maybe a
top s =
  let l = getStack s in
    if null l then Nothing else Just (head l) 
 
-- | Remove the top-of-stack, if available
pop :: Stack a -> Maybe (Stack a)
pop s =
  let l = getStack s in
    if null l then Nothing else Just (Stack (tail l)) 
