module ListSet where

import Set

set :: Eq e => Set e []
set = Set {

  empty = [],

  insert = \e s ->
    case s of
      [] -> [e]
      s'@(e':s'') ->
        if e==e'
          then s'
          else e':insert set e s'',

  search = \e s ->
    case s of
      [] -> False
      (e':s') -> e==e' || search set e s'

}
