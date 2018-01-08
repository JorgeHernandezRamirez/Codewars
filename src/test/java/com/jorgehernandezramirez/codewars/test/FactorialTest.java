package com.jorgehernandezramirez.codewars.test;

import com.jorgehernandezramirez.codewars.Factorial;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FactorialTest {

    @Test
    public void BasicTests(){
        assertEquals("1", Factorial.Factorial(1));
        assertEquals("120", Factorial.Factorial(5));
        assertEquals("362880", Factorial.Factorial(9));
        assertEquals("1307674368000", Factorial.Factorial(15));
        assertEquals("33931086844518982011982560935885732032396635556994207701963662088123265314176330336254535971207181169698868584991941607780111073928236261199604691797570505851011072000000000000000000000000000", Factorial.Factorial(116));
    }

}
