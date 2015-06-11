{-# LANGUAGE FlexibleInstances #-}

class ToInt a
  where
    toInt :: a -> Maybe Int

instance ToInt Int
  where
    toInt = Just

instance ToInt Float
  where
    toInt = Just . round

instance ToInt String
  where
    toInt s =
      case reads s of
        [(i, "")] -> Just i
        _ -> Nothing

{-

*Main> toInt "5"
Just 5
*Main> toInt "foo"
Nothing
*Main> toInt (5::Int)
Just 5
*Main> toInt (5.5::Float)
Just 6

-}
