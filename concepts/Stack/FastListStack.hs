{-| 

An opaque list-based implementation of stacks in Haskell.
That is, the representation type is hidden.
The size of the stack is readily maintained.
Thus, the size can be returned with traversing the stack.

-}

module FastListStack (
  Stack,
  empty,
  isEmpty,
  push,
  top,
  pop,
  size
) where

-- | Data structure for representation of stacks
data Stack = Stack { getStack :: [Int], getSize :: Int }
 
{- Operations on stacks -}
 
-- | Return the empty stack
empty :: Stack
empty = Stack [] 0
 
-- | Test for the empty stack
isEmpty :: Stack -> Bool
isEmpty = null . getStack
 
-- | Push an element onto the stack
push :: Int -> Stack -> Stack
push x s
  = Stack { 
      getStack = x : getStack s,
      getSize = getSize s + 1
    }
 
-- | Retrieve the top-of-stack, if available
top :: Stack -> Int
top = head . getStack
 
-- | Remove the top-of-stack, if available
pop :: Stack -> Stack
pop s
  = Stack {
      getStack = tail (getStack s),
      getSize = getSize s - 1
    }

-- | Compute size of stack
size :: Stack -> Int
size = getSize
