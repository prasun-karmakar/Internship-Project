package com.signify.internshipproject.webappservice.demo;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee e = new Employee(10, "sakshi");
		System.out.println("Name: " + e.getName() + ", Age: " + e.getAge());
		
	}

}

final class Employee {
	   final int age;
	   final String name;

	   Employee(int age, String name){
	      this.age = age;
	      this.name = name;
	   }

	   public int getAge(){
	      return age;
	   }
	   public String getName(){ 
	      return name;
	   }
}



