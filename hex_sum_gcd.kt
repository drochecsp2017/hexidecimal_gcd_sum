

fun hex_sum(value: Int): Int {
    val HEX_BASE = 16;

    var i = value;
    var count = 0;
    while (i > 0) {
        count += i % HEX_BASE;
        i /= HEX_BASE;
    }

    return count;
}

fun gcd(firstInput: Int, secondInput: Int): Int {
    var first = firstInput
    var second = secondInput
    while (true) {
        val rem = first % second;
        if (rem == 0) {
            return second;
        }

        first = second
        second = rem
    }
}

fun solve_range(lower: Int, upper: Int) {
    var non_1_gcd = 0;
    for (i in lower..upper) {
        val f_i = hex_sum(i);
        val hex_gcd = gcd(i, f_i);
        if (hex_gcd != 1) {
            non_1_gcd += 1;
        }
    }

    println(non_1_gcd);
}

fun main(args: Array<String>) {
    val num_lines = readLine()!!.toInt() - 1;

    for (i in 0..num_lines) {
        val (lower, upper) = readLine()!!.split(' ');
        solve_range(lower.toInt(), upper.toInt());
    }
}