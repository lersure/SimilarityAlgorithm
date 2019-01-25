package com.ncwu;
import java.util.List;
public class Order01{
	/**
	*注释一
	*/
	/*
	*注释二
	*/
	//注释三
	double num=123.456;
	String name;
	char ch='a';
	int i=123;
	
	List<String> list=new ArrayList<String>();
	public Order01(String name,int age){
		this.name=name;
		this.age=age;
	}
	//method1
	public void speak(String name){
		system.out.println(name+":我要发言");	
	}
	
	//method2
	public void speak(int age){
		system.out.println("我现在"+age+"岁");
	}

}