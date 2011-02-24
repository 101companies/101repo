isCompany(company(N,Ds)) :- isName(N), isDepts(Ds).

isDepts([]).
isDepts([D|Ds]) :- isDept(D), isDepts(Ds).

isDept(dept(N,M,Us)) :-
  isName(N),
  isEmployee(M),
  isSubunits(Us).

isEmployee(employee(N,A,S)) :-
  isName(N),
  isAddress(A),
  isSalary(S).

isSubunits([]).
isSubunits([U|Us]) :- isSubunit(U), isSubunits(Us).
isSubunit(U) :- isDept(U).
isSubunit(U) :- isEmployee(U).

isName(N) :- atom(N).
isAddress(A) :- atom(A).
isSalary(S) :- number(S).
