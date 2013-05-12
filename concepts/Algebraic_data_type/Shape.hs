data Shape = Circle Float
           | Rectangle Float Float

myCircle :: Shape
myCircle = Circle 42

myRectangle :: Shape
myRectangle = Rectangle 77 88

-- Test whether the shape is a circle
isCircle (Circle _) = True
isCircle (Rectangle _ _) = False

