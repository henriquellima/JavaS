package com.reading.core.Tests;
import java.lang.ClassLoader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class TesteReflection {
    public static void main(String[] args){

        Object classReflected = null;

        try {
            classReflected = Class.forName("com.reading.core.classes.Chefe").newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }


        System.out.println(classReflected.getClass().getName());

        for(Method m : classReflected.getClass().getMethods()){
            System.out.println(m.getName());
        }

        System.out.println("--------------------");
        System.out.println("--------------------");
        System.out.println("--------------------");

        for(Field f : classReflected.getClass().getDeclaredFields()){
            System.out.println(f.getName());
            System.out.println("oii");
        }

    }
}
