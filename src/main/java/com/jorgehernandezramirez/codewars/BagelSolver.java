package com.jorgehernandezramirez.codewars;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.stream.Stream;

public class BagelSolver {

    public static Bagel getBagel(){
        Bagel bagel = (Bagel)Proxy.newProxyInstance(BagelSolver.class.getClassLoader(),
                                      Bagel.class.getInterfaces(),
                                      new BagelDynamicProxy());
        return null;
    }



    private static class BagelDynamicProxy implements InvocationHandler {

        public BagelDynamicProxy(){
            super();
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            return 4;
        }
    }

}
