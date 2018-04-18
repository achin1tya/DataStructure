package l7;
import java.util.Scanner;


public class rec7function {
	public static int firstIndexOf7(int a[])
	{
		int ans=-1;
		if(a.length==0)
		{
			return ans;
		}
		else if(a[0]==7)
		{
			ans=0;
			return ans;
		}
		int arr[]=new int[a.length-1];
		ans=firstIndexOf7(arr);
		return ans;
		
	}
	public static boolean check7(int a[])
	{	
		boolean ans;
		if(a.length==0)
		{
			ans=false;
			return ans;
		}
		else if(a[0]==7)
		{
			ans=true;
			return ans;
		}
		int arr[]=new int[a.length-1];
		for(int i=1;i<a.length;i++)
		{
			arr[i-1]=a[i];
		}
		ans=check7(arr);
		return ans;
			
		
	}
public static void main(String[] args) {
	Scanner s=new Scanner(System.in);
	System.out.println("enter array size");
	int size=s.nextInt();
	int arr[]=new int[size];
	for(int i=0;i<size;i++)
	{
		arr[i]=s.nextInt();
	}
	boolean ans=check7(arr);
	int ansFirstIndex=firstIndexOf7(arr);
	System.out.println("answer is"+ans+"\n"+ansFirstIndex);
	
}
}
