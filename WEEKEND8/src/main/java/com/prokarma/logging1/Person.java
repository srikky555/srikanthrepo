package com.prokarma.logging1;


import java.io.Serializable;

public class Person implements Serializable  {

	private static final long serialVersionUID = 1L;
	int age ;
    String name;
	public Person(String name, int age) {
  this.name=name;
  
  this.age=age;
	}
public int getAge() {
	return age;	}
public String getName() {
	return name;
}
@Override
public String toString() {
	return "Person [age=" + age + ", name=" + name + "]";
}


}
