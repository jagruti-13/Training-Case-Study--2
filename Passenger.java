package com.unext.model;

public class Passenger  implements Comparable<Passenger>{
	private String name;
	private String gender;
	private int age;
	public Passenger(String name, String gender2, int age){
		super();
		this.name = name;
		this.gender = gender2;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public int compareTo(Passenger o) {
		// TODO Auto-generated method stub
		return this.getAge()-o.getAge();
	}
}
