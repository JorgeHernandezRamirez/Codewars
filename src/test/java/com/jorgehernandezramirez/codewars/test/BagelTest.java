package com.jorgehernandezramirez.codewars.test;

import com.jorgehernandezramirez.codewars.Bagel;
import com.jorgehernandezramirez.codewars.BagelSolver;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BagelTest {

    @Test
    public void testBagel() {
        Bagel bagel = BagelSolver.getBagel();
        //SassertEquals(bagel.getValue() == 4, java.lang.Boolean.TRUE);
    }
}
