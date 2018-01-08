package com.jorgehernandezramirez.codewars.test;

import com.jorgehernandezramirez.codewars.PaginationHelper;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class PaginationHelperTest {
    @Test
    public void testWithFourElementByPage() {
        final PaginationHelper<Character> helper = new PaginationHelper(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f'), 4);
        assertEquals(2, helper.pageCount());
        assertEquals(6, helper.itemCount());
        assertEquals(4, helper.pageItemCount(0));
        assertEquals(2, helper.pageItemCount(1));
        assertEquals(-1, helper.pageItemCount(2));
        assertEquals(-1, helper.pageItemCount(-1));
        assertEquals(0, helper.pageIndex(0));
        assertEquals(0, helper.pageIndex(1));
        assertEquals(0, helper.pageIndex(3));
        assertEquals(1, helper.pageIndex(4));
        assertEquals(1, helper.pageIndex(5));
        assertEquals(-1, helper.pageIndex(6));
    }

    @Test
    public void testWithOneElementByPage() {
        final PaginationHelper<Character> helper = new PaginationHelper(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f'), 1);
        assertEquals(6, helper.pageCount());
        assertEquals(6, helper.itemCount());
        assertEquals(1, helper.pageItemCount(0));
        assertEquals(1, helper.pageItemCount(1));
        assertEquals(1, helper.pageItemCount(2));
        assertEquals(1, helper.pageItemCount(5));
        assertEquals(-1, helper.pageItemCount(6));
        assertEquals(-1, helper.pageItemCount(-1));
    }

    @Test
    public void testWithElementByPage() {
        final PaginationHelper<Character> helper = new PaginationHelper(Arrays.asList('a', 'b', 'c', 'd'), 4);
        assertEquals(1, helper.pageCount());
        assertEquals(4, helper.itemCount());
        assertEquals(4, helper.pageItemCount(0));
        assertEquals(-1, helper.pageItemCount(1));
    }
}
