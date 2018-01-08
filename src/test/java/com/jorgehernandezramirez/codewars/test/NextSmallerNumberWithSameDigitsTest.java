package com.jorgehernandezramirez.codewars.test;

import com.jorgehernandezramirez.codewars.NextSmallerNumberWithSameDigits;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NextSmallerNumberWithSameDigitsTest {

    @Test
    public void basicTests() {
        assertEquals(12, NextSmallerNumberWithSameDigits.nextSmaller(21));
        assertEquals(790, NextSmallerNumberWithSameDigits.nextSmaller(907));
        assertEquals(513, NextSmallerNumberWithSameDigits.nextSmaller(531));
        assertEquals(-1, NextSmallerNumberWithSameDigits.nextSmaller(1027));
        assertEquals(414, NextSmallerNumberWithSameDigits.nextSmaller(441));
        assertEquals(123456789, NextSmallerNumberWithSameDigits.nextSmaller(123456798));
        NextSmallerNumberWithSameDigits.nextSmaller(5614283097L);

    }
}
