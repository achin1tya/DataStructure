package l22;
import java.util.HashMap;
import java.util.Scanner;
public class PairDiffK {
	public static void findPairsDifferenceK(int[] input, int k){
		 
		// Write your code here
		HashMap<Integer,Integer> map=new HashMap();
		for(int i=0;i<input.length;i++)
		{
		   if(map.get(input[i])==null)
		        map.put(input[i],1);
		    else
		    {
		        Integer I=new Integer(map.get(input[i])+1);
		        Integer l=new Integer(input[i]);
		        map.put(l,I);
		    }      
		}
	    
	    for(int i=0;i<input.length;i++)
	    {
	    		Integer I=new Integer(input[i]);
	    		Integer K=new Integer(k);
	    		if(map.containsKey(I))
	    		{
	    			if(map.get(I-K)!=null)
	    			{
	    				Integer L=map.get(I-K);
	    				while((L--)>0){
	    				if(I>=(I-K))
	    					System.out.println((I-K)+" "+I);
	    				else
	    					System.out.println(I+" "+(I-K));
	    				
	    				}
	    			}
	    		}
	    }
	    

	}
	public static void main(String[] args) {
		System.out.println("\n enter input");
		Scanner s=new Scanner(System.in);
		System.out.println("entere size");
		int size=s.nextInt();
		int input[]=new int[size];
		for(int i=0;i<size;i++)
		{
			input[i]=s.nextInt();
		}
		System.out.println(" enter k");
		int k=s.nextInt();
		findPairsDifferenceK(input, k);
	}
}
