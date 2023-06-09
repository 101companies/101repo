module StackImplType(StackImpl(..)) where

-- An "interface" for stack operations grouped as a data structure
data StackImpl s a =
  StackImpl {
    getEmpty :: s a,
    getPush :: a -> s a -> s a,
    getPop :: s a -> s a,
    getTop :: s a -> a,
    getIsEmpty :: s a -> Bool,
    getSize :: s a -> Int
  }
