twice :: (x -> x) -> x -> x
twice f = f . f
