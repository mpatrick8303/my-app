package org.ssa.ironyard.web.t9;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TrieLoadingService 
{
    static final Logger LOGGER = LogManager.getLogger(TrieLoadingService.class);
    
    @Autowired
    T9Trie trie;
    
 
    
    public TrieLoadingService(FileFactory ff, T9Trie trie) throws URISyntaxException, IOException
    {
        this.trie = trie;
        
//        URL resource = getClass().getClassLoader().getResource(fileName);
//        LOGGER.debug(resource);
//        File file = new File(resource.toURI());
        
        File file = ff.getInstance();//grabs the file 
        LOGGER.debug("file {}, exists?{}", file, file.exists());//logs if it could find the file or not
        addWord(file);
    }
  
    public void addWord(File configFile) throws IOException
    {
        BufferedReader reader = null;
        try {
            reader = Files.newBufferedReader(Paths.get(configFile.getAbsolutePath()),Charset.defaultCharset());
            String line;
            while (null != (line = reader.readLine())) 
            { 
                
                trie.addWord(line.trim());
            }
        } catch (IOException iex) {
            LOGGER.debug(iex);
        } finally {
            reader.close();
        }
 
    }
    
   
    


}
