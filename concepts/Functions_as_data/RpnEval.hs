{-# LANGUAGE ScopedTypeVariables #-}

module RpnEval where

import RpnSyntax
import StackImpl

-- Evaluation of RPN via stack
eval :: forall s. StackImpl s Int -> RPN -> Int
eval si = loop (getEmpty si)
  where
    -- Loop over input
    loop :: s Int -> RPN -> Int
    loop s es =
      if null es
        then if getSize si s == 1
               then getTop si s
               else rpnError
        else
          loop (step (head es) s) (tail es) 

    -- Process head of input
    step :: Entry -> s Int -> s Int
    step e s =
      case e of
        Operand x -> getPush si x s
        Operator f -> 
          if getSize si s >= 2
            then 
              let (x,s') = (getTop si s, getPop si s) in
              let (y,s'') = (getTop si s', getPop si s') in
              getPush si (apply f y x) s''
           else rpnError     

-- Reusable error
rpnError :: a
rpnError = error "RPN corrupted"
