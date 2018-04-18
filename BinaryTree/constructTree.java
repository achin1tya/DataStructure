package l16;

import java.util.Scanner;

public class constructTree extends TreeUsingTreeNode {
	

		/*	Binary Tree Node class
		 * 
		 * class BinaryTreeNode<T> {
			T data;
			BinaryTreeNode<T> left;
			BinaryTreeNode<T> right;

			public BinaryTreeNode(T data) {
				this.data = data;
			}
		}
		 */
	    
		public static BinaryTreeNode<Integer> getTreeFromPreorderAndInorder(int[] pre,
				int[] in){
				    if(in.length==0)
				    {
				        return null;
				    }
				    if(in.length==1)
				    {
				    		BinaryTreeNode<Integer> root=new BinaryTreeNode<Integer>(in[0]);
				    		return root;
				    }
				    BinaryTreeNode<Integer> root=new BinaryTreeNode<Integer>(pre[0]);
				    int i=0;
				    for(;i<in.length;i++)
				    {
				        if(in[i]==pre[0])
				        {
				            break;
				        }
				    }
				    int leftin[]=new int[i-1];
				    int rightin[]=new int[in.length-i];
				    for(int j=0;j<i;j++)
				    {
				        leftin[j]=in[j];
				    }
				    for(int j=0;j<in.length-i;j++)
				    {
				        rightin[j]=in[i+j];
				    }
				    int shortPre[]=new int[pre.length-1];
				    for(int j=1;j<pre.length;j++)
				    {
				        shortPre[j-1]=pre[j];
				    }
				    BinaryTreeNode<Integer> leftTree=getTreeFromPreorderAndInorder(shortPre,leftin);
				    BinaryTreeNode<Integer> rightTree=getTreeFromPreorderAndInorder(shortPre,rightin);
				    root.left=leftTree;
				    root.right=rightTree;
				    return root;
		}
		public static void main(String[] args) {
			Scanner s=new Scanner(System.in);
			System.out.println("\n enter size");
			int size=s.nextInt();
			int in[]=new int[size];
			int pre[]=new int[size];
			for(int i=0;i<size;i++)
			{
				in[i]=s.nextInt();
				
			}
			for(int j=0;j<size;j++)
			{
				pre[j]=s.nextInt();
			}
			BinaryTreeNode<Integer> root=getTreeFromPreorderAndInorder(pre, in);
			print(root);
		}
		

	}


