%% @doc API for the meganalysis application
%% @end
-module(meganalysis).

-export([total/0, cut/0, run/0]).

total() ->
    meganalysis_process:total().

cut() ->
    meganalysis_process:cut().


%% Test runner
run() ->
    application:start(meganalysis),
    {ok, T1} = total(), % Force an ok, otherwise crash
    399747 = T1, % Assert correctness of total, crash otherwise
    cut(),
    {ok, T2} = total(),
    199873.5 = T2,
    {T1, T2}.

