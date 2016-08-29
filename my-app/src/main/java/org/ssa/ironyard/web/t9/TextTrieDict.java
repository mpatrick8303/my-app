package org.ssa.ironyard.web.t9;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class TextTrieDict
{
    private TextTrieDict parent;
    private TextTrieDict[] children;
    private boolean anyChildren; 
    private boolean lastChar; 
    private char character; 
    
    public TextTrieDict()
    {
        children = new TextTrieDict[26]; 
        anyChildren = true; 
        lastChar = false;
    }
    
    public TextTrieDict(char character)
    {
        this();
        this.character = character; 
    }
 
    public void addWord(String word)
    {
        anyChildren = false;
        int charPos = word.charAt(0) - 'a';

        
        if(children[charPos] == null)
        {
            children[charPos] = new TextTrieDict(word.charAt(0));
            children[charPos].parent = this;
        }
        
        if(word.length() > 1)
        {
            children[charPos].addWord(word.substring(1));
        }
        else
        {
            children[charPos].lastChar = true;
        }
        
        
    }
    
    
    public TextTrieDict getNode(char c)
    {
        return children[c - 'a'];
    }
    
    public List<String> getWord()
    {
        List<String> list = new ArrayList<>(); 
        
        if(lastChar)
        {
            list.add(toString());
        }
        
        if(!anyChildren)
        {
            for(int i = 0; i < children.length; i++)
            {
                if(children[i] != null)
                {
                    list.addAll(children[i].getWord());
                }
            }
        }
        return list;
    }

    public String toString()
    {
        if(parent == null)
        {
            return "";
        }
        else
        {
            return parent.toString() + new String(new char[] {character});
        }
        
    }
    
}
