package com.java.basetype;

/**
 * @auther: wynnzuo
 * @date: 2018/11/4 16:10
 * @description:java自动拆装箱
 */
public class AutoUnboxing {
    /**
     * 自动拆装箱
     */
    public static void AutoUnbox(){
        Integer a = new Integer(3);
        Integer b = 3;//自动装箱 Integer类型
        int c = 3;
        System.out.println(a.equals(b));
        System.out.println(a==b);//不同的引用 false
        System.out.println(b==c);//自动拆箱 true
        System.out.println(a==c);//自动拆箱 true
    }

    /**
     * Integer的内部类IntegerCache
     */
    public static void IntegerCache(){
        Integer f1=127,f2=127,f3=128,f4=128;
        System.out.println(f1==f2);
        System.out.println(f3==f4);
    }

    /**
     * intern()
     */
    public static void StringIntern(){
        String s = new StringBuilder("go").append("od").toString();
        System.out.println(s==s.intern());
        String s3= new String("java");
        System.out.println(s3.intern()==s3);
        String s1 = new StringBuilder("ja").append("av").toString();
        System.out.println(s1.intern()==s1);
        String s2= "java";
        System.out.println(s2.intern()==s2);
        String s4 = new StringBuilder("hel").append("lo").toString();
        System.out.println(s4==s4.intern());
    }
    public static void main(String[] args) {
        AutoUnbox();
        System.out.println("======");
        IntegerCache();
        System.out.println("======");
        StringIntern();
    }
}
