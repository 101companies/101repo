module NaiveSetTopLevel where

empty :: [a]
empty = []

insert :: Eq a => a -> [a] -> [a]
insert e s 
  = case s of
      [] -> [e]
      s'@(e':s'') ->
        if e==e'
          then s'
          else e':insert e s''

search :: Eq a => a -> [a] -> Bool
search e s
  = case s of
      [] -> False
      (e':s') -> e==e' || search e s'
