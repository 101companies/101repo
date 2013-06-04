import RPN

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

main = do 
          print $ eval sample
