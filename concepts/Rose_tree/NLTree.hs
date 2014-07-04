import Prelude hiding (foldr, concat)
import Data.Monoid
import Data.Foldable

data NLTree a = NLTree a [NLTree a]
  deriving (Eq, Show, Read)

sampleNLTree = 
  NLTree 1 [
    NLTree 2 [],
    NLTree 3 [NLTree 4 []],
    NLTree 5 []]

instance Functor NLTree
  where
    fmap f (NLTree x ts) = NLTree (f x) (fmap (fmap f) ts)

instance Foldable NLTree
  where
    foldr f z (NLTree x ts) = foldr f z (x : concat (fmap toList ts))
