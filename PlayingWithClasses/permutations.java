package l10;

import java.util.Scanner;

public class permutations {
	public static String swap(String input,int a,int b)
	{
		String ans="";
		int less=Math.min(a, b);
		for(int i=0;i<less;i++)
		{
			ans=ans+input.charAt(i);
		}
		if(less==a)
		{
			ans=ans+input.charAt(b);
			for(int i=less+1;i<b;i++)
			{
				ans=ans+input.charAt(i);
			}
			ans=ans+input.charAt(a);
			for(int i=b+1;i<input.length();i++)
			{
				ans=ans+input.charAt(i);
			}
		}
		else if(less==b)
		{
			ans=ans+input.charAt(a);
			for(int i=less+1;i<a;i++)
			{
				ans=ans+input.charAt(i);
			}
			ans=ans+input.charAt(b);
			for(int i=a+1;i<input.length();i++)
			{
				ans=ans+input.charAt(i);
			}
		}
		System.out.println("###"+ans);
		return ans;
		
	}
	public static void printPermutatiion(String input,int index)
	{
		
		if(index==input.length())
		{
			System.out.println(input);
			return ;
		}
		for(int i=index+1;i<input.length();i++)
		{
			String ans=swap(input,index,i);
			printPermutatiion(ans, index+1);
		}
		
		
	}
	public static void main(String[] args) {
		System.out.println("\n enter string ");
		Scanner s=new Scanner(System.in);
		String input=s.nextLine();
		for(int i=1;i<input.length();i++)
		{
			String ans=swap(input,0,i);
			printPermutatiion(ans, 1);
		}
		
		
	}
}
