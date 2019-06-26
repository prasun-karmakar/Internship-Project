package com.signify.internshipproject.webappservice.demo;

import java.util.Locale;  
import java.util.ResourceBundle;  
public class InternationalizationDemo {
	
 public static void main(String[] args) {  
  
  ResourceBundle bundle = ResourceBundle.getBundle("MessageBundle", Locale.US);  
  System.out.println("Message in "+Locale.US +":"+bundle.getString("Hello"));    
  //Locale.setDefault(new Locale("in", "ID")); 
  
  bundle = ResourceBundle.getBundle("MessageBundle");  
  System.out.println(bundle.getString("Hello"));  

  Locale.setDefault(new Locale("fr", "FR"));
  bundle = ResourceBundle.getBundle("MessageBundle");  
  System.out.println("Message in "+Locale.getDefault()+":"+bundle.getString("Hello"));  
  
/*Locale locale=new Locale("en","US");
ResourceBundle rb=ResourceBundle.getBundle("MessageBundle", locale);
System.out.println(rb.getString(rb.getString("Hello")));*/

  
 }  
}  

/*Locale locale = new Locale("en", "US");

ResourceBundle labels = ResourceBundle.getBundle("i18n.MyBundle", locale);

System.out.println(labels.getString("label1"));*/