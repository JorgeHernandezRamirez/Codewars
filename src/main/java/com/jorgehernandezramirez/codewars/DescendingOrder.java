package com.jorgehernandezramirez.codewars;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class DescendingOrder {

    public DescendingOrder(){
        super();
    }

    public static int sortDesc(final int num) {
        return Integer.parseInt(Arrays.asList(String.valueOf(num).split("")).stream()
                .map(Integer::parseInt)
                .sorted(Collections.reverseOrder())
                .map(String::valueOf)
                .collect(Collectors.joining()));


        /*final List<Integer> numberList = getIntegerListFromInteger(num);
        Collections.sort(numberList, Collections.reverseOrder());
        return getIntegerFromIntegerList(numberList);*/
    }

    private static List<Integer> getIntegerListFromInteger(final Integer integer){
        return Arrays.asList(String.valueOf(integer).split("")).stream().map(Integer::parseInt).collect(Collectors.toList());
    }

    private static Integer getIntegerFromIntegerList(final List<Integer> integerList){
        final String numberStringToReturn = integerList.stream().map(String::valueOf).reduce("", (string1, string2) -> string1 + string2);
        return Integer.parseInt(numberStringToReturn);
    }
}
