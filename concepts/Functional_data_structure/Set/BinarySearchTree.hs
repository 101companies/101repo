{-

Source: Handbook of Data Structures and Applications; Chapter on
Functional Data Structures by Chris Okasaki. The style was adjusted to
make use of record types. Also, some other refactorings were applied.

-}

module BinarySearchTree where

import Control.DeepSeq

import Set

data BST e = Empty | Node (BST e) e (BST e)

set :: Ord e => Set e BST
set = Set {

  empty = Empty,

  insert = \e s ->
    case s of
      Empty -> Node Empty e Empty
      (Node s1 e' s2) ->
        if e<e'
          then Node (insert set e s1) e' s2
          else if e>e'
            then Node s1 e' (insert set e s2)
            else Node s1 e' s2,

  search = \e s ->
    case s of
      Empty -> False
      (Node s1 e' s2) -> 
        if e<e'
          then search set e s1
          else if e>e'
            then search set e s2
            else True

}

instance (NFData a) => NFData (BST a) where
  rnf Empty = ()
  rnf (Node s1 e s2) = rnf s1 `seq` rnf e `seq` rnf s2
