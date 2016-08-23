package com.ssa.ironyard.web.t9;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Component
public class TrieLoadingService 
{
    static final Logger LOGGER = LogManager.getLogger(TrieLoadingService.class);
    
    @Autowired
    Text9Trie trie;
    
 
    
    public TrieLoadingService(Text9Trie trie) throws URISyntaxException, IOException
    {
        this.trie = trie;
        URL resource = getClass().getClassLoader().getResource("corncob_lowercase.txt");
        LOGGER.debug(resource);
        File file = new File(resource.toURI());
        LOGGER.debug("file {}, exists?{}", file, file.exists());
        addWord(file);
    }
  
    public void addWord(File configFile) throws IOException
    {
        BufferedReader reader = null;//creating a buffered reader
        try {
            reader = Files.newBufferedReader(Paths.get(configFile.getAbsolutePath()),Charset.defaultCharset());
            String line;
            while (null != (line = reader.readLine())) 
            { 
                
                trie.addWord(line.trim());
            }
        } catch (IOException iex) {
            LOGGER.debug(iex);
            //System.err.println(iex);
        } finally {
            reader.close();
        }
 
    }
    
   
    
// public List<String> suggestions(String digits)
//    {
//       
//        return  trie.suggestions(digits);
//    }

}
