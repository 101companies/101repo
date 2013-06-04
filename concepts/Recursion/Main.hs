-- A recursive definition of the factorial function
factorial n =
  if n==0
    then 1
    else n * factorial (n-1)

-- A non-recursive definition of the factorial function
factorial' n = product [1..n]

main = do
          print $ factorial 5
          print $ factorial' 5
