
function hex_sum(value)
    HEXBASE = 16
    count = 0
    i = value
    while i > 0
        division, remainder = divrem(i, HEXBASE)
        count += remainder
        i = division
    end
    return count
end

function solve_range(lower, upper)
    countnon1gcds = 0
    for i in lower:upper
        f_i = hex_sum(i)
        hex_gcd = gcd(i, f_i)
        if hex_gcd != 1
            countnon1gcds += 1
        end
    end

    println(countnon1gcds)
end

function main_fn()
    # read variable
    num_ranges = parse(Int, readline())

    for i in 1:num_ranges
        parsed = [parse(Int, x) for x in split(readline())]
        lower = parsed[1]
        upper = parsed[2]
        solve_range(lower, upper)
    end

    # loop
    return nothing
end

main_fn()