module StackImpl(
  StackImpl(..),
  simpleImpl,
  opaqueImpl,
  constantImpl
) where

import qualified SimpleStackADT as Simple
import qualified StacksAsOpaqueLists as Opaque
import qualified StacksWithConstantTimeSize as Constant

data StackImpl s a =
  StackImpl {
    getEmpty :: s a,
    getPush :: a -> s a -> s a,
    getPop :: s a -> s a,
    getTop :: s a -> a,
    getIsEmpty :: s a -> Bool,
    getSize :: s a -> Int
  }

simpleImpl :: StackImpl Simple.Stack a
simpleImpl = StackImpl {
   getEmpty = Simple.empty,
   getPush = Simple.push,
   getPop = Simple.pop,
   getTop = Simple.top,
   getIsEmpty = Simple.isEmpty,
   getSize = Simple.size
 }

opaqueImpl :: StackImpl Opaque.Stack a
opaqueImpl = StackImpl {
   getEmpty = Opaque.empty,
   getPush = Opaque.push,
   getPop = Opaque.pop,
   getTop = Opaque.top,
   getIsEmpty = Opaque.isEmpty,
   getSize = Opaque.size
 }

constantImpl :: StackImpl Constant.Stack a
constantImpl = StackImpl {
   getEmpty = Constant.empty,
   getPush = Constant.push,
   getPop = Constant.pop,
   getTop = Constant.top,
   getIsEmpty = Constant.isEmpty,
   getSize = Constant.size
 }
