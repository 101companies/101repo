{-| 

An opaque list-based implementation of stacks in Haskell.
That is, the representation type is hidden.
The size of the stack is readily maintained.
Thus, the size can be returned without traversing the stack.

-}

module StacksWithConstantTimeSize (
  Stack,
  empty,
  isEmpty,
  push,
  top,
  pop,
  size
) where

-- | Data structure for representation of stacks
data Stack a = Stack { getStack :: [a], getSize :: Int }
 
{- Operations on stacks -}
 
-- | Return the empty stack
empty :: Stack a
empty = Stack [] 0
 
-- | Test for the empty stack
isEmpty :: Stack a -> Bool
isEmpty = null . getStack
 
-- | Push an element onto the stack
push :: a -> Stack a -> Stack a
push x s
  = Stack { 
      getStack = x : getStack s,
      getSize = getSize s + 1
    }
 
-- | Retrieve the top-of-stack, if available
top :: Stack a -> Maybe a
top s =
  let l = getStack s in
    if null l then Nothing else Just (head l) 
 
-- | Remove the top-of-stack, if available
pop :: Stack a -> Maybe (Stack a)
pop s =
  let l = getStack s in
    if null l
      then Nothing
      else Just (
        Stack {
          getStack = tail l,
          getSize = getSize s - 1
        }
      )

-- | Compute size of stack
size :: Stack a -> Int
size = getSize
