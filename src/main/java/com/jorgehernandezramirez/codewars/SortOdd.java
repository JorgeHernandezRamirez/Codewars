package com.jorgehernandezramirez.codewars;

import java.util.Arrays;
import java.util.PrimitiveIterator;
import java.util.stream.IntStream;

public class SortOdd {

    public static int[] sortArray(int[] array) {
        final Integer[] integerToReturn = new Integer[array.length];
        IntStream.range(0, array.length)
                 .boxed()
                 .map(index -> Arrays.asList(index, array[index]))
                 .filter(ints -> isPar(ints.get(1)))
                 .forEachOrdered(integers -> {
                    integerToReturn[integers.get(0)] = integers.get(1);
                 });
        Arrays.stream(array)
              .filter(SortOdd::isOdd)
              .sorted()
              .forEachOrdered(integer -> {
            integerToReturn[getFirstPositionNotNull(integerToReturn)] = integer;
        });
        return Arrays.stream(integerToReturn).mapToInt(i->i).toArray();
    }

    private static Integer getFirstPositionNotNull(Integer[] integers){
        return IntStream.range(0, integers.length).filter(value -> integers[value] == null).findFirst().getAsInt();
    }

    private static boolean isOdd(final Integer number) {
        return number % 2 != 0;
    }

    private static boolean isPar(final Integer number) {
        return number % 2 == 0;
    }

    public class Kata {
        public int[] sortArray(int[] array) {
            PrimitiveIterator.OfInt sortedOdds = IntStream
                    .of(array)
                    .filter(i -> i % 2 == 1)
                    .sorted()
                    .iterator();

            return IntStream
                    .of(array)
                    .map(i -> i % 2 == 0 ? i : sortedOdds.nextInt())
                    .toArray();
        }
    }
}
