-- Source: Chapter 40: Functional Data Structures by C. Okasaki. In: Handbook of Data Structures and Applications. Chapman & Hall/CRC.

data Stack = Empty | Push Int Stack 

empty = Empty
push x s  = Push x s
top (Push x s) = x
pop (Push x s) = s
