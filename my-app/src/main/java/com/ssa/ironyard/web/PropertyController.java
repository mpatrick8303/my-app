package com.ssa.ironyard.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import Model.Property;

@RestController
public class PropertyController
{
    
    
    @RequestMapping("/realestate/{city}/{street}")
    @ResponseBody
    public List<Property> searchCityStreet(@PathVariable String city, @PathVariable String street)
    {
        List<Property> cityStreetProperties = new ArrayList<>();
        
        for(int i = 0;i<properties().size();i++)
        {
            if(city.toLowerCase().equals(properties().get(i).getCity()) && street.toLowerCase().equals(properties().get(i).getStreet()))
                cityStreetProperties.add(properties().get(i));
        }
        
        return cityStreetProperties;
       
    }
    
    @RequestMapping("/realestate/{city}")
    @ResponseBody
    public List<Property> searchCity(@PathVariable String city)
    {
        List<Property> cityProperties = new ArrayList<>();
        
        for(int i = 0;i<properties().size();i++)
        {
            if(city.toLowerCase().equals(properties().get(i).getCity()))
                cityProperties.add(properties().get(i));
        }
        
        return cityProperties;
       
    }
    
//    @RequestMapping("/realestate/{state}")
//    @ResponseBody
//    public List<Property> searchState(@PathVariable String state)
//    {
//        List<Property> stateProperties = new ArrayList<>();
//        
//        for(int i = 0;i<properties().size();i++)
//        {
//            if(state.toLowerCase().equals(properties().get(i).getState()))
//                stateProperties.add(properties().get(i));
//        }
//        
//        return stateProperties;
//       
//    }
    
   
    
    public List<Property> properties()
    {
        List<Property> properties = new ArrayList<>();
        properties.add(new Property(1199,"watervale" , "pasadena" ,"MD", 21122,100000,5,1500));
        properties.add(new Property(1198, "watervale" ,"pasadena" , "MD", 21122, 200000,6,2000));
        properties.add(new Property(2222, "boxgrove", "baltimore" , "MD", 21122, 25000, 3, 1000));
        properties.add(new Property(1234, "main", "chicago", "IL", 25252, 10000, 3, 500));
        
        return properties;
        
    }
    
    
}
