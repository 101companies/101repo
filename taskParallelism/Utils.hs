module Utils where

import Control.Concurrent

rotate :: [a] -> [a]
rotate (x:xs) = xs ++ [x]

derotate :: [a] -> [a]
derotate xs = last xs : init xs

takeAllMVars ::  [MVar a] -> IO [a]
takeAllMVars [] = return []
takeAllMVars (m:ms) = do
    x <- tryTakeMVar m
    f x
    where
        f (Just y) = do
            ys <- takeAllMVars ms
            return $ y:ys
        f (Nothing) = do
            ys <- takeAllMVars $ rotate $ m:ms
            return $ derotate ys