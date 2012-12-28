-- See http://userpages.uni-koblenz.de/~laemmel/MapReduce/

module MapReduce where

import Data.Map (Map, empty, insertWith, mapWithKey, toList)

-- The simple map-reduce abstraction from Google's paper

mapReduce  ::  Ord k2
           =>  (k1 -> v1 -> [(k2,v2)])  -- "map" 
           ->  (k2 -> [v2] -> v2)      	-- "reduce"
           ->  Map k1 v1 ->  Map k2 v2  -- I/O

mapReduce m r
 = reducePerKey r
 . groupByKey
 . mapPerKey m


-- The map phase

mapPerKey :: Ord k2
          => (k1 -> v1 -> [(k2,v2)])
          -> Map k1 v1 
          -> [(k2,v2)]

mapPerKey f = concat . map (uncurry f) . toList


-- The grouping phase

groupByKey :: Ord k2
           => [(k2,v2)]
           -> Map k2 [v2]

groupByKey = foldr (flip insert) empty
 where
  insert dict (k2,v2) = insertWith (++) k2 [v2] dict


-- The reduction phase

reducePerKey :: (k2 -> [v2] -> v2)
             -> Map k2 [v2]
             -> Map k2 v2

reducePerKey f = mapWithKey f
