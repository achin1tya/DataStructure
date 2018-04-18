//package l17;
//import java.util.ArrayList;
//import java.util.Scanner;
//
////class pair
////{
////    int max1;
////    int max2;
////   
////    GenericTreeNode<Integer> Node1;
////    GenericTreeNode<Integer> Node2;
////     public pair(int max1,int max2,GenericTreeNode<Integer> Node1,GenericTreeNode<Integer> Node2)
////     {
////         this.max1=max1;
////         this.max2=max2;
////         this.Node1=Node1;
////         this.Node2=Node2;
////         
////     }
////}
////10 3 20 2 40 0 50 0 30 0 40 0
////class TreeNode<T> {
////	T data;
////	ArrayList<TreeNode<T>> children;
////
////	TreeNode(T data){
////		this.data = data;
////		children = new ArrayList<TreeNode<T>>();
////	}
////}
//public class SecondLargest extends GenericTreeUse {
//
////	TreeNode structure 
//  
////	public static void takeInput()
//	public static pair findSecondLargestHelper(GenericTreeNode<Integer> root )
//	{
//	    if(root==null)
//	    {
//	        pair newNode=new pair(Integer.MIN_VALUE,Integer.MIN_VALUE,null,null);
//	        return newNode;
//	    }
//	    int pos1=-1;
//	    int pos2=-1;
//	  
//	    int max=Integer.MIN_VALUE;
//	    int maxSecond=Integer.MIN_VALUE;
//	   
//	    for(int i=0;i<root.children.size();i++)
//	    {
//	        
//	        GenericTreeNode<Integer> current=root.children.get(i);
//	        if(max<current.data)
//	        {
//	            maxSecond=max;
//	            max=current.data;
//	            pos2=pos1;
//	            pos1=i;
//	            
//	        }
//	    }
//	    if(pos2==-1)
//	    {
//	    	pair newNode=new pair(Integer.MIN_VALUE,Integer.MIN_VALUE,null,null);
//	        return newNode;
//	    }
//	    pair current=new pair(max,maxSecond,root.children.get(pos1),root.children.get(pos2));
//	    for(int i=0;i<root.children.size();i++)
//	    {
//	    			
//	    		pair child=findSecondLargestHelper(root.children.get(i));
//	    		if(child.max1>current.max1)
//		        {
//		            int temp=current.max1;
//		            GenericTreeNode<Integer> tempNode=current.Node1;
//		            current.max1=child.max1;
//		            current.Node1=child.Node1;
//		            if(child.max2>current.max2)
//		            {
//		                if(child.max2>temp)
//		                {
//		                    current.max2=child.max2;
//		                    current.Node2=child.Node2;
//		                    
//		                }
//		            }
//		            else if(temp>child.max2)
//		            {
//		                current.max2=temp;
//		                current.Node2=tempNode;
//		            }
//		        }  
//		            
//	    }
//	    return current;
//	}
//		    
//	
//	    
//	
//	public static GenericTreeNode<Integer> findSecondLargest (GenericTreeNode<Integer> root){
//
//
//		// Write your code here
//		pair ans=findSecondLargestHelper(root);
//		return ans.Node2;
//		
//
//	}
//	public static void main(String[] args) {
//		Scanner s=new Scanner(System.in);
//		GenericTreeNode<Integer> root=takeInput(s);
//		root=findSecondLargest(root);
//		System.out.println(root.data);
//		
//	}
//	
//	
//}
//
package l17;

import java.util.Scanner;

class Pair
{
	int max;
    int nextMax;
 public Pair(int max,int nextMax) {
	// TODO Auto-generated constructor stub
	 this.max=max;
	 this.nextMax=nextMax;
 	}
}
public class SecondLargest extends GenericTreeUse {
	public static Pair sortPair(Pair p1,Pair p2)
	{
		int arr[]=new int[4];
		arr[0]=p1.max;
		arr[1]=p2.max;
		arr[2]=p1.nextMax;
		arr[3]=p2.nextMax;
		
		for(int i=0;i<4;i++)
		{
			for(int j=0;j<4-i-1;j++)
			{
				if(arr[j]>arr[j+1])
				{
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		}
		int maximum=arr[3];
		int nextmaximum=arr[2];
		if(arr[2]!=arr[3])
		{
			nextmaximum=arr[2];
		}
		else if(arr[1]!=arr[3])
		{
			nextmaximum=arr[1];
		}
		Pair ans=new Pair(maximum, nextmaximum);
		return ans;
	}
	public static Pair findSecondLargestHelper(GenericTreeNode<Integer> root)
	{
		
	    if(root==null)
	    {
	        Pair newNode=new Pair(Integer.MIN_VALUE,Integer.MIN_VALUE);
	        return newNode;
	    }
	    int max=root.data;
	    int nextMax=root.data;
	    Pair ans=new Pair(max,nextMax);
	    for(int i=0;i<root.children.size();i++)
	    {
	    		GenericTreeNode<Integer> currentNode=root.children.get(i);
	    		Pair childPair=findSecondLargestHelper(currentNode);
	    		 ans=sortPair(ans, childPair);
	    	}
	    
	    return ans;
	    
	   
	}
	
	public static GenericTreeNode<Integer> findSecondLargest(GenericTreeNode<Integer> root){
		
		// Write your code here
		Pair ans=findSecondLargestHelper(root);
		GenericTreeNode<Integer> node=new GenericTreeNode<Integer>(ans.nextMax);
		return node;
	    

	}
	public static void main(String[] args) {
		
		Scanner s=new Scanner(System.in);
//		n=s.nextInt();
		GenericTreeNode<Integer> root=takeInput(s);
		root=findSecondLargest(root);
		System.out.println(root.data);
	}

}

