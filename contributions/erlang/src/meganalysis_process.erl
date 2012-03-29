%%%-------------------------------------------------------------------
%%% @author Jesper Louis andersen <jesper.louis.andersen@gmail.com>
%%% @copyright (C) 2011, Jesper Louis andersen
%%% @doc Server that retains a company
%%%
%%% @end
%%% Created :  8 Apr 2011 by Jesper Louis andersen <jesper.louis.andersen@gmail.com>
%%%-------------------------------------------------------------------
-module(meganalysis_process).

-behaviour(gen_server).

%% API
-export([start_link/0]).

-export([total/0, cut/0]).

%% gen_server callbacks
-export([init/1, handle_call/3, handle_cast/2, handle_info/2,
         terminate/2, code_change/3]).

-define(SERVER, ?MODULE).

-record(employee, {name, address, salary}).
-record(dept, {name, manager, employees, subdepts}).
-record(company, {name, depts}).

-record(state, { company }).

%%%===================================================================
%%% API
%%%===================================================================

mk_company() ->
    Dev1 = #dept { name = "Dev1",
                   manager = #employee { name = "Klaus",
                                         address = "Boston",
                                         salary = 23456 },
                   employees = [],
                   subdepts = [#dept { name = "Dev11",
                                       manager = #employee { name = "Karl",
                                                             address = "Riga",
                                                             salary = 2345 },
                                       employees =
                                           [#employee { name = "Joe",
                                                        address = "Wifi City",
                                                        salary = 2344 }],
                                       subdepts = [] }]},
    #company {
            name = "meganalysis",
            depts = [#dept {
                        name = "Research",
                        manager = #employee { name = "Craig",
                                              address = "Redmond",
                                              salary = 123456 },
                        employees = [#employee { name = "Erik",
                                                 address = "Utrecht",
                                                 salary = 12345 },
                                     #employee { name = "Ralf",
                                                 address = "Koblenz",
                                                 salary = 1234}],
                        subdepts = []},
                     #dept { name = "Development",
                             manager = #employee { name = "Ray",
                                                   address = "Redmond",
                                                   salary = 234567 },
                             employees = [],
                             subdepts = [Dev1]}]}.

total() ->
    gen_server:call(?SERVER, total, infinity).

cut() ->
    gen_server:cast(?SERVER, cut).

%%--------------------------------------------------------------------
%% @doc
%% Starts the server
%%
%% @spec start_link() -> {ok, Pid} | ignore | {error, Error}
%% @end
%%--------------------------------------------------------------------
start_link() ->
    gen_server:start_link({local, ?SERVER}, ?MODULE, [], []).

%%%===================================================================
%%% gen_server callbacks
%%%===================================================================

%% @private
init([]) ->
    Company = mk_company(),
    {ok, #state{ company = Company }}.

%% @private
handle_call(total, _From, #state { company = Company } = State) ->
    Total = totalCompany(Company),
    {reply, {ok, Total}, State};
handle_call(_Request, _From, State) ->
    Reply = ok,
    {reply, Reply, State}.

%% @private
handle_cast(cut, #state { company = Company } = State) ->
    CutCompany = cutCompany(Company),
    {noreply, State#state { company = CutCompany }};
handle_cast(_Msg, State) ->
    {noreply, State}.

%% @private
handle_info(_Info, State) ->
    {noreply, State}.

%% @private
terminate(_Reason, _State) ->
    ok.

%% @private
code_change(_OldVsn, State, _Extra) ->
    {ok, State}.

%%%===================================================================
%%% Internal functions
%%%===================================================================

totalCompany(#company { depts = DS }) ->
    lists:sum([totalDept(D) || D <- DS]).

totalDept(#dept { manager = M, subdepts = SD, employees = ES }) ->
    lists:sum([totalEmployee(E) || E <- [M | ES]] ++
              [totalDept(D) || D <- SD]).

totalEmployee(#employee { salary = S }) ->
    S.

cutCompany(#company { depts = DS } = Company) ->
    Company#company { depts = [cutDept(D) || D <- DS]}.

cutDept(#dept { manager = Mgr, employees = ES, subdepts = SD } = Dept) ->
    SD1 = [cutDept(D) || D <- SD],
    ES1 = [cutEmployee(E) || E <- ES],
    Mgr1 = cutEmployee(Mgr),
    Dept#dept { manager = Mgr1, employees = ES1, subdepts = SD1 }.

cutEmployee(#employee { salary = Salary } = Emp) ->
    Emp#employee { salary = Salary / 2 }.







