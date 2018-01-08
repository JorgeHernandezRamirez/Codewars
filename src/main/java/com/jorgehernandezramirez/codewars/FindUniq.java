package com.jorgehernandezramirez.codewars;

import java.util.Arrays;

public class FindUniq {

    public static double findUniq(double arr[]) {
        final double commonValue = arr[0] == arr[1] ? arr[0] : (arr[1] == arr[2] ? arr[1] : arr[0]);
        return Arrays.stream(arr).filter(value -> value != commonValue).findFirst().getAsDouble();
    }

    /*
    Arrays.stream(array).boxed()
                .collect(groupingBy(identity(), counting()))
                .entrySet().stream()
                .filter(e -> e.getValue() == 1)
                .findFirst()
                .map(Entry::getKey)
                .orElse(0.0);
     */
}
