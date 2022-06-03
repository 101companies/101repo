{-| 

An opaque list-based implementation of stacks in Haskell.
That is, the representation type is hidden.
The size of the stack is readily maintained.
Thus, the size can be returned without traversing the stack.

-}

module StacksWithConstantTimeSize (
  Stack,
  empty,
  push,
  isEmpty,
  size,
  top,
  pop
) where

-- | Data structure for representation of stacks
data Stack a = Stack { getStack :: [a], getSize :: Int }
 
{- Operations on stacks -}
 
-- | Return the empty stack
empty :: Stack a
empty = Stack [] 0
 
-- | Push an element onto the stack
push :: a -> Stack a -> Stack a
push x s
  = Stack { 
      getStack = x : getStack s,
      getSize = getSize s + 1
    }


-- | Test for the empty stack
isEmpty :: Stack a -> Bool
isEmpty = null . getStack

-- | Compute size of stack
size :: Stack a -> Int
size = getSize

-- | Retrieve the top-of-stack, if available
top :: Stack a -> a
top s =
  let l = getStack s in
    head l
 
-- | Remove the top-of-stack, if available
pop :: Stack a -> Stack a
pop s =
  let l = getStack s in
        Stack {
          getStack = tail l,
          getSize = getSize s - 1
        }

