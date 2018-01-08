package com.jorgehernandezramirez.codewars.test;

import com.jorgehernandezramirez.codewars.Primes;
import org.junit.Test;

import java.util.Arrays;
import java.util.stream.LongStream;

import static org.junit.Assert.assertArrayEquals;

public class PrimesTest {

    @Test
    public void test_0_10() {
        test(0, 10, 2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
    }

    @Test
    public void test_10_10() {
        test(10, 10, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71);
    }

    @Test
    public void test_100_10() {
        test(100, 10, 547, 557, 563, 569, 571, 577, 587, 593, 599, 601);
    }

    @Test
    public void test_1000_10() {
        test(1000, 10, 7927, 7933, 7937, 7949, 7951, 7963, 7993, 8009, 8011, 8017);
    }

    //@Test
    public void prueba(){
        System.out.println(Arrays.toString(Primes.stream().skip(1000000).limit(10).toArray()));
    }

    //@Test
    public void preuba2(){
        boolean[] primes = sieveOfAtkin();
        System.out.println(Arrays.toString(LongStream.range(0, primes.length).filter(i -> primes[(int)i]).toArray()));
    }



    //private static final int MAX = 100000000;
    private static final int MAX = 100000000;
    private static final int SQRT_MAX = (int) Math.sqrt(MAX) + 1;


    private boolean[] sieveOfAtkin(){

        boolean[] array = new boolean[MAX];
        for (int x = 1; x < SQRT_MAX; x++) {
            for (int y = 1; y < SQRT_MAX; y++) {
                int k = 4 * x * x + y * y;
                if ((k < MAX) && ((k % 12 == 1) || (k % 12 == 5))) {
                    array[k] = !array[k];
                }
                k = 3 * x * x + y * y;
                if ((k < MAX) && (k % 12 == 7)) {
                    array[k] = !array[k];
                }
                if (x > y) {
                    k = 3 * x * x - y * y;
                    if ((k < MAX) && (k % 12 == 11)) {
                        array[k] = !array[k];
                    }
                }
            }
        }
        array[2] = true;
        array[3] = true;
        for (int n = 5; n <= SQRT_MAX; n++) {
            if (array[n]) {
                int n2 = n * n;
                for (int k = n2; k < MAX; k += n2) {
                    array[k] = false;
                }
            }
        }
        return array;
    }

    private void test(int skip, int limit, int... expect) {
        int[] found = Primes.stream().skip(skip).limit(limit).toArray();
        assertArrayEquals(expect, found);
    }

}
