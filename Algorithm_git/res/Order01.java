package com.ncwu;
import java.util.List;
public class Order01{
	/**
	*ע��һ
	*/
	/*
	*ע�Ͷ�
	*/
	//ע����
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
		system.out.println(name+":��Ҫ����");	
	}
	
	//method2
	public void speak(int age){
		system.out.println("������"+age+"��");
	}

}