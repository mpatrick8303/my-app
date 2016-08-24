package com.ssa.ironyard.web.t9;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller//no matter how many times it's called spring only makes one instance of the object into the application context that continue to run until you shut it down
public class TrieController
{
    @Autowired//could be a bunch of these in different classes but all point to the same instance
    T9Trie trie;
    
    public void setTrie(T9Trie trie)
    {
        this.trie = trie;
    }
    
    @RequestMapping("/trie")
    @ResponseBody
    public List<String> suggestions(HttpServletRequest request) throws URISyntaxException, IOException
    { 
        
        String digits = request.getParameter("digits");
        
        
        if(!request.getParameter("digits").matches("[2-9]+"))
            return Arrays.asList("not", "implemented", "yet");
        if(!Strings.isEmpty(request.getParameter("digits")))
            return this.trie.suggestions(request.getParameter("digits"));
        else 
            return Arrays.asList("not", "implemented", "yet");
        
            
     
    }


}
    

