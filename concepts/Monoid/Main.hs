{- Reconstruction of Monoid bits for better use on the wiki -}

import Prelude hiding (concat, sum)

-- The type class Monoid
class Monoid a
  where
    mempty :: a -- neutral element
    mappend :: a -> a -> a -- associative operation
    mconcat :: [a] -> a -- fold
    mconcat = foldr mappend mempty

-- The Monoid instance for lists
instance Monoid [a]
  where
    mempty = []
    mappend = (++)
    mconcat = concat

-- Appending many lists
concat :: [[a]] -> [a]
concat = foldr (++) []

-- The type of the sum monoid
newtype Sum a = Sum { getSum :: a }

-- The Monoid instance for numbers under addition
instance Num a => Monoid (Sum a)
  where
    mempty = Sum 0
    x `mappend` y = Sum (getSum x + getSum y)

-- A foldr-based definition of sum
sum' :: Num a => [a] -> a
sum' = foldr (+) 0

-- A monoidal definition of sum
sum'' :: Num a => [a] -> a
sum'' = getSum . mconcat . map Sum
