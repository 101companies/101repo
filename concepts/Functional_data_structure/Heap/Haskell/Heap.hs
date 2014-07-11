module Heap where

-- A signature for min-heaps
data Heap e t = Heap {
  empty :: t e,
  insert :: e -> t e -> t e,
  findMin :: t e -> Maybe e,
  deleteMin :: t e -> Maybe (t e),
  merge :: t e -> t e -> t e
}
