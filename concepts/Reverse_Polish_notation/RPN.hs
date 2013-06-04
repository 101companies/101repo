module RPN where

import Stack

-- RPN as lists of operators and operands
type RPN = [Entry]
data Entry = Operator Operator | Operand Operand
  deriving (Show)
data Operator = Plus | Minus | Times
  deriving (Show)
type Operand = Int

-- Evaluation of RPN via stack
eval :: RPN -> Int
eval = loop empty
  where
    -- Loop over input
    loop :: Stack -> RPN -> Int
    loop s i =
      if null i
        then if size s == 1
               then top s
               else rpnError
        else
          loop (step (head i) s) (tail i)

    -- Process head of input
    step :: Entry -> Stack -> Stack
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

-- Interpretation of operator symbols
apply :: Operator -> Int -> Int -> Int
apply Plus = (+)
apply Minus = (-)
apply Times = (*)

-- Reusable error
rpnError :: a
rpnError = error "RPN corrupted"
