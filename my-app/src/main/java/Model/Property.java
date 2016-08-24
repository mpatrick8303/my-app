package Model;

import org.springframework.stereotype.Component;

@Component
public class Property
{
    private int postal;
    private String street;
    private String city;
    private String state;
    private int zipcode;
    private int cost;
    private int floorArea;
    private int bedrooms;

    public Property( int postal, String street, String city, String state, int zipcode, int cost, int bedrooms, int floorA)
    {
        
        this.postal = postal;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.cost = cost;
        this.bedrooms = bedrooms;
        this.floorArea = floorA;
    }

    public Property(String noProperties)
    {
        this.street = noProperties;
    }

    public String getCity()
    {
        return city;
    }

    public String getStreet()
    {
        return street;
    }

    public int getCost()
    {
        return cost;
    }

    public int getFloorArea()
    {
        return floorArea;
    }

    public int getBedrooms()
    {
        return bedrooms;
    }
    
    public String getState()
    {
        return state;
    }

}
