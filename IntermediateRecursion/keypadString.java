package l8;

import java.util.Scanner;

public class keypadString {
	public static String getString(char input)
	{
		switch(input)
		{
		case '2':return "abc";
					
		case '3':return "def";
					
		case '4':return "ghi";
					
		case '5':return "jkl";
		
		case '6':return "mno";
		
		case '7':return "pqrs";
		
		case '8':return "tuv";
		
		case '9':return "wxyz";
		
		default:return "";
					
					
		}
	}
//	public static void printKeySubsequence(String input)
//	{
//		if(input.length()<)
//		
//		
//		
//	}
	public static String[] keypadSubSeq(String input)
	{
		if(input.length()==0)
		{
			String output[]=new String[1];
			output[0]="";
			return output; 
		}
		String smallOutput[]=keypadSubSeq(input.substring(1));
			String smallInput=getString(input.charAt(0));
			String output[]=new String[smallInput.length()*smallOutput.length];
			for(int i=0, len=0;i<smallInput.length();i++)		//for(n-1)String
			{
				for(int j=0;j<smallOutput.length;j++,len++)		//for
				{
					output[len]=smallInput.charAt(i)+smallOutput[j];
				}
			}
			return output;
	}
	
public static void main(String[] args) {
	Scanner s=new Scanner(System.in);
	System.out.println("enter string ");
	String input=s.nextLine();
	String ans[]=keypadSubSeq(input);
	for(int i=0;i<ans.length;i++)
	{
		System.out.println(ans[i]);
	}
}
}
