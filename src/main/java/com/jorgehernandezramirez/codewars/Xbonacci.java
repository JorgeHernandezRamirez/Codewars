package com.jorgehernandezramirez.codewars;

import java.util.stream.Stream;

public class Xbonacci {

    /*public double[] tribonacci(final double[] s, final int n) {
        final List<Double> tribonacciSerie = new ArrayList<Double>(Arrays.asList(s[0], s[1], s[2]));
        IntStream.range(3, n).forEach(index -> {
            tribonacciSerie.add(tribonacciSerie.get(index - 1) + tribonacciSerie.get(index - 2) + tribonacciSerie.get(index - 3));
        });
        return tribonacciSerie.subList(0, n).stream().mapToDouble(aDouble -> aDouble.doubleValue()).toArray();
    }*/

    public double[] tribonacci(double[] start, int n) {
        return Stream.iterate(start, tuple -> applySequenceRule(tuple))
                .mapToDouble(tuple -> tuple[0])
                .limit(n)
                .toArray();
    }

    private double[] applySequenceRule(double[] tuple) {
        return new double[]{tuple[1], tuple[2], tuple[0]+tuple[1]+tuple[2]};
    }

}
