
use std::io;
//use std::io::prelude::*;
use std::cmp;
//use std::slice::range;
//use std::num::integer::gcd;

fn hex_sum(val: i32) -> i32 {
    let hex_base: i32 = 16;

	let mut count: i32 = 0;
    let mut i = val;
    while i > 0 {
		count = count + (i % hex_base);
        i = i / hex_base;
    }

	return count;
}

fn gcd(first: i32, second: i32) -> i32 {
    let lesser = cmp::min(first, second);
	//const int highest_possible_gcd = greater / 2;

    let gcd_range = std::ops::Range::<i32>{ start: 2, end: lesser + 1 };
	for i in gcd_range.rev() {
		let divides_first = (first % i) == 0;
		let divides_second = (second % i) == 0;
		if divides_first && divides_second {
			return i;
		}
	}

	return 1;
}

fn solve_range(lower: i32, upper: i32) {
	let mut non_1_gcd = 0;
	for j in lower..(upper+1) {
		let f_j = hex_sum(j);
		let hex_gcd = gcd(j, f_j);
		if hex_gcd != 1 {
			non_1_gcd = non_1_gcd + 1;
		}
	}

	println!("{}", non_1_gcd);
}

fn main() {
    let mut buffer = String::new();
    io::stdin().read_line(&mut buffer).expect("could not read line"); // Reading input from STDIN
    let num_ranges = buffer.trim().parse::<i32>().unwrap();

    for _ in 0..num_ranges {
        let mut buffer = String::new();
        io::stdin().read_line(&mut buffer).expect("could not read line"); 
        let trimmed_buffer = buffer.trim();
        let vec: Vec<&str> = trimmed_buffer.split(" ").collect();

        let lower = vec[0].parse::<i32>().unwrap();
        let upper = vec[1].parse::<i32>().unwrap();
        solve_range(lower, upper);
    }
}