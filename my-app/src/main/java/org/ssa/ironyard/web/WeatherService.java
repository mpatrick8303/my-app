package org.ssa.ironyard.web;

import org.springframework.stereotype.Component;

@Component//tells spring that this class is something that other services that are dependent on
public class WeatherService
{
    
    public float temperature()
    {
        return 67.7f;
    }
}
