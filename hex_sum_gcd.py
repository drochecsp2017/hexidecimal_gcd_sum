
from math import gcd

def hex_sum(val: int) -> int:
    HEX_BASE = 16

    count = 0
    i = val
    while i > 0:
        count += i % HEX_BASE
        i = i // HEX_BASE

    return count

def solve_range(lower: int, upper: int) -> int:
    non_1_gcd = 0
    for i in range(lower, upper + 1):
        f_i = hex_sum(i)
        hex_gcd  = gcd(i, f_i)
        if not hex_gcd == 1:
            non_1_gcd += 1

    print(non_1_gcd)

def main():
    num_ranges = int(input())
    for i in range(num_ranges):
        range_inputs = input().split(' ')
        lower = int(range_inputs[0])
        upper = int(range_inputs[1])

        solve_range(lower, upper)


if __name__ == '__main__':
    main()