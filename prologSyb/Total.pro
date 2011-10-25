total(X,R) :-
  collect(getSalary,X,L),
  sum(L,R).

getSalary(employee(_,_,S),S).
