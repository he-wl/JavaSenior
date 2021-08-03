package com.hewl.java2;

import com.hewl.java1.Person;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author wen
 * @date 2021-07-18
 */
public class OtherTest {

    //获取构造器
    @Test
    public void test(){
        Class clazz = Person.class;

        //getConstructors():获取当前运行时类声明为public的构造器
        Constructor[] constructors = clazz.getConstructors();
        for(Constructor c: constructors){
            System.out.println(c);
        }
        System.out.println();
        //getDeclaredConstructors:获取当前运行时类声明的所有构造器
        Constructor[] declaredConstructors = clazz.getDeclaredConstructors();
        for(Constructor c:declaredConstructors){
            System.out.println(c);
        }
    }
    //获取运行时类的父类及其父类的泛型
    @Test
    public void test1(){
        Class clazz = Person.class;
        Class superclass = clazz.getSuperclass();
        System.out.println(superclass);
    }
    //获取运行时类的带泛型的父类的泛型
    @Test
    public void test2(){
        Class clazz = Person.class;
        Type genericSuperclass = clazz.getGenericSuperclass();
        ParameterizedType paramType = (ParameterizedType) genericSuperclass;
        //获取泛型类型
        Type[] actualTypeArguments = paramType.getActualTypeArguments();

        System.out.println(((Class)actualTypeArguments[0]).getTypeName());
    }
    //获取运行时类实现的接口
    @Test
    public void test3(){
        Class clazz = Person.class;
        Class[] interfaces = clazz.getInterfaces();
        for(Class p:interfaces){
            System.out.println(p);
        }
        System.out.println();
        //获取运行时类的父类的实现的接口
        Class[] interfaces1 = clazz.getSuperclass().getInterfaces();
        for(Class p:interfaces1){
            System.out.println(p);
        }
    }
    //获取运行时类所在的包
    @Test
    public void test4(){
        Class clazz = Person.class;
        Package aPackage = clazz.getPackage();
        System.out.println(aPackage);
    }
    //获取运行时类的注解
    @Test
    public void test5(){
        Class clazz = Person.class;
        Annotation[] annotations = clazz.getAnnotations();
        for(Annotation a:annotations){
            System.out.println(a);
        }
    }
}
