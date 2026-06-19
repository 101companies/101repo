-- import Data.Foldable(toList) -- Let's define it ourselves!

-- If we can foldMap, then we can serialize to lists.
toList :: Foldable t => t a -> [a]
toList = foldMap (\x -> [x])

-- BTW, foldMap can, of course, be defined in terms of foldr.
myFoldMap :: (Foldable t, Monoid m) => (a -> m) -> t a -> m
myFoldMap f = foldr g z
 where
  g x y = f x `mappend` y
  z = mempty

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
    -- Exercise: Why does the following recursive definition not diverge?
    -- foldr f z (NLTree x ts) = foldr f z (x : concat (fmap toList ts))
    -- Anyways, let's avoid the auxiliary lists!
    foldr f z (NLTree x ts) = x `f` foldr (\t acc -> foldr f acc t) z ts

{-

ghci> sampleNLTree 
NLTree 1 [NLTree 2 [],NLTree 3 [NLTree 4 []],NLTree 5 []]
ghci> fmap ((+)1) sampleNLTree 
NLTree 2 [NLTree 3 [],NLTree 4 [NLTree 5 []],NLTree 6 []]
ghci> foldr (*) 1 sampleNLTree 
120

-}
