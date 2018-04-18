package l8;

import java.util.Scanner;

public class recMergeSort {
	

		public static void mergeSort(int[] input){
			// Write your code here
			int len=input.length;
			
			if(input.length==1||input.length==0)    //base case
			{
			   return;
			}
			
			
			int i=-1;               //variable to calculate size of small array
			if(len%2==0)
			{
			    i=len/2;
			}
			else 
			    i=(len+1)/2;
			
			int [] leftArr=new int[i];          //leftt array size 
			int[]  rightArr=new int[len-i];     //right array size
			
			for(int k=0;k<i;k++)
			{
			    leftArr[k]=input[k];
			}
			mergeSort(leftArr);     //solve left array
			
			for(int k=0;k<len-i;k++)
			{
			    rightArr[k]=input[k+len-i];
			}
			mergeSort(rightArr); //solve right array
			for(int k=0;k<i;k++)
			{
			    System.out.print("###"+" "+leftArr[k]);
			}
			System.out.println();
			for(int k=0;k<len-i;k++)
			{
			    System.out.print("%%%"+" "+rightArr[k]);
			}
			
			int left=0,right=0,origional=0;             //merge sort start
			while(left<leftArr.length&&right<rightArr.length)
			{
			    if(leftArr[left]<=rightArr[right])
			    {
			        input[origional]=leftArr[left];
			        left++;
			        origional++;
			    }
			    else if(leftArr[left]>rightArr[right])
			    {
			         input[origional]=rightArr[right];
			         right++;
			         origional++;
			    }
			}
			while(left<leftArr.length)
			{
			    input[origional]=leftArr[left];
			    origional++;
			    left++;
			}
			while(right<rightArr.length)
			{
			    input[origional]=rightArr[right];
			    origional++;
			    right++;
			}                               //merge sort end
			
			
		}
				
	

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("\n enter size");
		int size=s.nextInt();
		int input[]=new int[size];
		for(int i=0;i<size;i++)
		{
			input[i]=s.nextInt();
		}
		System.out.println("after merge sort");
		mergeSort(input);
		for(int i=0;i<size;i++)
		{
			System.out.println(input[i]);
		}
		
		
	}
}
	

