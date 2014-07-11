module Main where

import Set
import NaiveSet as Naive
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

-- | Benchmarks comparing the NaiveSet and the BinarySearchTree implementation.
benchmarks :: [Benchmark]
benchmarks = [
  bgroup "NaiveSet" [
    bench "insert" (nf evenBiggerSet Naive.set),
    bench "search" (nf (searchNumbers Naive.set) (evenBiggerSet Naive.set))],
  bgroup "BinarySearchTree" [
    bench "insert" (nf evenBiggerSet BST.set),
    bench "search" (nf (searchNumbers BST.set) (evenBiggerSet BST.set))]]

-- Run all benchmarks
main = defaultMain benchmarks

