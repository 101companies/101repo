depth(company(_,Ds),R)
 :-
    depth(Ds,R).

depth([],0).

depth([H|T],R)
 :-
    depth(H,R1),
    depth(T,R2),
    R is max(R1,R2).
 
 depth(dept(_,_,Units),R)
  :-
    depth(Units,R1),
    R is R1 + 1.
 
 depth(employee(_,_,_),0).
 