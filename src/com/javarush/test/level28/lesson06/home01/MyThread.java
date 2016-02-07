package com.javarush.test.level28.lesson06.home01;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by advirtys on 23.01.16.
 */
public class MyThread extends Thread {
    private static AtomicInteger ai = new AtomicInteger(1);

    public MyThread()
    {
        incPriority();
    }

    public MyThread(Runnable target)
    {
        super(target);
        incPriority();
    }

    public MyThread(ThreadGroup group, Runnable target)
    {
        super(group, target);
        incPriority();
    }

    public MyThread(String name)
    {
        super(name);
        incPriority();
    }

    public MyThread(ThreadGroup group, String name)
    {
        super(group, name);
        incPriority();
    }

    public MyThread(Runnable target, String name)
    {
        super(target, name);
        incPriority();
    }

    public MyThread(ThreadGroup group, Runnable target, String name)
    {
        super(group, target, name);
        incPriority();
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize)
    {
        super(group, target, name, stackSize);
        incPriority();
    }

    private void incPriority(){
        setPriority(ai.get());
        if (ai.get() == 10){
            ai.set(0);
        }
        ai.incrementAndGet();
    }
}
