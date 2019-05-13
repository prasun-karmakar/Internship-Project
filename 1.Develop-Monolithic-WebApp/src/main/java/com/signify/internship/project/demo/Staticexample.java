package com.signify.internship.project.demo;
  
	public class Staticexample implements MyInterface{ 
		
	    public void existingMethod(String str){           
	        System.out.println("String is: "+str);  
	    }  
	    public static void main(String[] args) {  
	    	Staticexample obj = new Staticexample();
	    	
	  
	        obj.newMethod();     
	        
	        MyInterface.anotherNewMethod();
	       
	        obj.existingMethod("Java 8 is easy to learn"); 
	        
	  
	    }  
	}


