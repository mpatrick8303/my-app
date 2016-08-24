package com.ssa.ironyard.web.t9;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Text9Trie implements T9Trie
{
    private TextTrieDict root; 
    
    public Text9Trie()
    {
        root = new TextTrieDict();
    }
    
    public void addWord(String word)
    {
        root.addWord(word.toLowerCase());
    }
    
    public List<String> getWord(String prefix)
    {
        TextTrieDict lastNode = root; 
        
        
        for(int i = 0; i < prefix.length(); i++)
        {
            lastNode = lastNode.getNode(prefix.charAt(i));
            
            if(lastNode == null) 
                return new ArrayList<>();
        }
        
        return lastNode.getWord();
    }
    
    public List<String> suggestions(String digits)
    {
        List<String> suggestions = new ArrayList<>();
        List<String> listOfPrefixes = new ArrayList<>();
        listOfPrefixes.addAll(getPrefixes(digits));
        
        for(int i = 0; i < listOfPrefixes.size();i++)
        {
            suggestions.addAll(getWord(getPrefixes(digits).get(i)));
        }
        
        return suggestions;
    }
    public List<String> getPrefixes(String digits)
    {
               
       List<String> listOfPrefix = new ArrayList<>();
       listOfPrefix.addAll(letterCombinations(digits));
       
       
       return listOfPrefix;
    }
   
   
     
   public List<String> letterCombinations(String digits) 
   {
       HashMap<Integer, String> map = new HashMap<Integer, String>();
       map.put(2, "abc");
       map.put(3, "def");
       map.put(4, "ghi");
       map.put(5, "jkl");
       map.put(6, "mno");
       map.put(7, "pqrs");
       map.put(8, "tuv");
       map.put(9, "wxyz");
    
       ArrayList<String> result = new ArrayList<String>();
    
       if(digits == null || digits.length() == 0)
           return result;
    
       ArrayList<Character> temp = new ArrayList<Character>();
       getPrefixString(digits, temp, result, map);
       
      
       return result;
   }
    
   public void getPrefixString(String digits, ArrayList<Character> temp, ArrayList<String> result,  HashMap<Integer, String> map)
   {
       if(digits.length() == 0)
       {
           char[] arr = new char[temp.size()];
           for(int i=0; i<temp.size(); i++)
           {
               arr[i] = temp.get(i);
           }
           result.add(String.valueOf(arr));
           return;
       }
    
       Integer curr = Integer.valueOf(digits.substring(0,1));
       String letters = map.get(curr);
       for(int i=0; i<letters.length(); i++){
           temp.add(letters.charAt(i));
           getPrefixString(digits.substring(1), temp, result, map);
           temp.remove(temp.size()-1);
       }
   }
    
    public void clear()
    {
        root = new TextTrieDict();
        
    }
    
    public void contains(String word)
    {
        root.getWord().contains(word);
    }

}
