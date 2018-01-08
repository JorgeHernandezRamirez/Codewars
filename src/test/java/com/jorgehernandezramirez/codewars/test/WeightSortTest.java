package com.jorgehernandezramirez.codewars.test;

import com.jorgehernandezramirez.codewars.WeightSort;
import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class WeightSortTest {

    @Test
    public void BasicTests() {
        System.out.println("****** Basic Tests ******");
        assertEquals("2000 103 123 4444 99", WeightSort.orderWeight("103 123 4444 99 2000"));
        assertEquals("11 11 2000 10003 22 123 1234000 44444444 9999", WeightSort.orderWeight("2000 10003 1234000 44444444 9999 11 11 22 123"));
        assertEquals("59544965313", WeightSort.orderWeight("59544965313"));
        assertEquals("", WeightSort.orderWeight(""));
    }

    @Test
    public void prueba(){
        "510".chars().map(operand -> Character.getNumericValue(operand)).boxed().collect(Collectors.toList());
        "Jorge".chars().mapToObj(c -> String.valueOf((char)c)).collect(Collectors.toList());
    }

}
