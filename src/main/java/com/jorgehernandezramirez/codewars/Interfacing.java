package com.jorgehernandezramirez.codewars;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class Interfacing {

    public static Object create(final Class<?>[] interfaces) {
        return Proxy.newProxyInstance(new MyClassLoader(Interfacing.class.getClassLoader(), interfaces),
                interfaces,
                new GetterSetterDynamicProxy());
    }

    public static class MyClassLoader extends ClassLoader{

        private final Class<?>[] interfaces;

        private final ClassLoader parent;

        public MyClassLoader(ClassLoader parent, Class<?>[] interfaces) {
            super(parent);
            this.interfaces = interfaces;
            this.parent = parent;
        }

        public Class loadClass(String name) throws ClassNotFoundException {
            for(Class clazz : interfaces){
                if(clazz.getName().equals(name)){
                    return clazz;
                }
            }
            return this.parent.loadClass(name);
        }
    }

    private static class GetterSetterDynamicProxy implements InvocationHandler {

        private final Map<String, Object> methodValues;

        public GetterSetterDynamicProxy(){
            this.methodValues = new HashMap<String, Object>();
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            if(isAnSetterMethod(method)){
                putValue(method, args);
                return null;
            }
            else{
                return getValue(method);
            }
        }

        private Object getValue(final Method method){
            return methodValues.get(getVariableName(method));
        }

        private void putValue(final Method method, final Object[] args){
            methodValues.put(getVariableName(method), args[0]);
        }

        private String getVariableName(final Method method){
            if(method.getName().startsWith("set") || method.getName().startsWith("get")){
                return method.getName().substring(3, 4).toLowerCase() + method.getName().substring(4);
            }
            return method.getName();
        }

        private Boolean isAnSetterMethod(final Method method){
            return method.getName().startsWith("set");
        }
    }
}