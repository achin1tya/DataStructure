package l21;

import java.util.Scanner;

public class maxSumNoconsecutive {
	public static int bestSumHelper(int []input,int[] arr,int startIndex)
	{
		if(startIndex>=input.length)
		{
			return 0;
		}
		if(arr[startIndex]>0)
		{
			 return arr[startIndex];
		}
		int answer1=input[startIndex]+bestSumHelper(input, arr, startIndex+2);
		int answer2=bestSumHelper(input, arr, startIndex+1);
		arr[startIndex]=Math.max(answer1, answer2);
		return Math.max(answer1, answer2);
	}
public static int bestSum(int [] input)
{
	int arr[]=new int[input.length+1];
	int answer=bestSumHelper(input,arr,0);
	return answer;
	
}
public static void main(String[] args) {
	System.out.println("\n enter size of input");
	Scanner s=new Scanner(System.in);
	int size=s.nextInt();
	int[] input=new int[size];
	for(int i=0;i<size;i++)
	{
		input[i]=s.nextInt();
	}
	int answer=bestSum(input);
	System.out.println("ans is"+answer);
}
}
