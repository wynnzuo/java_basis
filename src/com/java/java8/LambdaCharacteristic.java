package com.java.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @auther: wynnzuo
 * @date: 2018/11/7 14:34
 * @description:
 */
public class LambdaCharacteristic {
    public static void main(String[] args) {
//        streamForeach();
//        streamMap();
        streamFilter();
    }

    /**
     * streamForeach
     */
    public static void streamForeach(){
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");

        list.stream().forEach(string ->{
            System.out.println(string);
        });
    }

    /**
     * streamMap
     */
    public static void streamMap(){
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");

        List<String> collect = list.stream().map(string -> {
            return "stream().map()处理之后：" + string;
        }).collect(Collectors.toList());

        collect.stream().forEach(string ->{
            System.out.println(string);
        });

        for(String str:list){
            System.out.println(str);
        }
    }
    /**
     * streamFilter
     */
    public static void streamFilter(){
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("3");

        List<String> collect = list.stream().filter(s ->
                !s.equals("3")
        ).collect(Collectors.toList());
        collect.forEach(s -> {
            System.out.println(s);
        });
    }
}
