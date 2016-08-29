package org.ssa.ironyard.web.t9;

import static org.junit.Assert.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;

public class TrieControllerTest
{
    
    TrieController trieController = new TrieController();

    @Test
    public void test() throws URISyntaxException, IOException
    {
        MockHttpServletRequest request = new MockHttpServletRequest("GET","/trie");//get is common work for when your typing something in browser
        request.setParameter("digits", "abcd");
        List<String> suggestions = this.trieController.suggestions(request);
        System.err.println(suggestions);
    }
    
    @Test
    public void Success() throws URISyntaxException, IOException
    {
        this.trieController.setTrie(new MockT9Trie());
        MockHttpServletRequest request = new MockHttpServletRequest("GET","/trie");
        request.setParameter("digits", "277");
        assertEquals("",2, this.trieController.suggestions(request).size());
    }
    
}

class MockT9Trie implements T9Trie
{

    @Override
    public void addWord(String word)
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public List<String> suggestions(String digits)
    {
        
        return Arrays.asList("cat","dog");
    }

    @Override
    public void clear()
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void contains(String word)
    {
        // TODO Auto-generated method stub
        
    }
    
}


