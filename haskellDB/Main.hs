module Main  where

import Database.HaskellDB

import Total
import Cut
import MyConnection

main = do

  let cname = "meganalysis"

  -- run total query
  [res] <- withDB $ (flip $ query) $ total cname
  print $ res!ttl
  
  -- do cut update
  withDB $ cut "meganalysis"
    
  -- run total query
  [res] <- withDB $ (flip $ query) $ total cname
  print $ res!ttl