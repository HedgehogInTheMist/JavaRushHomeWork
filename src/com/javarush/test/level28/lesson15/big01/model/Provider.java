package com.javarush.test.level28.lesson15.big01.model;

/**
 * Created by advirtys on 19.01.16.
 */
public class Provider {
    private Strategy strategy;

    public Provider(Strategy strategy)
    {
        this.strategy = strategy;
    }

    public void setStrategy(Strategy strategy)
    {
        this.strategy = strategy;
    }
}
