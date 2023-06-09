{- 

We repackage some stack implementations as data structures so that we
can parametrize in implementations.

-}

module StackImpl(
  StackImpl(..),
  simpleStackADT,
  stacksAsLists,
  stacksAsOpaqueLists,
  stacksWithConstantTimeSize
) where

import StackImplType
import qualified SimpleStackADT
import qualified StacksAsLists
import qualified StacksAsOpaqueLists
import qualified StacksWithConstantTimeSize

simpleStackADT :: StackImpl SimpleStackADT.Stack a
simpleStackADT = StackImpl {
   getEmpty = SimpleStackADT.empty,
   getPush = SimpleStackADT.push,
   getPop = SimpleStackADT.pop,
   getTop = SimpleStackADT.top,
   getIsEmpty = SimpleStackADT.isEmpty,
   getSize = SimpleStackADT.size
 }

-- We have to use a hack to get along without Haskell extensions.
-- That is, we cannot use the type synonym Stack as a kind *->* type constructor.
-- Thus, we just use [] (to which Stack redirects anyway).
stacksAsLists :: StackImpl [] a
stacksAsLists = StackImpl {
   getEmpty = StacksAsLists.empty,
   getPush = StacksAsLists.push,
   getPop = StacksAsLists.pop,
   getTop = StacksAsLists.top,
   getIsEmpty = StacksAsLists.isEmpty,
   getSize = StacksAsLists.size
 }

stacksAsOpaqueLists :: StackImpl StacksAsOpaqueLists.Stack a
stacksAsOpaqueLists = StackImpl {
   getEmpty = StacksAsOpaqueLists.empty,
   getPush = StacksAsOpaqueLists.push,
   getPop = StacksAsOpaqueLists.pop,
   getTop = StacksAsOpaqueLists.top,
   getIsEmpty = StacksAsOpaqueLists.isEmpty,
   getSize = StacksAsOpaqueLists.size
 }

stacksWithConstantTimeSize :: StackImpl StacksWithConstantTimeSize.Stack a
stacksWithConstantTimeSize = StackImpl {
   getEmpty = StacksWithConstantTimeSize.empty,
   getPush = StacksWithConstantTimeSize.push,
   getPop = StacksWithConstantTimeSize.pop,
   getTop = StacksWithConstantTimeSize.top,
   getIsEmpty = StacksWithConstantTimeSize.isEmpty,
   getSize = StacksWithConstantTimeSize.size
 }
