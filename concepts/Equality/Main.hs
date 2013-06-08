import Prelude hiding (Eq, (==))

-- A type class for equality
class Eq a
  where
    (==) :: a -> a -> Bool

-- Equality of Booleans
instance Eq Bool
  where
    True == True = True
    False == False = True
    _ == _ = False

-- Equality of lists
instance Eq a => Eq [a]
  where
    x == y =  length x == length y
           && and (map (uncurry (==)) (zip x y))

-- Equality of ints
instance Eq Int
  where
    x == y = case compare x y of
               EQ -> True
               _ -> False
