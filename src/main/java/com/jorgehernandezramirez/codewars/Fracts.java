package com.jorgehernandezramirez.codewars;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Fracts {

    public static String convertFrac(long[][] lst) {
        final long lcm = lcm(Arrays.stream(lst)
                                   .map(longs -> longs[1])
                                   .toArray(Long[]::new));
        return Arrays.stream(lst)
              .map(longs -> "(" + lcm / longs[1] * longs[0] + "," + lcm + ")")
              .collect(Collectors.joining());
    }

    private static long lcm(final Long[] input){
        long result = 1;
        for(int i = 0; i < input.length; i++){
            result = lcm(result, input[i]);
        }
        return result;
    }

    private static long lcm(final long a, final long b){
        return a * (b / gcd(a, b));
    }

    private static long gcd(long a, long b){
        while (b > 0){
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
