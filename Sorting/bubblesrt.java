package l4;

import java.util.Scanner;

public class bubblesrt {
	public static void bubbleSort(int arr[])
	{	
		int len=arr.length;
		int temp;
		for(int i=0;i<len;i++)
		{
			for(int j=0;j<(len-1)-i;j++)
			{
				if(arr[j]<arr[j+1])
				{
					temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		}
	}
	public static void main(String[] args) {
		
		Scanner s=new Scanner(System.in);
		System.out.println("enter array  size");
		int size=s.nextInt();
		int arr[]=new int[size];
		for(int i=0;i<size;i++)
		{
			arr[i]=s.nextInt();
		}
		bubbleSort(arr);
		for(int i=0;i<size;i++)
		{
			System.out.println(arr[i]+" ");
		}
		
	}
}
