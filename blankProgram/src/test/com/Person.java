package com;

import java.util.Objects;

public class Person {
    int id;
    String name;


    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
    public Person() {
    }

}
