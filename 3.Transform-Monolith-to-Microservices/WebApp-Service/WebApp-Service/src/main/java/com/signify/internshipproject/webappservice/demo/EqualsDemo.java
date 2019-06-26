package com.signify.internshipproject.webappservice.demo;
class Person 
{
  private String fname;
  private String lname;
  private int age;
 
  public Person(String fname, String lname, int age)
  {
    this.fname = fname;
    this.lname = lname;
    this.age = age;
  }
 
  //Overriding equals
  public boolean equals(Object obj) 
  {
    if (this == obj) return true;//If the reference to this object is the same as the reference to the argument object, return true. This test saves the work of doing all the other checks in this case.

    if (obj == null) return false;//If the argument is null, return false.

    
    if (this.getClass() != obj.getClass()) return false;//If the objects are not from the same class, return false. To determine an object's class, we use getClass(). Note that we can use == to tell us whether two objects of type Class are equal because getClass() is guaranteed to return the same reference for all objects in any given class.
    Person that = (Person) obj;//Cast the argument from Object to Person (this cast must succeed because of the previous test).
    if (this.age != that.age) return false;
    if (!this.fname.equals(that.fname)) return false;//Return false if any instance variables do not match.
    if (!this.lname.equals(that.lname)) return false;
	return true;
  }
}
 
public class EqualsDemo
{
  public static void main(String str[])
  {
    Person p1 = new Person("Anushka", "Krishan", 7);
    Person p2 = new Person("Anushka", "Krishan", 7);
    System.out.println(p1.equals(p2));
    System.out.println(p1.equals(p1));
    System.out.println(p2.equals(p1));
  }
}



