package com.linkai.easy;

import java.lang.reflect.Field;

/**
 * @ClassName: StringTest
 * @Description: TODO
 * @Author: K LIn
 * @Date: 19-2-21 下午12:49
 * @Version: 1.0
 * Remember to sow in the spring.
 **/
public class StringTest {
    public static void main(String[] args) {
        //创建字符串"Hello World"， 并赋给引用s
        String s1 = new String("hello world");

        String s = "hello world";
        System.out.println(s.hashCode());
        System.out.println(s1.hashCode());
        System.out.println(s==s1);

        dog g = new dog();

        System.out.println("s = " + s);	//Hello World
        System.out.println("shashcode = " + s.hashCode());

        //获取String类中的value字段
        Field valueFieldOfString = null;
        try {
            valueFieldOfString = String.class.getDeclaredField("value");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        //改变value属性的访问权限
        valueFieldOfString.setAccessible(true);

        //获取s对象上的value属性的值
        char[] value = new char[0];
        try {
            value = (char[]) valueFieldOfString.get(s);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        //改变value所引用的数组中的第5个字符
        value[5] = '_';

        System.out.println("s = " + s);  //Hello_World
        System.out.println("shashcode = " + s.hashCode());
        System.out.println("s1 = " +s1);
        System.out.println("g = " + g.name);
        System.out.println("ghash = " + g.name.hashCode());

    }
}

class dog{
    String name = "hello world";
}
