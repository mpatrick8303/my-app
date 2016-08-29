package org.ssa.ironyard.web;

public class MyCar
{
    private final String model;
    private final Make make;
    private final Color2 color;
    
  
    public MyCar(String model, Make make, Color2 color)
    {
        
        this.make = make;
        this.model = model;
        this.color = color;
    }

    enum Make
    {
        NISSAN, TOYOTA, CHEVY, AUDI, INFINITY, SCION
    }
    
    enum Color2
    {
        BLUE, RED, GREEN, BLACK, WHITE
    }

    public String getModel()
    {
        return model;
    }

    public Make getMake()
    {
        return make;
    }

    public Color2 getColor()
    {
        return color;
    }
    
    
    
    
}
