package com.jorgehernandezramirez.codewars;

import java.util.Arrays;

public class ReverseWords{

    public ReverseWords(){
        super();
    }

    public static String reverseWords(final String str){
        return Arrays.asList(str.split(" ")).stream().reduce("", (string1, string2) -> {
            return string2 + " " +  string1;
        }).trim();
    }
}
