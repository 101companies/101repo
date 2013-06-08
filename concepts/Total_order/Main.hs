-- Peano natural numbers
data Nat = Zero | Succ Nat

-- Equality of natural numbers
instance Eq Nat
  where
    Zero == Zero = True
    Zero == (Succ _) = False
    (Succ _) == Zero = False
    (Succ x) == (Succ y) = x == y

-- Total order on natural numbers
instance Ord Nat
  where
    compare Zero Zero = EQ
    compare Zero (Succ _) = LT
    compare (Succ _) Zero = GT
    compare (Succ x) (Succ y) = compare x y
