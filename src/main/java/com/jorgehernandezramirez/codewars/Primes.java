package com.jorgehernandezramirez.codewars;

import java.util.stream.IntStream;

public class Primes {

    private static boolean[] primes = null;

    public static IntStream stream() {
        boolean[] primes = getPrimes();
        return IntStream.range(0, primes.length).filter(i -> primes[(int)i]);
    }

    private static boolean[] getPrimes(){
        if(primes == null) {
            primes = sieveOfAtkin(100000000);
        }
        return primes;
    }

    private static boolean[] sieveOfAtkin(final int max){
        final int sqrt_max = (int) Math.sqrt(max) + 1;
        boolean[] array = new boolean[max];
        for (int x = 1; x < sqrt_max; x++) {
            for (int y = 1; y < sqrt_max; y++) {
                int k = 4 * x * x + y * y;
                if ((k < max) && ((k % 12 == 1) || (k % 12 == 5))) {
                    array[k] = !array[k];
                }
                k = 3 * x * x + y * y;
                if ((k < max) && (k % 12 == 7)) {
                    array[k] = !array[k];
                }
                if (x > y) {
                    k = 3 * x * x - y * y;
                    if ((k < max) && (k % 12 == 11)) {
                        array[k] = !array[k];
                    }
                }
            }
        }
        array[2] = true;
        array[3] = true;
        for (int n = 5; n <= sqrt_max; n++) {
            if (array[n]) {
                int n2 = n * n;
                for (int k = n2; k < max; k += n2) {
                    array[k] = false;
                }
            }
        }
        return array;
    }



    //Primero
    /*public static IntStream stream() {
        return IntStream.iterate(2, i -> ++i)
                .filter(i -> isPrime(i));
    }

    private static Boolean isPrime(final Integer number){
        return number.equals(Stream.iterate(2, i -> ++i)
                .filter(i -> number % i == 0)
                .findFirst()
                .get());*/

    //Segundo
    /*public static IntStream stream() {
        return IntStream.iterate(2, i -> ++i)
                .filter(i -> isPrime(i));
    }

    public static boolean isPrime(long x) {
        return LongStream.rangeClosed(2, (long)(Math.sqrt(x)))
                         .allMatch(n -> x % n != 0);
    }*/

    //Tercero -> Algoritmo Sieve_of_Eratosthenes. Un numero es primo si no es divisible por sus anteriores primos
    /*public static IntStream stream() {
        final List<Integer> primes = new ArrayList<Integer>();
        return IntStream
                .iterate(2, i -> i + 1)
                .filter(i -> isDivisibleByAllPrimes(i, primes))
                .peek(i -> primes.add(i));
    }

    private static Boolean isDivisibleByAllPrimes(final Integer number, final Set<Integer> primes){
        return primes.stream().allMatch(integer -> number % integer != 0);
    }*/

}
