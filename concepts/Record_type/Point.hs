data Point = Point { getX :: Float, getY :: Float }

myPoint :: Point
myPoint = Point { getX = 42, getY = 88 }

myPoint' :: Point
myPoint' = myPoint { getY = 77 }

-- Compute the distance between two points
distance :: Point -> Point -> Float
distance p1 p2 = sqrt (deltax^2+deltay^2)
  where
    deltax = abs (getX p1 - getX p2) 
    deltay = abs (getY p1 - getY p2) 

-- Represent point as pair
toPair :: Point -> (Float, Float)
toPair (Point x y) = (x, y)

