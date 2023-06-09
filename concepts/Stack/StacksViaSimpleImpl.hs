{-| The simple implementation of stacks in Haskell, repackaged as record -}

module StacksViaSimpleImpl (
  Stack,
  empty,
  push,
  isEmpty,
  size,
  top,
  pop
) where

import qualified SimpleStackADT as Simple
import StackImpl (StackImpl(..), simpleImpl)

-- | Data structure for representation of stacks
type Stack a = Simple.Stack a

{- Operations on stacks -}
 
-- | Return the empty stack
empty :: Stack a
empty = getEmpty simpleImpl
 
-- | Push an element onto the stack
push :: a -> Stack a -> Stack a
push = getPush simpleImpl

-- | Test for the empty stack
isEmpty :: Stack a -> Bool
isEmpty = getIsEmpty simpleImpl

-- | Compute size of stack
size :: Stack a -> Int
size = getSize simpleImpl

-- | Retrieve the top-of-stack, if available
top :: Stack a -> a
top = getTop simpleImpl

-- | Remove the top-of-stack, if available
pop :: Stack a -> Stack a
pop = getPop simpleImpl
