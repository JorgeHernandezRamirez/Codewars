package com.jorgehernandezramirez.codewars;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Johnann {

    public static List<Long> john(long n) {
        Long lastNumber = 0L;
        final List<Long> longList = new ArrayList<Long>();
        for(int i = 1; i <= n; i++){
            if(i % 3 == 0){
                lastNumber++;
            }
            longList.add(lastNumber);
            if(i % 3 == 0){
                lastNumber++;
            }
        }
        return longList;
    }
    public static List<Long> ann(long n) {
        return IntStream.rangeClosed(1, (int)n).mapToObj(value -> Long.valueOf((long)Math.ceil(value / 2.0))).collect(Collectors.toList());
    }
    public static long sumJohn(long n) {
        return john(n).subList(0, Long.valueOf(n - 1).intValue()).stream().reduce(0L, (aLong, aLong2) -> aLong + aLong2);
    }
    public static long sumAnn(long n) {
        return ann(n).stream().reduce(0L, (aLong, aLong2) -> aLong + aLong2);
    }
}
