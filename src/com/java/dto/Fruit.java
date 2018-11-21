package com.java.dto;

/**
 * @auther: wynnzuo
 * @date: 2018/11/21 12:13
 * @description:
 */
public class Fruit {
    private Apple apple1;
    private Apple apple2;

    public Apple getApple1() {
        return apple1;
    }

    public void setApple1(Apple apple1) {
        this.apple1 = apple1;
    }

    public Apple getApple2() {
        return apple2;
    }

    public void setApple2(Apple apple2) {
        this.apple2 = apple2;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "apple1=" + apple1 +
                ", apple2=" + apple2 +
                '}';
    }
}
