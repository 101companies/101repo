-- A straightforward definition of factorial
factorial :: Integer -> Integer
factorial x =
  if x < 0 
    then error "factorial arg error"
    else if x <= 1
      then 1
      else x * factorial (x-1)

-- A re-definition of "if"
ifThenElse :: Bool -> x -> x -> x
ifThenElse True x _ = x
ifThenElse False _ x = x

-- Factorial re-defined to use user-defined if
factorial' :: Integer -> Integer
factorial' x =
  ifThenElse (x < 0)
    (error "factorial arg error")
    (ifThenElse (x <= 1)
      1
      (x * factorial' (x-1)))
