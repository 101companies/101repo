{-# LANGUAGE OverloadedStrings #-}

module Main where

import Control.Monad (msum)
import Happstack.Server ( nullConf, simpleHTTP, path, Browsing(EnableBrowsing), 
                         serveDirectory)
                               
import Serverparts                          

-- server  
main :: IO ()
main = do
  simpleHTTP nullConf $ msum [ path $ \v -> path $ \a -> path $ \f -> mainPart a v f
                             , serveDirectory EnableBrowsing [] "static"]                         