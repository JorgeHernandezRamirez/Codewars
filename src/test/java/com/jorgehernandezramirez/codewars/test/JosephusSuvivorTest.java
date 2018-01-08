package com.jorgehernandezramirez.codewars.test;

import com.jorgehernandezramirez.codewars.JosephusSurvivor;
import org.junit.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class JosephusSuvivorTest {

    @Test
    public void test1() {
        josephusTest(7, 3, 4);
    }

    @Test
    public void test2() {
        josephusTest(11, 19, 10);
    }

    @Test
    public void test3() {
        josephusTest(40, 3, 28);
    }

    @Test
    public void test4() {
        josephusTest(14, 2, 13);
    }

    @Test
    public void test5() {
        josephusTest(100, 1, 100);
    }

    private void josephusTest(final int n, final int k, final int result) {
        String testDescription = String.format("Testing where n = %d and k = %d", n, k);
        assertEquals(testDescription, result, JosephusSurvivor.josephusSurvivor(n, k));
    }

    static String ODDS = "odds win";
    static String EVENS = "evens win";
    static String TIE = "tie";

    @Test
    public void prueba(){
        assertThat(bitsWar(new int[]{1,5,12}), is(ODDS));
        assertThat(bitsWar(new int[]{7,-3,20}), is(EVENS));
        assertThat(bitsWar(new int[]{7,-3,-2,6}), is(TIE));
        assertThat(bitsWar(new int[]{-3,-5}), is(EVENS));
        assertThat(bitsWar(new int[]{}), is(TIE));

        System.out.println(Arrays.toString(Arrays.stream(new int[]{7,-3,-2,6}).mapToObj(value -> Integer.toBinaryString(value < 0 ? -1 * value : value)).toArray()));

    }

    public static String bitsWar(int[] numbers) {
        int evenSum = Arrays.stream(numbers)
                            .filter(value -> value % 2 == 0)
                            .map(value -> getNumberOfOnesInBinarySigned(value))
                            .sum();
        int oddSum = Arrays.stream(numbers)
                           .filter(value -> value % 2 != 0)
                           .map(value -> getNumberOfOnesInBinarySigned(value))
                           .sum();
        return oddSum == evenSum ? "tie" : (oddSum > evenSum ? "odds win" : "evens win");
    }

    private static Integer getNumberOfOnesInBinarySigned(final Integer number){
        return Long.valueOf(Integer.toBinaryString(number < 0 ? -1 * number : number)
                                   .chars()
                                   .mapToObj(value -> String.valueOf((char)value))
                                   .filter(s -> "1".equals(s)).count() * (number < 0 ? -1 : 1)
                            ).intValue();
    }

    @Test
    public void testZeros() throws Exception {
        assertThat(zeros(0), is(0));
        assertThat(zeros(6), is(1));
        assertThat(zeros(14), is(2));
    }

    public static int zeros(int n) {
        return IntStream.rangeClosed(1, log(n ,5))
                        .map(k -> (int)Math.floor(n / Math.pow(5, k)))
                        .sum();
    }

    private static int log(int x, int base){
        return (int) Math.floor(Math.log(x) / Math.log(base));
    }

    public static int consecKprimes(int k, long[] arr) {
        return Long.valueOf(IntStream.range(1, arr.length)
                                     .mapToObj(index -> new long[]{arr[index - 1], arr[index]})
                                     .filter(longs -> {
                                        int kprime1 = kprime(longs[0]);
                                        int kprime2 = kprime(longs[1]);
                                        return kprime1 == kprime2 && k == kprime1;
                                     })
                                     .count()
                            ).intValue();
    }

    private static Integer kprime(long value){
        int factor = 2;
        int kprime = 0;
        while (factor <= value){
            while (value % factor == 0 ){
                kprime++;
                value = value / factor;
            }
            factor++;
        }
        return kprime;
    }

    private static void testing(int k, long[] arr, int expected) {
        assertEquals(expected, consecKprimes(k, arr));
    }

    @Test
    public void test10() {
        System.out.println("Basic Tests consecKprimes");
        consecKprimes(2, new long[]{4, 6, 9, 10, 32});

        testing(6, new long[] {10098}, 0);
        testing(6, new long[] {10176, 10164}, 0);
        testing(5, new long[] {10116, 10108, 10092, 10104, 10100, 10096, 10088}, 6);
        testing(5, new long[] {10188, 10192, 10212, 10184, 10200, 10208}, 1);
        testing(4, new long[] {10175, 10185, 10180, 10197}, 3);
    }
}
