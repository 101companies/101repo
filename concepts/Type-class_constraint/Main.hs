{- Demonstration of type-class constraints based on Prelude code -}

import Prelude hiding (Eq, (==))

-- A type class for equality
class Eq a
  where
    (==) :: a -> a -> Bool

-- Equality of pairs
instance (Eq a, Eq b) => Eq (a,b)
  where
    x == y = fst x == fst y && snd x == snd y

-- A type class for total order (comparison)
class Eq a => Ord a where
  compare :: a -> a -> Ordering
  (<) :: a -> a -> Bool
  (>=) :: a -> a -> Bool
  (>) :: a -> a -> Bool
  (<=) :: a -> a -> Bool
  max :: a -> a -> a
  min :: a -> a -> a

