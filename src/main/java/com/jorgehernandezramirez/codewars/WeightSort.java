package com.jorgehernandezramirez.codewars;

import java.util.Arrays;
import java.util.stream.Collectors;

public class WeightSort {

    public static String orderWeight(final String string) {
        return Arrays.stream(string.split(" "))
                     .filter(s -> !"".equals(s))
                     .map(s -> new long[]{Long.parseLong(s),
                                          Arrays.stream(s.split(""))
                                               .map(Long::parseLong)
                                               .reduce((x, y) -> x + y)
                                               .get()})
                      .sorted((o1, o2) -> {
                          if (o1[1] == o2[1]){
                              return String.valueOf(o1[0]).compareTo(String.valueOf(o2[0]));
                          }
                          return o1[1] < o2[1] ? -1 : 1;
                       })
                      .map(ints -> String.valueOf(ints[0]))
                      .collect(Collectors.joining(" "));
    }
}
