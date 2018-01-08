package com.jorgehernandezramirez.codewars.test;

import com.jorgehernandezramirez.codewars.FindUniq;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FindUniqTest {

    private double precision = 0.0000000000001;

    @Test
    public void sampleTestCases() {
        assertEquals(1L, (long)FindUniq.findUniq(new double[]{0, 1, 0, 0, 0, 0, 0}));
        assertEquals(2L, (long)FindUniq.findUniq(new double[]{1, 1, 1, 2, 1, 1}));
    }
}
