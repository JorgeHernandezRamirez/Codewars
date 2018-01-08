package com.jorgehernandezramirez.codewars;

public class Matrix {

    public static void enter() {
        Matrix.<RuntimeException>scape();
    }

    private static <T extends Throwable> void scape() throws T{
        throw (T)new Neo();
    }
}
