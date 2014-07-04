import Prelude hiding (foldr, concat)
import Data.Monoid
import Data.Foldable

data LLTree a = Leaf a | Fork [LLTree a]
  deriving (Eq, Show, Read)

sampleLLTree = 
  Fork [
    Leaf 1,
    Fork [Leaf 2],
    Leaf 3]

instance Functor LLTree
  where
    fmap f (Leaf x) = Leaf (f x)
    fmap f (Fork ts) = Fork (fmap (fmap f) ts)

instance Foldable LLTree
  where
    foldr f z (Leaf x) = x `f` z
    foldr f z (Fork ts) = foldr f z (concat (fmap toList ts))
