module Main where

import SampleCompany
import Focus                                       
import Views   

import Graphics.UI.WX hiding (when)
import Monad 
 
-- setup frame and start with root view         
gui :: IO ()
gui = do
    f <- frame [ textBgcolor := colorRGB 112 128 144 
               , resizeable := False
               , fontWeight := WeightBold
               , fontUnderline := False
               , position := Point 50 50]
    p <- panel f [textColor := colorRGB 18 19 51]
    showCompany f p CompanyFocus company 
 
-- start the GUI   
main :: IO ()
main = start gui