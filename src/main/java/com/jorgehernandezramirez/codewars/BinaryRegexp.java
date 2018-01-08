package com.jorgehernandezramirez.codewars;

import java.util.regex.Pattern;

public class BinaryRegexp {

    public static Pattern multipleOf3() {
        return Pattern.compile("(0|1(01*0)*1)*");
    }
}
