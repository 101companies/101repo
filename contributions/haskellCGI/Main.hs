module Main where

import Network.CGI
import Response 

main :: IO ()
-- server; use default error handling
main = runCGI $ handleErrors cgiMain