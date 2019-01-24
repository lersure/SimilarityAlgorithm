package com.ncwu;

import java.util.Arrays;
import java.util.Stack;

import org.junit.jupiter.api.Test;

public class MaxCommmonLCS {
	int flag = 0;
	int result[][] = {};
	Stack<Character> stack=new Stack<Character>();;
	@Test
	public void test() {
		String str1 = "abshnfkls";
		String str2 = "fbnfl";
		int len = maxCommonLcs(str1, str2);
		System.out.println("LCS length：" + len);
	}

	public int maxCommonLcs(String str1, String str2) {
		int i, j = 0;
		int len1 = str1.length();
		int len2 = str2.length();
		char ch1,ch2;
		if (len1 == 0 || len2 == 0)
			return 0;
		result = new int[len2+1][len1+1];
		for(i=0;i<=str1.length();i++)
			result[0][i]=0;
		for(i=1;i<=str2.length();i++)
			result[j][0]=0;
		// 开始从第二行开始填充，从左至右，从上到下
		for (i = 1; i <=len2; i++) {
			ch2=str2.charAt(i-1);
			for (j = 1; j <= len1; j++) {
				if(ch2==str1.charAt(j-1))
					result[i][j]=result[i-1][j-1]+1;
				else
					result[i][j]=result[i - 1][j] > result[i][j - 1] ? result[i - 1][j] : result[i][j - 1];
			}
				
				/*if (ch) {
					if(i-1<0||j-1<0)
						result[i][j] = 0 + 1;
					else
						result[i][j]=result[i-1][j-1]+1;
					if(flag==0) {
					stack.add(ch1[j]);
					flag=1;
					}
				}
				else {
					if(i==0&&j!=0) 
						result[i][j] =  result[0][j-1] > 0 ? result[0][j-1] : 0;
					else if(j==0&&i!=0)
						result[i][j] =  result[i-1][0] > 0 ? result[i-1][0] : 0;
					else if(i!=0&&j!=0)
						result[i][j] = result[i - 1][j] > result[i][j - 1] ? result[i - 1][j] : result[i][j - 1];
					else
						result[i][j]=0;
				}*/
		}
		// 遍历result
		System.out.print("\t");
		for (char temp : str1.toCharArray())
			System.out.print(temp + "\t");
		System.out.println();
		for (i = 1; i <=len2; i++) {
				System.out.print(str2.charAt(i-1) + "\t");
			for (j = 1; j <=len1; j++)
				System.out.print(result[i][j] + "\t");
			System.out.println();
		}
		//开始从后向前搜索LCS路径
		System.out.print("LCS路径：");
		stack.forEach((s)->System.out.print(s+"\t"));
		return result[i-1][j-1];
	}
	public void searchPath(int result[][],char ch1[],char ch2[]) {
		int row=result.length;
		int col=result[0].length;
		
	}

}
