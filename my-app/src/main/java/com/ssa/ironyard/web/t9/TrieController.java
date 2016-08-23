package com.ssa.ironyard.web.t9;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class TrieController
{
    @Autowired
    Text9Trie trie;
    
    @RequestMapping("/trie")
    @ResponseBody
    public List<String> suggestions(HttpServletRequest request) throws URISyntaxException, IOException
    { 
  
        return this.trie.suggestions(request.getParameter("digits"));
     
    }
}
