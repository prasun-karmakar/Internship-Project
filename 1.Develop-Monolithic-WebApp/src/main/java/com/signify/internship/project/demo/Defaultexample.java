package com.signify.internship.project.demo;
interface MyInterface{  
    
    default void newMethod(){  
        System.out.println("Newly added default method");  
    }  
    static void anotherNewMethod(){
    	System.out.println("Newly added static method");
    }
    
    void existingMethod(String str);  
}  
public class Defaultexample implements MyInterface{ 
	    public void existingMethod(String str){           
        System.out.println("String is: "+str);  
    }  
    public static void main(String[] args) {  
    	Defaultexample obj = new Defaultexample();
    	
    	
        obj.newMethod();     
        obj.existingMethod("Java 8 is easy to learn"); 
  
    }  
}



