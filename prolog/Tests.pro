:- ['Company.pro']. 
:- ['Total.pro']. 
:- ['Cut.pro']. 
:- ['Depth.pro']. 

:-
   see('sampleCompany.trm'),
   read(C1),
   seen,
   isCompany(C1),
   total(C1,R1),
   format('total = ~w~n',[R1]),
   cut(C1,C2),
   total(C2,R2),
   format('cut = ~w~n',[R2]),
   depth(C1,R3),
   format('depth = ~w~n',[R3]).
   
 :- halt.
 