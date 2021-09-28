
// gets a range of ints from stdin
// calculates the sum of that int's hex representation
// finds the gcd of each int with its hex sum
// prints the number of ints for which the above was > 1

#include <iostream>
#include <numeric>

[[nodiscard]] constexpr static int hex_sum(int val) noexcept {
	constexpr auto hex_base = 16;	

	int count = 0;
	for(int i = val; i > 0; i = i / hex_base) {
		count += i % hex_base;
	}

	return count;
}

static void solve_range(int lower, int upper) {
	int non_1_gcd = 0;
	for(int j = lower; j <= upper; ++j) {
		const int f_j = hex_sum(j);
		const auto hex_gcd = std::gcd(j, f_j);
		if(hex_gcd != 1) {
			++non_1_gcd;
		}
	}

	std::cout << non_1_gcd << '\n';
}

int main() {
	int num_questions{};
	std::cin >> num_questions;
	
	for(int i = 0; i < num_questions; ++i) {
		int lower_bound{};
		int upper_bound{};
		std::cin >> lower_bound >> upper_bound;

		solve_range(lower_bound, upper_bound);
	}
}