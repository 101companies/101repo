total(company(_,Ds),R)
 :-
    total(Ds,R).

total([],0).

total([H|T],R)
 :-
    total(H,R1),
    total(T,R2),
    R is R1 + R2.
 
 total(dept(_,M,Units),R)
  :-
    total(M,R1),
    total(Units,R2),
    R is R1 + R2.
 
 total(employee(_,_,S),S).
 