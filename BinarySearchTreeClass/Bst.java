package l18;
import l12.*;
import java.util.Scanner;

import l16.*;
class triplet
{
	boolean ans;
	int min;
	int max;
}
public class Bst extends TreeUsingTreeNode{

	public static boolean isBst(TreeNode<Integer> root)
	{
		boolean ans=false;
		if(root==null)
			return true;
		if(root.left==null&&root.right==null)
		{
			return true;
		}
		
		else if(root.right!=null&&root.left==null)
		{
			int min=minElement(root.right);
			if(root.data>min)
			{
				return false;
			}
			else
			{
				ans=isBst(root.right);
			}
		}
		else if(root.left!=null&&root.right==null)
		{
			int max=maxElement(root.left);
			if(root.data<max)
			{
				return false;
			}
			else
			{
				ans=isBst(root.left);
			}
		}
		else
		{
			int min=minElement(root.right);
			int max=maxElement(root.left);
			if(root.data>min)
			{
				return false;
			}
			else if(root.data<max)
			{
				return false;
			}
			else
			{
				ans=true;
				ans=isBst(root.left);
				if(ans==false)
					return false;
				ans=isBst(root.right);
				
			}
		}
		return ans;
	}
	
//	public static triplet modifiedIsBst(TreeNode<Integer> root)
//	{
//		triplet newNode=new triplet();
//		newNode.ans=true;
//		newNode.max=Integer.MIN_VALUE;
//		newNode.min=Integer.MAX_VALUE;
//		if(root==null)
//		{
//			return newNode;
//		}
//		triplet leftAns=modifiedIsBst(root.left);
//		triplet rightAns=modifiedIsBst(root.right);
//		//min
////		if(leftAns.min<=newNode.min&&leftAns.min<=rightAns.min)
////			newNode.min=leftAns.min;
//		if(rightAns.min<=newNode.min&&rightAns.min<=leftAns.min)
//			newNode.min=rightAns.min;
//		//max
//		if(leftAns.max>=newNode.max&&leftAns.max>=rightAns.max)
//			newNode.min=leftAns.max;
////		else if(rightAns.max>newNode.max&&rightAns.max>leftAns.max)
////			newNode.max=rightAns.max;
//		if()
//		
//	}
//	
	public static TreeNode<Integer> buildBST(int arr[],int si,int ei)
	{
		TreeNode<Integer> newNode;
		if(si>ei)
			return null;
		if(arr.length==1)
		{
			newNode=new TreeNode<Integer>(arr[si]);
			return newNode;
		}
		int mid=(si+ei)/2;
		TreeNode<Integer> leftNode=buildBST(arr,si ,mid-1 );
		TreeNode<Integer> rightNode=buildBST(arr, mid+1, ei);
		newNode=new TreeNode(arr[mid]);
		newNode.left=leftNode;
		newNode.right=rightNode;
		return newNode;
	}
	public static TreeNode<Integer> lcaInBST(TreeNode<Integer> root,int num1,int num2)
	{
		if(root==null)
		{
			return null;
		}
		if(root.left.data==num1&&root.right.data==num2||root.left.data==num2&&root.right.data==num1)
		{
			return root;
		}
		if(num1>root.data&&num2>root.data)
			return lcaInBST(root.right, num1, num2);
		else if(num1<root.data&&num2<root.data)
			return lcaInBST(root.left, num1, num2);
		else
			return root;
	}
	
	public static Node<TreeNode<Integer>> buildLLFromTreeLevelWise(TreeNode<Integer> root)
	{
		Node<TreeNode<Integer>> newNode = null;
		if(root==null)
			return null;
		Node<TreeNode<Integer>> newNodeLeft=buildLLFromTreeLevelWise(root.left);
		if(newNodeLeft!=null)
		{	
		newNode=new Node<TreeNode<Integer>>(root);
		Node<TreeNode<Integer>> ptr=newNodeLeft;
		while(ptr.next!=null)
			ptr=ptr.next;
		
		ptr.next=newNode;
		Node<TreeNode<Integer>> newNodeRght=buildLLFromTreeLevelWise(root.right);
		newNode.next=newNodeRght;
		}
		else
			return newNode;
		return newNodeLeft;
	}
	public static void main(String[] args) {
//		TreeNode<Integer> root=takeInputLevelWise();
//		print(root);
//		boolean ans=isBst(root);
//		System.out.println("tree is "+ans);
		System.out.println("\ne enter size of array");
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		System.out.println("\n enter array");
		int arr[]=new int[n];
		for(int i=0;i<n;i++)
		{
			arr[i]=s.nextInt();
		}
	TreeNode<Integer> root=buildBST(arr, 0, n-1);
		boolean ans=isBst(root);
		print(buildBST(arr, 0, n-1));
	System.out.println("tree is "+ans);
	root=lcaInBST(root,2, 10);
	System.out.println(root.data);
	Node<TreeNode<Integer>> ansLevel=buildLLFromTreeLevelWise(root);
	Node<TreeNode<Integer>> ptr=ansLevel;
	while(ptr!=null)
	{
		System.out.println(ptr.data.data+" ");
		ptr=ptr.next;
	}
	
		
		
	}
}
