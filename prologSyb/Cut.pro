cut(X,Y) :-
  stoptd(updateSalary,X,Y).
  
updateSalary(
  employee(N,A,S1),
  employee(N,A,S2)) :-
    S2 is S1 / 2.
