module Main where

import Heap
import Tree
import NaiveHeap as Naive
import SkewHeap as Skew
import Test.HUnit
import System.Exit

-- All tests for all implementations
tests :: Test
tests = TestList (tests' Naive.heap ++ tests' Skew.heap)

-- All tests for one implementation
tests' :: Heap Int Tree -> [Test]
tests' i = [
    TestLabel "testEmptyFind" (testEmptyFind i),
    TestLabel "testEmptyDelete" (testEmptyDelete i),
    TestLabel "testSingletonFind" (testSingletonFind i),
    TestLabel "testSingletonDelete" (testSingletonDelete i),
    TestLabel "testBigger" (testBigger i),
    TestLabel "testWikipedia" (testWikipedia i),
    TestLabel "testOkasaki" (testOkasaki i),
    TestLabel "testAndy" (testAndy i),
    TestLabel "testInserts" (testInserts i)
  ]

-- Test findMin on empty heap
testEmptyFind i = Nothing ~=? findMin i (emptyHeap i)

-- Test deleteMin on empty heap
testEmptyDelete i = Nothing ~=? deleteMin i (emptyHeap i)

-- Test findMin on singleton heap
testSingletonFind i = Just 42 ~=? findMin i (singletonHeap i)

-- Test deleteMin on singleton heap
testSingletonDelete i = Just (emptyHeap i) ~=? deleteMin i (singletonHeap i)

-- Test find/deleteMin on a bigger heap
testBigger i = [1,2,3,4,5] ~=? heap2list i (biggerHeap i)

-- Test find/deleteMin on a Wikipedia example
testWikipedia i = [1,4,13,17,23,24,28,44,49,57,63,99,105,201] ~=? heap2list i (wikipediaHeap i)

-- Test find/deleteMin on another example
testOkasaki i = [1,2,3,4,5,6,7,8,9] ~=? heap2list i (okasakiHeap i)

-- Test find/deleteMin on another example
testAndy i = [1,6,9,12,13,14,15,18,21,25,30,40,51] ~=? heap2list i (andyHeap i)

-- Test balancing of insertion
testInserts i = [1,2,3,4,5,6,6,6,6,6] ~=? heap2list i (insertHeap i)

-- Empty heap
emptyHeap :: Heap Int i -> i Int
emptyHeap i = empty i

-- Singleton heap of 42
singletonHeap :: Heap Int i -> i Int
singletonHeap i = insert i 42 (empty i)

-- "Bigger" heap
biggerHeap :: Heap Int i -> i Int
biggerHeap i
  = insert i 3
  $ insert i 1 
  $ insert i 4 
  $ insert i 2
  $ insert i 5 
  $ empty i

{-
Example on Wikipedia: http://en.wikipedia.org/wiki/Skew_heap
9 July 2014
-}

wikipediaHeap i = merge i wikipediaHeap1 wikipediaHeap2

wikipediaHeap1 =
  Node 1
    (Node 4 (leaf 63) (leaf 24))
    (Node 23 (leaf 44) (leaf 28))

wikipediaHeap2 =
  Node 13
    (Node 17 (leaf 57) (leaf 49))
    (Node 99 (leaf 105) (leaf 201))

{-
Example from Okasaki's handbook chapter on functional data structures
-}

okasakiHeap i = merge i okasakiHeap1 okasakiHeap2

okasakiHeap1 =
  Node 1
    (leaf 6)
    (Node 2 (leaf 7) (leaf 5))

okasakiHeap2 =
  Node 3
    (leaf 8)
    (Node 4 (leaf 9) Empty)

{-
Example by Andranik Mirzaian: http://www.cse.yorku.ca/~andy/courses/4101/lecture-notes/LN5.pdf
9 July 2014
-}

andyHeap i = merge i andyHeap1 andyHeap2

andyHeap1 =
  Node 1 
    (leaf 51)
    (Node 9 
      (Node 13 Empty (leaf 15))
      (Node 21 (leaf 25) Empty))

andyHeap2 =
  Node 6 
    (Node 18 (leaf 40) Empty)
    (Node 12 (leaf 30) (leaf 14)) 

-- Construct a heap from a sequence of numbers
insertHeap i = list2heap i [5, 6, 4, 6, 3, 6, 2, 6, 1, 6]

-- Run all tests and communicate through exit code
main = do
 counts <- runTestTT tests
 if (errors counts > 0 || failures counts > 0)
   then exitFailure
   else exitSuccess
