package com.jorgehernandezramirez.codewars;

import java.math.BigInteger;

public class Factorial {

    public static String Factorial(int n) {
        BigInteger fact = BigInteger.valueOf(1);
        for (int i = 1; i <= n; i++)
            fact = fact.multiply(BigInteger.valueOf(i));
        return String.valueOf(fact);
    }
}
