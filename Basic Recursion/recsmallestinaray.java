package l7;

import java.util.Scanner;

public class recsmallestinaray {
	public static int isSmall(int a[])
	{
		if(a.length==1)
		{
			return a[0];
		}
		int smallest;
		int b[]=new int[a.length-1];
		for(int i=1;i<a.length;i++)
		{
			b[i-1]=a[i];
		}
		smallest=isSmall(b);
		if(smallest>=a[0])
		{
			smallest=a[0];
			return smallest;
		}
		return smallest;
				
	}
public static void main(String[] args) {
	Scanner s=new Scanner(System.in);
	System.out.println("\n enter size of array");
	int size=s.nextInt();
	int arr[]=new int[size];
	for(int i=0;i<size;i++)
	{
		arr[i]=s.nextInt();
	}
	int ans=isSmall(arr);
	System.out.println("\n ans is "+ans);
}
}
