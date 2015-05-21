module Point(
  Point, -- constructor is NOT exported
  mkPoint,
  getX,
  getY
) where

data Point = Point { getX :: Int, getY :: Int }
  deriving (Eq, Show, Read)

mkPoint :: Int -> Int -> Point
mkPoint = Point
