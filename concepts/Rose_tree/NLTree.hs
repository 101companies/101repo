data NLTree a = NLTree a [NLTree a]
  deriving (Eq, Show, Read)

sampleTree = 
  NLTree 1 [
    NLTree 2 [],
    NLTree 3 [NLTree 4 []],
    NLTree 5 []]
