package com.javarush.test.level23.lesson13.big01;

import java.util.ArrayList;

/**
 * Created by advirtys on 08.12.15.
 */
public class Snake
{

    public Snake(int x, int y)
    {
        SnakeSection ss = new SnakeSection(x, y);
        sections = new ArrayList<>();
        sections.add(ss);
        isAlive = true;


    }

    private ArrayList<SnakeSection> sections;
    private boolean isAlive;
    private SnakeDirection direction;

    public SnakeDirection getDirection()
    {
        return direction;
    }

    public boolean isAlive()
    {
        return isAlive;
    }

    public ArrayList<SnakeSection> getSections()
    {
        return sections;
    }

    public void setDirection(SnakeDirection direction)
    {
        this.direction = direction;
    }

    public void move(){

    }
}
