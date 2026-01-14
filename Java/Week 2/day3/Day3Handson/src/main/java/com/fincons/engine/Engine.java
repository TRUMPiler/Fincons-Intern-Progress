package com.fincons.engine;

public class Engine {
    private int id;
    private String type;

    public Engine(int id, String type) {
        this.id = id;
        this.type = type;
    }

    public void start() {
        System.out.println("Engine [ID=" + id + ", Type=" + type + "] started.");
    }
}
