package com.compile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.wordException.WordAnalysisException;

/*
 * 只进行词法分析，语法分析和语义分析在后面进行
 * 
 * 标识符统一用a代替，常数统一用b代替，方法名字统一用c代替
 */

public class LetterAnalysisPro {
	List<Object> result=new ArrayList<Object>();
	private final static String s_char="CHAR";
	private final static String s_String="STRING";
	private final static String s_int="INT";
	private final static String s_double="DOUBLE";
	//关键字表
	String[] key={"boolean","char","class","do","double","else","extends","float"
			,"if","implements","import","int","main","new","package","public","return","static","super","this",
			"void","while"};
	//如果第一位字符为空格或者制表位或者.
	public static boolean isNotUserfulCh(char ch) {
		if(ch==' '||ch=='\t'||ch=='\r'||ch=='\n')
			return true;
		return false;
	}
	//判断是否是运算符
	public boolean isOperator(char c){
		if(c=='+'||c=='-'||c=='*'||c=='/'||c=='|'||c=='&'||c=='!'||c=='>'||c=='<'||c=='='||c=='%')
			return true;
		return false;
	}
	//判断是否是字符
	public static boolean isChar(char c) {
		if(c>='A'&&c<='Z'||c>='a'&&c<='z'||c>='0'&&c<='9'||c=='$'||c=='_')
			return true;
		return false;
	}
	//判断是否是分隔符
	public static boolean isBound(char c) {
		if(c==','||c==';'||c=='"'||c==39||c=='('||c==')'||c=='['||c==']'||c=='{'||c=='}')
			return true;
		return false;
	}
	
	//判断是否是标识符,并返回其位置
		public static boolean isIdtifier(String str){
			String regrex="^[a-zA-Z$_][a-zA-Z$_0-9]{0,119}";//匹配标识符的匹配串
			if(str.matches(regrex))//满足标识符的规则且不是关键字
				return true;
			else
				return false;
		}
		
		
	public void analysisRes(String res) throws WordAnalysisException {
		int i,j=0;
		int len=res.length();
		char ch,temp_ch;
		int record=0;
		String sepResult = null;
		for(i=0;i<len;i=j+1){
			ch=res.charAt(i);
			j=i;record=0;
			//如果第一位字符为空格或者制表位
			if(isNotUserfulCh(ch)) 
				continue;
			while(j<len) {
				ch=res.charAt(j);
				if(isChar(ch)) {
					j++;
					continue;
				}
				if(isBound(ch)) {
					record=1;
					break;
				}
				if(isOperator(ch)) {
					record=2;
					break;
				}
				if(isNotUserfulCh(ch)) {
					record=3;
					break;
				}
				//如果一个字符后面有点号则可能是导入某个包，也可能是一个小数
				//因此分两种情况讨论，但是这里只分析了123.456这种只有一个点号这种情况
				if(ch=='.') {
					j++;
					continue;
				}
				break;
			}
			sepResult=res.substring(i,j);
			//判断是否是关键字
			if(Arrays.binarySearch(key, sepResult)>=0) {
				result.add(sepResult);
				continue;
			}
			//判断是否是标识符
			else if(isIdtifier(sepResult))
				result.add(sepResult);
			
			else if(sepResult.matches("^([_$a-zA-Z][_$a-zA-Z0-9]*\\.?)+?[_$a-zA-Z][_$a-zA-Z0-9]*$")) {
					String temp_str[]=sepResult.split("\\.");
					int temp_len=0;
					while(temp_len<temp_str.length)
						result.add(temp_str[temp_len++]);
				}
				//可能是个小数
			else if(sepResult.matches("^[-+]?\\d+\\.\\d*$|^[-+]?\\d*\\.\\d+$"))
					result.add(s_double);//sepResult此时是个小数
			else if(sepResult.matches("^\\d+?"))
					result.add(s_int);
			else if(!sepResult.equals(""))
					throw new WordAnalysisException("标识符输入错误");
	
			//判断字符ch是什么类型的字符,先判断是否是单目运算符,根据前面的record来判断
			//if(record==1)判断是双引号还是单引号
			if(record==1) {//分隔符
				if(ch==39) {//如果是单引号，引用的是字符
					result.add((char)39);
					if(j++<len) {//j++指向下一个单引号
						result.add(s_char);
						result.add((char)39);
					}
					j++;
				}
				else if(ch=='"') {//如果是双引号，引用的是字符串
					result.add('"');
					ch=res.charAt(++j);
					while(j<len&&ch!='"')
						ch=res.charAt(++j);
					if(j<len) {
						result.add(s_String);
						result.add('"');
					}
				}
				else
					result.add(ch);
				}
			/*
			 * 将单目运算符统一换成普通表达式。
			 */
			
			else if(record==2) {
				temp_ch=res.charAt(++j);
				String s=Character.toString(ch)+Character.toString(temp_ch);
				if(s.equals("//")) {
					while(temp_ch!='\n'&&j<len) {
						temp_ch=res.charAt(j);
						j++;
					}
					j--;
					continue;
				}
				if(s.equals("/*")) {
					j+=2;
					while(temp_ch!='/'&&j<len) {
						temp_ch=res.charAt(j);
						j++;
					}
					if(j<len)
						if(res.charAt(j-2)=='*')
							continue;
						else
							throw new WordAnalysisException("注解错误");
				}
				if(isOperator(temp_ch)) //这里可以做改进
						result.add(Character.toString(ch)+Character.toString(temp_ch));
				else {
						result.add(Character.toString(ch));
						j--;
				}
			}
		}
	}
	
	
	//遍历结果集
	public void print_list() {
		int num=0;
		for(Object obj:result) {
			System.out.print(obj+"\t");
			if((++num)%5==0)
				System.out.println();
		}
	}
	
	//单目运算符全部都能正确判断，具体执行过程待定.......
	public void singleOpToDoubleOp() {

	}
	
}
