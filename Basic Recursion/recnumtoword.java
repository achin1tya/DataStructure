package l7;

import java.util.Scanner;

public class recnumtoword {
	public static String text(int n)
	{
		String output="";
		switch(n)
		{
			case 0:
					output="zero";
					break;
			case 1:
					output="one";
					break;
			case 2:	
					output="two";
					break;
			case 3:	
					output="three";
					break;
			case 4:	
					output="four";
					break;
			case 5:	
					output="five";
					break;
			case 6:	
					output="six";
					break;
			case 7:	
					output="seven";
					break;
			case 8:	
					output="eight";
					break;
			case 9:	
					output="nine";
					break;
			default:
					break;
				
		}
		return output;
	}
	public static String word(int num,String ans)
	{
		String a=ans;
		int rem;
		if(num<10)
		{
			 rem=num;
			a=a+text(rem);
			return a;
		}
		rem=num%10;
		
		int nextAns=num/10;
		a=a+word(nextAns,a)+" ";
		a=a+text(rem)+" ";
		return a;
		
		
	}
public static void main(String[] args) {
	Scanner s =new Scanner(System.in);
	System.out.println("enter number");
	int num=s.nextInt();
	String ans=word(num,"");
	System.out.println(ans);
}
}
