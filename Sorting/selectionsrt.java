package l4;
import java.util.Scanner;
public class selectionsrt {
	public static void output(int a[])
	{
		
		int len=a.length;
		for(int i=0;i<len;i++)
		{
			System.out.print(a[i]+" ");
		}
	}
	
	
	public static void selection (int a[])
	{	
		
		int len=a.length;
		for(int i=0;i<len;i++)
		{	
			int min=a[i],pos=i;
			int temp;
			
			for(int j=i;j<len;j++)
			{
				if(a[j]<min)
				{
					min=a[j];
					pos=j;
				}
			}	
			if(pos!=i)
			{
				temp=a[i];
				a[i]=a[pos];
				a[pos]=temp;
			}
		}
	}
	
	public static int binsrc(int a[],int x)
	{
		int end=a.length-1;
		int start=0;
		int answer=0;
		int mid=(end +start)/2;
		while(start<=end)
		{	
			
			if(a[mid]==x)
			{
				answer =1;
				break;
			}
			else if(a[mid]<x)
			{
				start=mid+1;
				mid=(end +start)/2;
			}
			else if(a[mid]>x)
			{
				end=mid-1;
				mid=(end +start)/2;
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("\n enter size");
		int size=s.nextInt();
		int a[]=new int[size];
		for(int i=0;i<size;i++)
		{
			a[i]=s.nextInt();
		}
		selection(a);
		output(a);
		System.out.print("enter search element");
		int search=s.nextInt();
		
		//binary search
		int k=binsrc( a,search);
		if(k==1)
		{
			System.out.println("element found");
		}
		else 
		{
			System.out.println("element not found");
		}
		
		
		
		
		
	}
}
