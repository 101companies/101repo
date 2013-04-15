-- A recursive definition of the factorial function
factorial n =
  if n==0
    then 1
    else n * factorial (n-1)

main = print $ factorial 5
