package com.jorgehernandezramirez.codewars;

public class XO {

    public static boolean getXO (final String str) {
        return numberOfX(str.toLowerCase(), "x")
                .equals(numberOfX(str.toLowerCase(), "o"));
    }

    private static Long numberOfX(final String str, final String textToLookFor){
        return str.chars()
                  .mapToObj(c -> String.valueOf((char)c))
                  .filter(s -> s.equals(textToLookFor))
                  .count();
    }
}
