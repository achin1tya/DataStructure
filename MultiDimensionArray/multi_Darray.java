package l6;

import java.util.Scanner;

public class multi_Darray {
	public static int[][] takeInput()
	{	Scanner s=new Scanner(System.in);
		System.out.println("enter row and column size");
		int rows=s.nextInt();
		int col=s.nextInt();
		int a[][]=new int[rows][col];
		for(int i=0;i<rows;i++)
		{
			for(int j=0;j<col;j++)
			{
				a[j][i]=s.nextInt();
			}
		}
		return a;
	}
	public static void wave(int a[][])
	{
		int row=a.length;
		int col=a[0].length;
		for(int i=0;i<col;i++)
		{
			if(i%2==0)
			{
				for(int j=0;j<row;j++)
					System.out.println(a[i][j]);
			}
		
			else
			{
				for(int j=row-1;j>=0;j--)
					System.out.println(a[i][j]);
			}
		}
	}
	public static void spiral(int arr[][])
	{
		int row=arr.length;
		int col=arr[0].length;
		int rptr=0,cptr=0
		for(int i=0;i<row;i++)
		{
			if()
		}
	}
	public static void main(String[] args) {
	
		int[][] arr = takeInput();
		wave(arr);
}
}
