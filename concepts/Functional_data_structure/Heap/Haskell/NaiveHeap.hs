module NaiveHeap where

import Heap
import Tree

-- A non-self-adjusting implementation of heaps
heap :: Ord e => Heap e Tree
heap = Heap {
  empty = Empty,
  insert = \x t -> merge' (Node x Empty Empty) t,
  findMin = \t -> case t of
    Empty -> Nothing
    (Node x _ _) -> Just x,
  deleteMin = \t -> case t of
    Empty -> Nothing
    (Node _ l r) -> Just (merge' l r),
  merge = \l r -> case (l, r) of
    (Empty, t) -> t
    (t, Empty) -> t
    (t1@(Node x1 l1 r1), t2@(Node x2 l2 r2)) ->
      if x1 <= x2
        then Node x1 (merge' l1 r1) t2
        else Node x2 t1 (merge' l2 r2)
}
  where merge' = merge heap