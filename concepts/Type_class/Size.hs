-- Notions of size for container types
class Size f
  where
    -- Number of constructors
    consSize :: f a -> Int
    -- Number of elements
    elemSize :: f a -> Int

instance Size []
  where
    consSize = (+1) . length
    elemSize = length

-- Node-labeled rose trees
data NLTree a = NLTree a [NLTree a]
  deriving (Eq, Show, Read)

instance Size NLTree
  where
    consSize (NLTree _ ts) =
        1
      + consSize ts
      + sum (map consSize ts)
    elemSize (NLTree _ ts) =
        1
      + sum (map elemSize ts)

-- Leaf-labeled rose trees
data LLTree a = Leaf a | Fork [LLTree a]
  deriving (Eq, Show, Read)

instance Size LLTree
  where
    consSize (Leaf _) = 1
    consSize (Fork ts) =
        consSize ts
      + sum (map consSize ts)
    elemSize (Leaf _) = 1
    elemSize (Fork ts) =
      sum (map elemSize ts)

{-

*Main> let list = [1,2,3]
*Main> let nltree = NLTree 1 [NLTree 2 [], NLTree 3 []]
*Main> let lltree = Fork [Leaf 1, Fork [Leaf 2, Leaf 3]]
*Main> consSize list
4
*Main> elemSize list
3
*Main> consSize nltree 
8
*Main> elemSize nltree 
3
*Main> consSize lltree 
9
*Main> elemSize lltree 
3

-}