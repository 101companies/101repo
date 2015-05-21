import Point
import Test.QuickCheck

prop_getX :: Int -> Int -> Bool
prop_getX x y = getX (mkPoint x y) == x

prop_getY :: Int -> Int -> Bool
prop_getY x y = getY (mkPoint x y) == y
