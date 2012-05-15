data A = A1 Int | A2 Bool | A3 A
 deriving (Read,Show,Eq)
data B = B1 Bool | B2 Int | B3 A
 deriving (Read,Show,Eq)
data C = C B
 deriving (Read,Show,Eq)

f :: Int -> Int
f = id

g = g'

g' :: Bool -> Int
g' True = 1
g' False = 0

h :: Bool -> Bool
h True = False
h False = True

