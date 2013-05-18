import Prelude hiding (Maybe, Nothing, Just, maybe)

-- The Maybe type constructor
data Maybe a = Nothing | Just a
 deriving (Read, Show, Eq)

-- A fold function for maybes
maybe :: b -> (a -> b) -> Maybe a -> b
maybe b _ Nothing = b
maybe _ f (Just a) = f a
