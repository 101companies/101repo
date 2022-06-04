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
    getSize :: s a -> Int
  }

simpleImpl :: StackImpl Simple.Stack a
simpleImpl = StackImpl {
   getEmpty = Simple.empty,
   getPush = Simple.push,
   getPop = Simple.pop,
   getTop = Simple.top,
   getSize = Simple.size
 }

opaqueImpl :: StackImpl Opaque.Stack a
opaqueImpl = StackImpl {
   getEmpty = Opaque.empty,
   getPush = Opaque.push,
   getPop = Opaque.pop,
   getTop = Opaque.top,
   getSize = Opaque.size
 }

constantImpl :: StackImpl Constant.Stack a
constantImpl = StackImpl {
   getEmpty = Constant.empty,
   getPush = Constant.push,
   getPop = Constant.pop,
   getTop = Constant.top,
   getSize = Constant.size
 }
