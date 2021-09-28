

function hex_sum(val) {
    const HEX_BASE = 16;

    let count = 0;
    for(let i = val; i > 0; i = Math.floor(i / HEX_BASE)) {
        count += i % HEX_BASE;
    }

    return count;
}

function gcd(first, second) {
    while (true) {
        let rem = first % second;
        if(rem == 0) {
            return second;
        }

        first = second;
        second = rem;
    }
}

function solve_range(lower, upper) {
    let non_1_gcds = 0;
    
    for(let i = lower; i <= upper; ++i) {
        const f_i = hex_sum(i);
        const hex_gcd = gcd(i, f_i);
        if(hex_gcd != 1) {
            non_1_gcds += 1;
        }
    }
    
    console.log(non_1_gcds)
}

function* main() {
    const init_line = yield;
    const num_lines = parseInt(init_line, 10);
    
    for(let i = 0; i < num_lines; ++i) {
        let input_line = yield;
        let range_strings = input_line.split(' ');
        const lower_bound = parseInt(range_strings[0], 10);
        const upper_bound = parseInt(range_strings[1], 10);
        
        solve_range(lower_bound, upper_bound);
    }
}


// import Node's readline module
var readline = require('readline');
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
  terminal: false
});


const main_loop = main();
main_loop.next();
rl.on('line', function(line){
    main_loop.next(line);
});