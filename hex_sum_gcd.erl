

-module(hex_sum_gcd).
-export([start/0]).

hex_sum(Value) when Value > 0 -> 
    Rem = Value rem 16,
    Rem + hex_sum(Value div 16);
hex_sum(_) -> 0.

gcd(First, Second) -> 
    Rem = First rem Second,
    if 
        Rem == 0 -> Second;
        true -> gcd(Second, Rem)
    end.

solve_range(Current, Limit) when Current =< Limit ->
    F_current = hex_sum(Current),
    Gcd_val = gcd(Current, F_current),
    if 
        Gcd_val > 1 -> 1 + solve_range(Current + 1, Limit);
        true -> solve_range(Current + 1, Limit)
    end;
solve_range(_, _) -> 0.

do_range_solving(Iterations) when Iterations > 0 ->
    case io:fread([], "~d ~d") of
    eof -> ok;
    {ok, [Lower, Upper]} ->
        UniqueGcds = solve_range(Lower, Upper),
        io:fwrite("~w~n", [UniqueGcds]),
        do_range_solving(Iterations - 1);
    {error, What} ->
        io:format("io:fread error: ~w~n", [What]),
        do_range_solving(Iterations)
    end;
do_range_solving(0) -> done.

start() ->
    {ok, [NumProblems]} = io:fread("", "~d"),    
    do_range_solving(NumProblems). 