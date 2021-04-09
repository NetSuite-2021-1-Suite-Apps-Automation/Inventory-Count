package com.qa.pages;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry; 
public class Duplicate { 
    public String[] characterCount(String inputString) 
    { 
  
        HashMap<String, Integer> charCountMap=new HashMap<String, Integer>(); 
		String[] strArray=inputString.split(",");
		ArrayList<String> finalValues= new ArrayList<String>();
		String [] final_array = null;
        for (String str : strArray) { 
            if (charCountMap.containsKey(str)) { 
  
                charCountMap.put(str, charCountMap.get(str) + 1); 
            } 
            else { 
  
                charCountMap.put(str, 1); 
            } 
        } 
        for (Entry<String, Integer> entry : charCountMap.entrySet()) { 
            finalValues.add(entry.getKey()) ;
            
               } 
       
        String[] item = finalValues.toArray(new String[finalValues.size()]);  

        return item;
    } 
} 