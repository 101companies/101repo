module Main where

import Set
import ListSet as LS
import BinarySearchTree as BST
import Criterion
import Criterion.Main
import System.Random

-- | A thousand random numbers between zero and one thousand.
randomNumbers :: [Int]
randomNumbers = take 1000 (randomRs (0,1000) (mkStdGen 23456325))

-- | A set of many random numbers.
evenBiggerSet :: Set Int s -> s Int
evenBiggerSet i = foldr (insert i) (empty i) randomNumbers

-- | Search ten random numbers in a given set.
searchNumbers :: Set Int s -> s Int -> [Bool]
searchNumbers i s = map (\e -> search i e s) (take 10 (randomRs (0,1000) (mkStdGen 34354)))

-- | Benchmarks comparing the ListSet and the BinarySearchTree implementation.
benchmarks :: [Benchmark]
benchmarks = [
  bgroup "ListSet" [
    bench "insert" (nf evenBiggerSet LS.set),
    bench "search" (nf (searchNumbers LS.set) (evenBiggerSet LS.set))],
  bgroup "BinarySearchTree" [
    bench "insert" (nf evenBiggerSet BST.set),
    bench "search" (nf (searchNumbers BST.set) (evenBiggerSet BST.set))]]

-- Run all tests and communicate through exit code
main = defaultMain benchmarks

