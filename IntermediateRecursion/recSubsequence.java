package l8;
import java.util.Scanner;
public class recSubsequence { 
	public static void printSubsequence(String input,String outputSofar)
	{
		if(input.length()==0)
		{
			System.out.println(outputSofar);
			return ;
		}
		printSubsequence(input.substring(1),outputSofar);
		printSubsequence(input.substring(1),outputSofar+input.charAt(0));
	}
//	public static String[] subsequence(String input )
//	{
//		int len=input.length();
//		String output[]=new String[(int)(Math.pow(2,len))];
//		if(input.length()==0)
//		{
//			output[0]="";
//			return output;
//		}
//		output=subsequence(input.substring(1));
//		for(int i=(int)Math.pow(2,len-1),j=1;i<Math.pow(2, len);i++,j++)
//		{
//			output[i]=input.charAt(0)+output[j];
//		}
//		return output;
//	
//	}
public static void main(String[] args) {
	Scanner s=new Scanner(System.in);
	String input=s.next();
	printSubsequence(input,"" );
	
}
}
