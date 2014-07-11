module SkewHeap where

import Heap
import Tree

-- An implementation of self-adjusting heaps
heap :: Ord e => Heap e Tree
heap = Heap {
  empty = Empty,
  insert = \x t -> merge' (Node x Empty Empty) t,
  findMin = \t -> case t of
    Empty -> Nothing
    (Node x _ _) -> Just x,
  deleteMin = \t -> case t of
    Empty -> Nothing
    (Node _ l r) -> Just (merge' r l),
  merge = \l r -> case (l, r) of
    (Empty, t) -> t
    (t, Empty) -> t
    (t1@(Node x1 l1 r1), t2@(Node x2 l2 r2)) ->
      if x1 <= x2
        then Node x1 (merge' t2 r1) l1
        else Node x2 (merge' t1 r2) l2
}
  where merge' = merge heap