package com.jorgehernandezramirez.codewars;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SumDigPower {

    public static List<Long> sumDigPow(long a, long b) {
        return IntStream.rangeClosed((int)a, (int)b)
                        .boxed()
                        .filter(number -> isAnEurekaNumber(String.valueOf(number)))
                        .map(integer -> Long.valueOf(integer))
                        .collect(Collectors.toList());
    }

    public static Boolean isAnEurekaNumber(final String numberStr){
        return Integer.parseInt(numberStr) ==
               (int)IntStream.range(0, numberStr.length())
                             .boxed()
                             .mapToDouble(index -> Math.pow(Character.getNumericValue(numberStr.getBytes()[index]), index + 1))
                             .sum();
    }
}
