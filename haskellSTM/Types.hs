module Types where

import Control.Concurrent.STM

import Focus

-- generic type for a job
data Progress a = Do a | Done  

-- type alias for a transactional job MVar
type TProgress a = TMVar (Progress a)

-- type alias for a focus as the progress
type TFocusProgress = TProgress Focus