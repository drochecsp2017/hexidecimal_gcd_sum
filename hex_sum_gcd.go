package main

import "fmt"

func hex_sum(val int) int {
	const HEX_BASE = 16

	count := 0
	for i := val; i > 0; i = i / HEX_BASE {
		rem := i % HEX_BASE
		count += rem
	}

	return count
}

func gcd(first, second int) int {
	for {
		rem := first % second
		if rem == 0 {
			return second
		}

		first, second = second, rem
	}
}

func solve_range(lower, upper int) {
	non_1_gcd := 0
	for i := lower; i <= upper; i++ {
		f_i := hex_sum(i)
		hex_gcd := gcd(i, f_i)
		if hex_gcd != 1 {
			non_1_gcd++
		}
	}

	fmt.Println(non_1_gcd)
}

func main() {
	num_columns := 0
	fmt.Scanf("%d", &num_columns)
	for i := 0; i < num_columns; i++ {
		var lower, upper int
		fmt.Scanf("%d %d", &lower, &upper)
		solve_range(lower, upper)
	}
}
