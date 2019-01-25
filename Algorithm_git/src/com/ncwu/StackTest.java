package com.ncwu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.regex.Pattern;

import org.junit.Test;

public class StackTest {
	@Test
	public void test_stack() {
//		Stack<Integer> stack=new Stack<Integer>();
//		stack.add(1);
//		stack.add(2);
//		stack.add(3);
//		stack.forEach((s)->System.out.println(s));
//		char c=39;
//		String[] key={"String","boolean","char","class","do","double","else","extends","float"
//				,"if","implements","int","main","new","package","public","return","static","super","this",
//				"void","while"};
//		int a=Arrays.binarySearch(key, "boolean");
		//String c="ac*ok";
		String r1="^[-+]?\\d+\\.\\d*$|^[-+]?\\d*\\.\\d+$";//匹配带小数点的小数
		String r2="^\\d+?";
		String r3="^([_$a-zA-Z][_$a-zA-Z0-9]*\\.?)+?[_$a-zA-Z][_$a-zA-Z0-9]*$";//匹配导入的某个包
		String r4="[\\s\\S]*?/\\*+?[\\s\\S]*";//用来匹配以/*开头的注释
		String r5="[\\s\\S]*//[\\s\\S]*";//用来匹配以//开始的注释
		String pattern="package com.ncwu;import //java.util.List;public class Order01{/*注释一/注释二  asdfasdf*注释三double";
//		double d=.0;
		
//		System.out.println("a:"+pattern.matches(r5));
		//System.out.print("asdf"+System.lineSeparator()+"45453");
		//System.out.print(System.lineSeparator().toString());
		System.out.print("\r\n");
		
//			System.out.print("String："+new String("com.ncwu.java").split("\\.")[0]);
	}
	
}
