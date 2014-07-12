import Prelude hiding (Functor)

-- We do NOT import Data.Monoid so that we can reconstruct things.

class Functor f 
  where
    fmap :: (a -> b) -> f a -> f b

instance Functor []
  where
    fmap = map

instance Functor Maybe
  where
    fmap _ Nothing = Nothing
    fmap f (Just x) = Just (f x)
