module Main  where

import Database.HaskellDB

import Total
import Cut
import MyConnection

main = do

  let cname = "meganalysis"

  -- run total query
  [res] <- execute $ (flip $ query) $ total cname
  print $ res!ttl
  
  -- do cut update
  execute $ cut "meganalysis"
    
  -- run total query
  [res] <- execute $ (flip $ query) $ total cname
  print $ res!ttl