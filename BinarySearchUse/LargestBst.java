package l19;
import l16.TreeNode;
import l18.*;
class ReturnObj
{
	int min;
	int max;
	TreeNode<Integer> node;
	int height;
	public ReturnObj(int min,int max,TreeNode<Integer> node,int height)
	{
		this.min=min;
		this.max=max;
		this.node=node;
		this.height=height;
	}
}
public class LargestBst extends Bst {
	public static ReturnObj findLargestBst(TreeNode<Integer> root)
	{
		ReturnObj newNode = null;
		if(root==null)
		{
			newNode=new ReturnObj(Integer.MAX_VALUE,Integer.MIN_VALUE,null,0);
			return newNode;
		}
		ReturnObj leftNode=findLargestBst(root.left);
		ReturnObj rightNode=findLargestBst(root.right);
		int maximum=Math.max(leftNode.max,rightNode.max);
		int minimum=Math.min(leftNode.min,rightNode.min);
		int heightOfTree=Math.max(leftNode.height,rightNode.height);
		if(leftNode.node==null&&rightNode.node==null)
		{
			maximum=root.data;
			minimum=root.data;
			newNode=new ReturnObj(minimum, maximum, root, 1);
			return newNode;
		}
		
		if(root.left==leftNode.node&&root.right==rightNode.node&&root.data>leftNode.max&&root.data<=rightNode.min)
		{
				newNode=new ReturnObj(minimum,maximum,root,heightOfTree+1);
				return newNode;
		}
		if(leftNode.height>=rightNode.height)
		{
			newNode=new ReturnObj(minimum,maximum,leftNode.node,heightOfTree);
			return newNode;
		}
		else if(leftNode.height<rightNode.height)
		{
			newNode=new ReturnObj(minimum,maximum,rightNode.node,heightOfTree);
			return newNode;
		}
		return newNode;
	}
	public static void main(String[] args) {
		//4 2 6 1 3 5 7 -1 -1 -1 -1 -1 -1 -1 -1
		//5 10
		TreeNode<Integer> root=takeInputLevelWise();
		ReturnObj ans=findLargestBst(root);
		print(ans.node);
		System.out.println("height best is"+ans.height);
	}
}
