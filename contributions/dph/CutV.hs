{-# LANGUAGE ParallelArrays #-}
{-# OPTIONS_GHC -fvectorise #-}
 
module CutV (cutV) where

import qualified Prelude 
import Data.Array.Parallel.PArray
import Data.Array.Parallel
import Data.Array.Parallel.Prelude
import Data.Array.Parallel.Prelude.Float
 
cutVP :: [:Float:] -> [:Float:]
cutVP = mapP (/2)
 
cutV :: PArray Float -> PArray Float
{-# NOINLINE cutV #-}
cutV v = toPArrayP (cutVP (fromPArrayP v))