package com.compile;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

import com.wordException.WordAnalysisException;

public class HandleSource {
	StringBuilder src=new StringBuilder();
	//String key[]= {"int","String","char","boolean"};
	public static void main(String[] args) throws WordAnalysisException {
		new HandleSource().fileToString("D:\\RCPworkspace\\Algorithm_001\\src\\com\\compile\\LetterAnalysisPro.java");
	}
	public void fileToString(String fileName) throws WordAnalysisException {
		BufferedReader read=null;
		String s=null;
		try {
			read=new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "UTF-8"));
			while((s=read.readLine())!=null) {
				s=s.trim();
				if(s.startsWith("//"))
					continue;
				src.append(s+System.lineSeparator());
			}
				s=src.toString();
				
//				long p1=new Date().getTime();
//				LetterAnalysis ays=new LetterAnalysis();
//				ays.handleResources(s);
//				//ays.printResult();
//				long p2=new Date().getTime();			
//				
				long l1=new Date().getTime();
				LetterAnalysisPro aysPro=new LetterAnalysisPro();
				aysPro.analysisRes(s);
				aysPro.print_list();
				long l2=new Date().getTime();
				
				System.out.println("改进版用时："+(l2-l1)+"毫秒");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
				try {
				if(read!=null)
					read.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		
	}
	//剔除空行、空格、注释和标点符号
	/*/***
	  public void handle_unUserfulMark(String res) { int len=res.length(); int i=0;
	  StringBuilder str=new StringBuilder(); while(i<len) { // while(res) } }
	 */
}
