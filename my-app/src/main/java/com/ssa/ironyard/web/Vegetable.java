package com.ssa.ironyard.web;

public class Vegetable
{
    private final Color color;
    private final String name;
    
    public Vegetable(Color yellow, String name)
    {

        this.color = yellow;
        this.name = name;
    }
    
    public String getName()
    {
        return this.name;
    }

    enum Color
    {
        RED, GREEN, YELLOW, BROWN;
    }

    public Color getColor()
    {
        return color;
    }
    
    
}
