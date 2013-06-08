data LLTree a = Leaf a | Fork [LLTree a]
  deriving (Eq, Show, Read)

sampleTree = 
  Fork [
    Leaf 1,
    Fork [Leaf 2],
    Leaf 3]
