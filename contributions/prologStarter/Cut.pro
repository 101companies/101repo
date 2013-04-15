cut( company(N,Ds1),
     company(N,Ds2))
 :- 
	cut(Ds1,Ds2).

cut(N1,N2)
 :-
	number(N1), N2 is N1 / 2.
    
cut([],[]).
cut([H1|T1],[H2|T2])
 :-
	cut(H1,H2), cut(T1,T2).
 
cut( dept(X,M1,Units1),
	 dept(X,M2,Units2))
 :-
	cut(M1,M2), 
	cut(Units1,Units2).
 
cut( employee(X,Y,S1),
	 employee(X,Y,S2))
 :-
	cut(S1,S2).
