package com.qa.pages;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry; 
public class Duplicate1 { 
    public HashMap<String, String>  stringCount(String inputString,String quantity) 
    { 
        HashMap<String, String> charCountMap  = new HashMap<String, String>(); 
        HashMap<String, String> charCountMap1  = new HashMap<String, String>(); 

		String[] strArray=inputString.split(",");
		String[] strq="2,2,2,2".split(",");
		List<String> finalValues= new ArrayList<String>();
       finalValues=Arrays.asList(strq);
       int i=0;
		for (String str : strArray) 
		{ 
			
            if (charCountMap.containsKey(str)) 
            {
                charCountMap.put(str, finalValues.get(i)); 
                i++;
            } 
            else 
            { 
                charCountMap.put(str, quantity); 
                i++;
            } 
        } 
		  
        return charCountMap;
    } 

} 