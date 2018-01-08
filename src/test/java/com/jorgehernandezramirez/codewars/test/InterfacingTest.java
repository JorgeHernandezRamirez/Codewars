package com.jorgehernandezramirez.codewars.test;

import com.jorgehernandezramirez.codewars.Interfacing;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class InterfacingTest {

    @Test
    public void test(){
        Interface1 interface1 = (Interface1)Interfacing.create(new Class[]{Interface1.class, Interface2.class});
        interface1.setMethod1(1);
        assertEquals(1L, interface1.getMethod1().longValue());
        final Date date = new Date();
        Interface2 interface2 = (Interface2)interface1;
        interface2.setMethod2(date);
        assertEquals(date, interface2.getMethod2());
    }

    public interface Interface1 {

        Integer getMethod1();

        void setMethod1(Integer i);
    }
}
