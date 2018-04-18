package l6;
import java.util.Scanner;
public class str_rev {
	public static String Rev( String input)
	{
		String output = "";
		int i=input.length()-1;
		while(i>=0)
		{
		output=output+input.charAt(i);
			i--;
		}
		return output;
	}
	public static String wordRev(String input)
	{	
		String output="";
		int strlen=input.length()-1;
		int i=0;
		while(i<=strlen)
		{
			if(input.charAt(i)==' ')
			{	String word="";
				
				int j=i-1;
				
				while(input.charAt(j)!=' ')
				{	
					word=word+input.charAt(j);
					j--;
					if(j<0)
						break;
				}
				output=output+word+ ' ';
			}
			i++;
			
		}
		int k=i-1;
		while(input.charAt(k)!=' ')
		{
			output=output+input.charAt(k);
			k--;
		}
		
		return output;
	}
	//public static void stringRev(String input)	
	{
		
	}
					
				
	public static void main(String[] args) {
		String str,output1,output2;
		Scanner s=new Scanner(System.in);
		System.out.println("enter a string");
		str=s.nextLine();
		output1=Rev(str);
		output2=wordRev(str);		
		System.out.println(output1+"\n "+output2);
	}
}
