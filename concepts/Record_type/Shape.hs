data Shape = Circle { getRadius :: Float }
           | Rectangle { getWidth :: Float, getHeight :: Float }

myCircle :: Shape
myCircle = Circle { getRadius = 42 }

myRectangle :: Shape
myRectangle = Rectangle { getWidth = 77, getHeight = 88 }

myUpdate :: Shape
myUpdate = myRectangle { getWidth = 42 }

-- Test whether the shape is a circle
isCircle (Circle _) = True
isCircle (Rectangle _ _) = False

