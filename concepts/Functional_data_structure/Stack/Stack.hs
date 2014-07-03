data Stack = Empty | Push Int Stack 

empty = Empty
push x s  = Push x s
top (Push x s) = x
pop (Push x s) = s

