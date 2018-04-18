package l22;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
public class LongestConsecutiveSubstring {

	public static ArrayList<Integer> longestSubsequence(int[] arr){
		// Write your code here
		HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
		ArrayList<Integer> ans=new ArrayList<Integer>();
		int i=0;
		while(i<arr.length)
		{
		    Integer I=new Integer(arr[i]);
		    if(map.get(I)==null)
		        map.put(I,1);
		    if(map.get(I)>=1){
		        Integer L=new Integer(map.get(I)+1);
		         map.put(I,L);
		    }
		       
		    i++;
		}
		int max=Integer.MIN_VALUE;
		int j=0;
		while(j<arr.length)
		{
		    ArrayList<Integer> temp=new ArrayList<Integer>();
		    int k=arr[j];
		    int l=0;
		    while(map.get(k)!=null)
		    {
		        
		        temp.add(k);
		        k++;
		        l++;
		        
		    }
		    if(l>max){
		        max=l;
		        ans=temp;
		    } 
		    System.out.println(l);
		    j++;
		}
		return ans;

	}
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int size=s.nextInt();
		int arr[]=new int[size];
		for(int i=0;i<size;i++)
		{
			arr[i]=s.nextInt();
		}
		ArrayList<Integer> array=longestSubsequence(arr);
		for(int i=0;i<array.size();i++)
		{
			System.out.println(array.get(i));
			
		}
	}
}


