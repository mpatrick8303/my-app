package com.ssa.ironyard.web.t9;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TrieLoadingServiceTest
{
    @Autowired
    T9Trie trie;
    
    
    Logger LOGGER = LogManager.getLogger(TrieLoadingServiceTest.class);
    @Test
    public void uhoh() throws URISyntaxException, IOException
    {
        FileFactory ff = new FileFactory()
        {

            @Override
            public File getInstance()
            {
                return new File("C:/javaproject/maven/my-app/src/main/resources");
                        
            }
            
        };
        new TrieLoadingService(ff, trie);
       
    }
    
    @Test
    public void webapp() throws Exception
    {
        new TrieLoadingService(new WebFileFactory("corncob_loweercase.txt"), trie);
    }

}
