package org.ssa.ironyard.web;

import org.springframework.stereotype.Component;

@Component
public class MathService
{
    
    public String add(String num1, String num2)
    {
        int a = (int) num1.indexOf(0);
        int b = (int) num2.indexOf(0);
        int total = a+b;
        String minusString = a + "+" + b + "=" + total;
        return minusString;
    }
    
    public String minus(String num1, String  num2)
    {
        int a = (int) num1.indexOf(0);
        int b = (int) num2.indexOf(0);
        int total = a-b;
        String minusString = a + "-" + b + "=" + total;
        return minusString;
    }
    
    public String multiply(String num1, String num2)
    {
        int a = (int) num1.charAt(0);
        int b = (int) num2.charAt(0);
        int total = a*b;
        String minusString = a + "*" + b + "=" + total;
        return minusString;
    }
    
    public String divide(String num1, String num2)
    {
        int a = (int) num1.charAt(0);
        int b = (int) num2.charAt(0);
        int total = a/b;
        String minusString = a + "/" + b + "=" + total;
        return minusString;
    }
    
    
}
