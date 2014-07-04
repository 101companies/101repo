import Prelude hiding (foldr, foldr1, foldl1)
import qualified Prelude (foldr, foldr1, foldl1)
import Data.Monoid

class Foldable t
  where
    fold :: Monoid m => t m -> m
    foldMap :: Monoid m => (a -> m) -> t a -> m
    foldr :: (a -> b -> b) -> b -> t a -> b
    foldl :: (a -> b -> a) -> a -> t b -> a
    foldr1 :: (a -> a -> a) -> t a -> a
    foldl1 :: (a -> a -> a) -> t a -> a
    fold = foldr mappend mempty
    foldMap f = foldr (mappend . f) mempty
    foldr f z = foldr f z . toList
    foldl f z q = foldr (\x g a -> g (f a x)) id q z
    foldr1 f = foldr1 f . toList
    foldl1 f = foldl1 f . toList

instance Foldable []
  where
    foldr = Prelude.foldr

toList :: Foldable t => t a -> [a]
toList = foldMap (\x->[x])
