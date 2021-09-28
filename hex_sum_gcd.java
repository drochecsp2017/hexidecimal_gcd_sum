/* IMPORTANT: Multiple classes and nested static classes are supported */

//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.Scanner;

import java.math.BigInteger;

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class TestClass {
    
    private static BigInteger hexSum(BigInteger val) {
        final BigInteger HEX_BASE = BigInteger.valueOf(16);

        BigInteger count = BigInteger.ZERO;
        for(BigInteger i = val; !i.equals(BigInteger.ZERO); i = i.divide(HEX_BASE)) {
            BigInteger hexCoeff = i.mod(HEX_BASE);
            count = count.add(hexCoeff);
        }

        return count;
    }

    private static void solve_range(BigInteger lower, BigInteger upper) {
        int non_1_gcd = 0;
        for(BigInteger j = lower; j.compareTo(upper) < 1; j = j.add(BigInteger.ONE)) {
            final BigInteger f_j = hexSum(j);
            final BigInteger hex_gcd = j.gcd(f_j);
            if(!hex_gcd.equals(BigInteger.ONE)) {
                ++non_1_gcd;
            }
        }

        //printf("%d\n", non_1_gcd);
        System.out.println(non_1_gcd);
    }

    public static void main(String args[]) throws Exception {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final String numCasesLine = br.readLine().trim();
        final int numCases = Integer.parseInt(numCasesLine);

        for(int i = 0; i < numCases; ++i) {
            String[] rangeLine = br.readLine().trim().split(" ");
            final BigInteger lower = new BigInteger(rangeLine[0]);
            final BigInteger upper = new BigInteger(rangeLine[1]);

            solve_range(lower, upper);
        }
    }
}
