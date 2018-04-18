package l8;

import java.util.Scanner;

public class recbinSearch {
	public static int binarySearch(int input[],int element,int start,int end)
	{
		int mid=(start+end)/2;
		int ans=-1;
		if(start>end)
		{	
			return ans;
		}
		
		if(input[mid]==element)
		{
			ans=mid;
			return ans;
			
		}
		else if(input[mid]>element)
		{
			end=mid-1;
			
		}
		else if(input[mid]<element)
		{
			start=mid+1;
			
		}
		ans=binarySearch(input, element, start, end);
		return ans;
		}
	
public static void main(String[] args) {
	System.out.println("\n enter array size");
	Scanner s=new Scanner(System.in);
	int size=s.nextInt();
	int input[]=new int[size];
	for(int i=0;i<size;i++)
	{
		input[i]=s.nextInt();
	}
	System.out.println("\n enter element to be searched");
	int element=s.nextInt();
	int ans=binarySearch(input, element, 0, size);
	System.out.println("\n element found at "+ans);
}
}
