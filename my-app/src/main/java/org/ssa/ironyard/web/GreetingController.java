package org.ssa.ironyard.web;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.ssa.ironyard.web.MyCar.Color2;
import org.ssa.ironyard.web.MyCar.Make;
import org.ssa.ironyard.web.Vegetable.Color;
import org.ssa.ironyard.web.t9.TrieLoadingService;



@Controller//tells spring that this is a class that's going to look for request mapping
public class GreetingController
{

    static final Logger LOGGER = LogManager.getLogger(TrieLoadingService.class);
    
    @Autowired
    WeatherService weather;//sets it up so you can call weather and grab methods and stuff from that class
    
    @Autowired
    MathService math;
    

    
    @RequestMapping("/")//when you go to local host and put no path it calls the method below(specifying the path)
    @ResponseBody//means we can just return a plain java object and spring will send it down to the browser
    public String greet()
    {
        return "Our first web app";
    }
    
    @RequestMapping("/foo")
    @ResponseBody
    public Map<String, LocalDate> now()
    {
        Map<String, LocalDate> model = new HashMap<>();
        model.put("now", LocalDate.now());
        
        return model;
    }
    
    @RequestMapping("/zucchini")
    @ResponseBody
    public Vegetable zucchini()
    {
        return new Vegetable(Color.YELLOW, "zucchini");
    }
    
    @RequestMapping("/potato")
    @ResponseBody
    public Vegetable potato()
    {
        return new Vegetable(Color.BROWN, "potato");
    }
    
    @RequestMapping("/squash")
    @ResponseBody
    public Vegetable squash()
    {
        return new Vegetable(Color.GREEN, "squash");
    }
    
    @RequestMapping("/mycarsentra")
    @ResponseBody
    public String nissanSentra()
    {
        MyCar my = new MyCar("Sentra",Make.NISSAN,Color2.BLACK);
        String myCar = my.getMake() + " " + my.getModel() + " " + my.getColor();
        return myCar;
    }
    
    @RequestMapping("/mycaraudi")
    @ResponseBody
    public String audir8()
    {
        MyCar my = new MyCar("R8",Make.AUDI,Color2.BLACK);
        String myCar = my.getMake() + " " + my.getModel() + " " + my.getColor();
        return myCar;
    }
    
    @RequestMapping("/mycarscion")
    @ResponseBody
    public String sciontc()
    {
        MyCar my = new MyCar("TC",Make.SCION,Color2.BLUE);
        String myCar = my.getMake() + " " + my.getModel() + " " + my.getColor();
        return myCar;
    }
    
    @RequestMapping("/temp")
    @ResponseBody
    public float currentTemp()
    {
        return this.weather.temperature();
    }
    
   
    
    
//    @RequestMapping("/add")
//    @ResponseBody
//    public String add(HttpServletRequest request) throws URISyntaxException
//    {
//        
//        return this.math.add(request.getParameter("num1"), request.getParameter("num2"));
//    }
//    
//    @RequestMapping("/minus")
//    @ResponseBody
//    public String minus(HttpServletRequest request) throws URISyntaxException
//    {
//        return this.math.minus(request.getParameter("num1"), request.getParameter("num2"));
//    }
//    
//    @RequestMapping("/multiply")
//    @ResponseBody
//    public String multiply(HttpServletRequest request) throws URISyntaxException
//    {
//        return this.math.minus(request.getParameter("num1"), request.getParameter("num2"));
//    }
//    
//    @RequestMapping("/divide")
//    @ResponseBody
//    public String divide(HttpServletRequest request) throws URISyntaxException
//    {
        
//        return this.math.minus(request.getParameter("num1"), request.getParameter("num2"));
//    }
    
    
}
