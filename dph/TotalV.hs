{-# LANGUAGE ParallelArrays #-}
{-# OPTIONS_GHC -fvectorise #-}
 
module TotalV (totalV) where
 
import Data.Array.Parallel.PArray
import Data.Array.Parallel
import Data.Array.Parallel.Prelude
import Data.Array.Parallel.Prelude.Float
 
totalVP :: [:Float:] -> Float
totalVP = sumP 

{-# NOINLINE totalV #-}
totalV v = totalVP (fromPArrayP v)