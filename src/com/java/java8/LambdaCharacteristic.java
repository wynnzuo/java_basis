package com.java.java8;

import java.util.*;
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
//        streamFilter();
        sortByMapValue();
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
    /**
     * 通过lambda表达式，对map的value进行排序
     */
    public static void sortByMapValue() {

        // 初始数据
        Map<String, Integer> smap = new HashMap<>();
        smap.put("1", 11);
        smap.put("3", 33);
        smap.put("2", 22);

        // 1.8以前
        List<Map.Entry<String, Integer>> list1 = new ArrayList<>();
        list1.addAll(smap.entrySet());
        Collections.sort(list1, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue() - o2.getValue();
            }
        });
        for (Map.Entry<String, Integer> entry : list1) {
            System.out.println("key:" + entry.getKey() + ",value:" + entry.getValue());
        }

        // 1.8使用lambda表达式
        List<Map.Entry<String, Integer>> list2 = new ArrayList<>();
        list2.addAll(smap.entrySet());
        Collections.sort(list2, (o1, o2) -> o1.getValue() - o2.getValue());
        list2.forEach(entry -> {
            System.out.println("key:" + entry.getKey() + ",value:" + entry.getValue());
        });
    }
}
