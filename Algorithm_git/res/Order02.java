package com.ncwu;
public class Order02{
	String name;
	int age;
	public Order02(String name,int age){
		this.name=name;
		this.age=age;
	}
	//method2
	public void speak(int age){
		system.out.println("我现在"+age+"岁");
	}
	
	public static void main(String args[]){
		
		
	}
	
	//method1
	public void speak(String name){
		system.out.println(name+":我要发言");	
	}
	
	
}