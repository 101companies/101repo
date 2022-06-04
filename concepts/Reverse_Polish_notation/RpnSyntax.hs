module RpnSyntax where

-- 5 1 2 + 4 * + 3 -
sample :: RPN
sample = [
             Operand 5,
             Operand 1,
             Operand 2,
             Operator Plus,
             Operand 4,
             Operator Times,
             Operator Plus,
             Operand 3,
             Operator Minus
         ]

-- RPN as lists of operators and operands
type RPN = [Entry]
data Entry = Operator Operator | Operand Operand
  deriving (Show)
data Operator = Plus | Minus | Times
  deriving (Show)
type Operand = Int

-- Interpretation of operator symbols
apply :: Operator -> Int -> Int -> Int
apply Plus = (+)
apply Minus = (-)
apply Times = (*)
