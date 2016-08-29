package org.ssa.ironyard.web.zoo;

import java.util.List;


public class Animals
{
    private String animal;
    private List<Continents> continents;
    private String detail;
    private String url;
    
    public Animals(String animal, List<Continents> continents, String detail)
    {
        this.animal = animal;
        this.continents = continents;
        this.detail = detail;
        this.url = "localhost:8080/zoo/animals/" + animal;
    }
    
    public Animals(String Animal)
    {
        this.animal = "This animal is not in the zoo";
    }
    
    
    

    public String getAnimal()
    {
        return animal;
    }

    public List<Continents> getContinents()
    {
        return continents;
    }

    public String getDetail()
    {
        return detail;
    }

    public String getUrl()
    {
        return url;
    }
    
    enum Continents
    {
        NORTH_AMERICA , SOUTH_AMERICA , ASIA , AFRICA , AUSTRALIA , ANTARTICA, EUROPE, OCEAN, FANTASY_LAND, PANGAEA;
    }
    
    
    
    
}
