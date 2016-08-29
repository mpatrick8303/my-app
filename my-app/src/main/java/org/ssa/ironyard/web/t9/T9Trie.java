package org.ssa.ironyard.web.t9;

import java.util.List;

public interface T9Trie
{
    public void addWord(String word);
        
    public List<String> suggestions(String digits);
    
    public void clear();
    
    public void contains(String word);
    
}
