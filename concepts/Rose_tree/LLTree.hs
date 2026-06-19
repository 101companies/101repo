-- import Data.Foldable(toList)

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
    -- foldr f z (Fork ts) = foldr f z (concat (fmap toList ts))
    foldr f z (Fork ts) = foldr (\t acc -> foldr f acc t) z ts

{-

ghci> sampleLLTree 
Fork [Leaf 1,Fork [Leaf 2],Leaf 3]
ghci> fmap ((+)1) sampleLLTree 
Fork [Leaf 2,Fork [Leaf 3],Leaf 4]
ghci> foldr (+) 0 sampleLLTree 
6

-}
