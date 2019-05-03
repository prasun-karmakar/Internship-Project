package com.signify.internship.project.demo;

import java.util.Locale;  
import java.util.ResourceBundle;  
public class InternationalizationDemo {  
 public static void main(String[] args) {  
  
  ResourceBundle bundle = ResourceBundle.getBundle("MessageBundle", Locale.US);  
  System.out.println("Message in "+Locale.US +":"+bundle.getString("greeting"));    
  Locale.setDefault(new Locale("in", "ID"));  
  bundle = ResourceBundle.getBundle("MessageBundle");  
  System.out.println("Message in "+Locale.getDefault()+":"+bundle.getString("greeting"));  
  Locale.setDefault(new Locale("fr", "FR"));
  bundle = ResourceBundle.getBundle("MessageBundle");  
  System.out.println("Message in "+Locale.getDefault()+":"+bundle.getString("greeting"));  
  

  
 }  
}  