

local function hex_sum(val)
    local HEX_BASE = 16
    
    local count = 0
    local current_val = val
    while current_val > 0 do
        count = count + math.fmod(current_val, HEX_BASE)
        current_val = math.floor(current_val / HEX_BASE)
    end
    return count
end

local function gcd(first, second)
    --[[ Original implementation, too slow:
    local lesser = math.min(first, second)
    for i = lesser, 1, -1 do
        local divides_first = math.fmod(first, i) == 0
        local divides_second = math.fmod(second, i) == 0
        if divides_first and divides_second then
            return i
        end
    end
    
    return 1--]]

    -- Euclid's method: still too slow?
    --[[local rem = math.fmod(first, second)
    if rem == 0 then 
        return second
    end

    return gcd(second, rem)--]]

    while true do
        local rem = math.fmod(first, second)
        if rem == 0 then
            return second
        end

        first, second = second, rem
    end
end

local function solve_range(range_lower, range_upper)
    local non_1_gcds = 0
    for i = range_lower, range_upper do
        local f_i = hex_sum(i)
        local hex_gcd = gcd(i, f_i)
        if hex_gcd > 1 then
            non_1_gcds = non_1_gcds + 1
        end
    end
    
    io.write(non_1_gcds, '\n')
end

function main_fn()
    local num_questions = io.read("*n")
    for i = 0, num_questions - 1 do
        local lower_bound = io.read("*n")
        local upper_bound = io.read("*n")
        solve_range(lower_bound, upper_bound)
    end
end

main_fn()