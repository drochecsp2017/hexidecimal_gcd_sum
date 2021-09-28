
// gets a range of ints from stdin
// calculates the sum of that int's hex representation
// finds the gcd of each int with its hex sum
// prints the number of ints for which the above was > 1

#include <stdio.h>
#include <stdbool.h>

static int hex_sum(int val) {
	enum {
		hex_base = 16,
	};

	int count = 0;
	for(int i = val; i > 0; i = i / hex_base) {
		count += i % hex_base;
	}

	return count;
}

static int gcd(int first, int second) {
	const int lesser = (first < second) ? first : second;
	//const int highest_possible_gcd = greater / 2;

	for(int i = lesser; i > 1; --i) {
		const bool divides_first = (first % i) == 0;
		const bool divides_second = (second % i) == 0;
		if(divides_first && divides_second) {
			return i;
		}
	}

	return 1;
}

static void solve_range(int lower, int upper) {
	int non_1_gcd = 0;
	for(int j = lower; j <= upper; ++j) {
		const int f_j = hex_sum(j);
		const int hex_gcd = gcd(j, f_j);
		if(hex_gcd != 1) {
			++non_1_gcd;
		}
	}

	printf("%d\n", non_1_gcd);
}

int main() {
	int num_questions = 0;
	scanf("%d", &num_questions);
	
	for(int i = 0; i < num_questions; ++i) {
		int lower_bound = 0;
		int upper_bound = 0;
		scanf("%d %d", &lower_bound, &upper_bound);

		solve_range(lower_bound, upper_bound);
	}
}