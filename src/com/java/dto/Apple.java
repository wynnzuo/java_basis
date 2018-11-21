package com.java.dto;

/**
 * @auther: wynnzuo
 * @date: 2018/11/21 12:12
 * @description:
 */
public class Apple {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
