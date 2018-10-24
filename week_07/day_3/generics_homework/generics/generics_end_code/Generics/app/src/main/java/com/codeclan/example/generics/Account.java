package com.codeclan.example.generics;


public class Account<T> {

    private T id;
    private String name;

    public Account(T id, String name)
    {
        this.id = id;
        this.name = name;
    }

    public T getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

}
