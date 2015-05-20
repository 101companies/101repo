type IntOrFloat = Either Int Float

asFloat :: IntOrFloat -> Float
asFloat (Left x) = fromIntegral x
asFloat (Right x) = x

{-

*Main> asFloat (Left 42)
42.0
*Main> asFloat (Right 42.0)
42.0

-}

asFloat' :: IntOrFloat -> Float
asFloat' = either fromIntegral id

data IntOrFloat' = Int Int | Float Float

asFloat'' :: IntOrFloat' -> Float
asFloat'' (Int x) = fromIntegral x
asFloat'' (Float x) = x
