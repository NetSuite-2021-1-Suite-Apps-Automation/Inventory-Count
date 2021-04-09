package com.qa.config;

import java.util.ArrayList;
import java.util.Arrays;

import io.cucumber.java.sl.In;

public class fc {
	
	     public String[] lotnr_conslidate(String lotnrs,String quantity,int length) {  
	        String str[] = lotnrs.split(",");  
	        String q[]=quantity.split(",");
	        String q1[]=new String[length];
	        for(int i=0;i<str.length;i++)
	        {
	        	System.out.println(str[i]);
	        }
	        int k=0;
	        int[] freq = new int[str.length];  
	        int i, j;	
	        int countt=0;
	        boolean found=false;
	        for(i = 0; i <str.length; i++) {  
	        	countt=0;
	        	found=false;
	            freq[i] = 1;  
            	if(!str[i].equals("0"))
	            for(j = i+1; j <str.length; j++) {  
	                if(str[i].equals(str[j])) { 
	                	if(countt==0)
	                	{
	                	q1[k]=String.valueOf(Integer.parseInt(q[i])+Integer.parseInt(q[j]));
	                	countt=countt+1;
	                	}
	                	else
	                	{
	                		q1[k]=String.valueOf(Integer.parseInt(q1[k])+Integer.parseInt(q[j]));
	                	}
	                	System.out.println("step of: "+q[k]);
	                    str[j] = "0";  
	                    found=true;
	                }    
	            } 
            	if(!str[i].equals("0"))
	            if(!found)
	            {
	            	q1[k]=q[i];
	            }
            	if(!str[i].equals("0"))
            	{	
            	k=k+1;
            	}

	        }  
	       
	        System.out.println("Characters and their corresponding frequencies");  
	        int l=0;
	        int m=0;
	        String final_array[]=new String[length];
	        for(i = 0; i <freq.length; i++) {  
	            if(!str[i].equals("") && !str[i].equals("0"))  
	            {
	            	final_array[m]=str[i];
	            	m++;
	            	System.out.println(str[i]+" is "+q1[l]);
	            	l++;
	            }
	       
	            
	           
	        }  
//	        String netsuite_serials[]="lottestt1,lottest2,lottest3,lottest4".split(",");
//	        String netsuite_q[]="2,4,3,2".split(",");
//	        int count=0;
//	        for(i = 0; i <netsuite_serials.length; i++) {  
//	            for(j = 0; j <netsuite_serials.length; j++) {  
//	                if(netsuite_serials[i].equals(final_array[j])) { 
//	                	if(netsuite_q[i].equals(q1[j]))
//	                	{
//	                		count=count+1;
//	                		System.out.println(count);
//	                		
//	                	}
//	                }    
//	            } 
//	        }
//            	if(count==netsuite_serials.length)
//            	{
//            		System.out.println("success");
//           
		     return final_array;

	    }  
	     
	     }



