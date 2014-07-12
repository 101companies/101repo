module Tree where

import Heap

data Tree x
  = Empty
  | Node x (Tree x) (Tree x)
    deriving (Eq, Show)

leaf x = Node x Empty Empty

-- Convert a list to a heap
list2heap :: Heap x t -> [x] -> t x
list2heap i = foldl f z
  where
    f = flip $ insert i
    z = empty i

-- Convert a heap to a list
heap2list :: Heap x t -> t x -> [x]
heap2list i t
  = case (findMin i t, deleteMin i t) of
      (Nothing, Nothing) -> []
      (Just x, Just t') -> x : heap2list i t'
