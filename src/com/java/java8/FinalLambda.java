package com.java.java8;

import com.java.dto.Apple;
import com.java.dto.Fruit;

/**
 * @auther: wynnzuo
 * @date: 2018/11/15 14:04
 * @description:
 */
public class FinalLambda {
    public static void main(String[] args) {
        Fruit fruit = new Fruit();
        Apple apple1 = new Apple();
        fruit.setApple1(apple1);
        Apple apple2 = new Apple();
        fruit.setApple2(apple2);
//        apple1.setId(1);
//        apple1.setName("iphone");
//        apple2.setId(2);
//        apple2.setName("macbook");
        System.out.println(fruit);
    }
}
