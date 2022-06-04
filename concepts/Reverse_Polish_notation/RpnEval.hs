module RpnEval where

import RpnSyntax

import StacksAsLists

-- Evaluation of RPN via stack
eval :: RPN -> Int
eval = loop empty
  where
    -- Loop over input
    loop :: Stack Int -> RPN -> Int
    loop s i =
      if null i
        then if size s == 1
               then top s
               else rpnError
        else
          loop (step (head i) s) (tail i)

    -- Process head of input
    step :: Entry -> Stack Int -> Stack Int
    step h s =
      case h of
        Operand x -> push x s
        Operator f -> 
          if size s >= 2
            then 
              let (x,s') = (top s, pop s) in
              let (y,s'') = (top s', pop s') in
              push (apply f y x) s''
           else rpnError     

-- Reusable error
rpnError :: a
rpnError = error "RPN corrupted"
