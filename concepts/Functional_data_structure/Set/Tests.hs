module Main where

import Set
import NaiveSet as Naive
import BinarySearchTree as BST
import Test.HUnit
import System.Exit

-- All tests for all implementations
tests :: Test
tests = TestList (tests' Naive.set ++ tests' BST.set)

-- All tests for one implementation
tests' :: Set Int s -> [Test]
tests' i = [
    TestLabel "testEmpty1" (testEmpty1 i),
    TestLabel "testSingle1" (testSingle1 i),
    TestLabel "testSingle2" (testSingle2 i),
    TestLabel "testBigger1" (testBigger1 i),
    TestLabel "testBigger2" (testBigger2 i),
    TestLabel "testBigger3" (testBigger3 i),
    TestLabel "testBigger4" (testBigger4 i)
  ]

-- Test search to fail for empty set
testEmpty1 i = False ~=? search i 42 (emptySet i)

-- Test search to succeed for singleton set 
testSingle1 i = True ~=? search i 42 (singletonSet i)

-- Test search to fail for singleton set 
testSingle2 i = False ~=? search i 0 (singletonSet i)

-- Test search to succeed in one way
testBigger1 i = True ~=? search i 42 (biggerSet i)

-- Test search to succeed in another way
testBigger2 i = True ~=? search i 37 (biggerSet i)

-- Test search to succeed in yet another way
testBigger3 i = True ~=? search i 88 (biggerSet i)

-- Test search to fail on a bigger set
testBigger4 i = False ~=? search i 0 (biggerSet i)

-- Empty set
emptySet :: Set Int s -> s Int
emptySet i = empty i

-- Singleton set of 42
singletonSet :: Set Int s -> s Int
singletonSet i = insert i 42 (empty i)

-- "Bigger" set
biggerSet :: Set Int s -> s Int
biggerSet i
  = insert i 88
  $ insert i 37 
  $ insert i 42 
  $ empty i

-- Run all tests and communicate through exit code
main = do
 counts <- runTestTT tests
 if (errors counts > 0 || failures counts > 0)
   then exitFailure
   else exitSuccess
