package l20;

import java.util.PriorityQueue;
import java.util.Scanner;





public class SortArrayN {
	public static int[] kmaximum(int a[],int k)
	{
		PriorityQueue<Integer> minHeap=new PriorityQueue<Integer>();
		int ans[]=new int[k];
		for(int i=0;i<k;i++)
		{
			minHeap.add(a[i]);
		}
		for(int j=k;j<a.length;j++)
		{
			if(minHeap.peek()<a[j])
			{
				int a1=minHeap.remove();
				minHeap.add(a[j]);
			}
		}
		for(int i=0;i<k;i++)
		{
			ans[i]=minHeap.remove();
		}
		return ans;
	}
//	public static void main(String[] args) {
//		Scanner s=new Scanner(System.in);
//		int size=s.nextInt();
//		int arr[]=new int[size];
//		for (int i = 0; i < arr.length; i++) {
//			arr[i]=s.nextInt();
//			
//		}
//		int max=
//	}
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
//		System.out.println("enter size");
//		int size=s.nextInt();
		int k=s.nextInt();
		int a[]={8,10,12,12,9,3,5};
		a=kmaximum(a, k);
		for(int element:a)
		{
			System.out.println(element);
		}
		
//		for(int i=0;i<)
	}
}
