import Network.CGI
import Text.XHtml

import Company
import API
import Response 

main :: IO ()
main = runCGI $ handleErrors cgiMain