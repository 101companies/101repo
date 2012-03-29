% Sum up a list of numbers

sum([],0).
sum([H|T],X) :- sum(T,Y), X is Y + H. 


%
% P ... the predicate to apply for extraction
% X ... the input term
% L ... the list of extracted terms
%

collect(P,X,L) :-
  apply(P,[X,Y]) ->
    L = [Y];
    X =.. [_|Xs],
    maplist(collect(P),Xs,Yss),
    append(Yss,L).


%
% P ... the predicate to apply for transformation
% X ... the input term
% Y ... the output term
%

stoptd(P,X,Y) :-
  apply(P,[X,Y]) ->
    true;
    X =.. [F|Xs],
    maplist(stoptd(P),Xs,Ys),
    Y =.. [F|Ys].
