package com.whisper.springsecurity.demo;


import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * java中泛型的用法
 */
public class DemoTest {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        //泛型信息在编译之后被擦除，所以下面的System.out.println("=======================");能正常打印

        /*List<String> stringArrayList = new ArrayList<>();
        List<Integer> integerArrayList = new ArrayList<>();

        Class classStringArrayList = stringArrayList.getClass();
        Class classIntegerArrayList = integerArrayList.getClass();

        if (classStringArrayList.equals(classIntegerArrayList)) {
            System.out.println("=======================");
        }*/


        ArrayList<Integer> array = new ArrayList<Integer>();
        //这样调用add方法只能存储整形，因为泛型类型的实例为Integer
        //通过反射可以add String类型的值，这是因为泛型在编译后会进行类型擦除
        array.add(1);
        array.getClass().getMethod("add", Object.class).invoke(array, "asd");
        for (int i = 0; i < array.size(); i++) {
            System.out.println(array.get(i));
        }



        //队列：先进先出
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        int a = queue.remove();
        System.out.println(a);
        System.out.println(queue.size());



        //"+"的优先级高于"==",所以下面的相当于比较"s1 == s2 is:runoob" == "runoob"
        String s1 = "runoob";
        String s2 = "runoob";
        System.out.println("s1 == s2 is:" + s1 == s2);

    }
}
