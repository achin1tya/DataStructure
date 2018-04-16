package l4;
import java.util.Scanner;
public class srt01 {
	public static void bubbleSort(int[] arr){
		//write your code here
		int len=arr.length,temp;
		for(int i=0;i<len-1;i++)
		{
		    for(int j=0;j<(len-1)-i;j++)
		    {
		        if(arr[j+1]<arr[j])
		        {
		            temp=arr[j];
		            arr[j]=arr[j+1];
		            arr[j+1]=arr[j];
		            System.out.print(arr[j]+" ");
		            System.out.println(temp);
		        }
		    }
		}
	}		
		public static void main(String  args[])
		{
			System.out.println("enter array");
			Scanner s=new Scanner(System.in);
			System.out.println("enter its size");
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
