package l19;
import l14.*;
import l16.TreeNode;
public class ZigzagUsingTwostack extends StackUse{
	public static void printZigZag(TreeNode<Integer> root,boolean flag)
	{
		StackusingLinkedList<TreeNode<Integer>> s1=new StackusingLinkedList<TreeNode<Integer>>();
		StackusingLinkedList<TreeNode<Integer>> s2=new StackusingLinkedList<TreeNode<Integer>>();
		s1.push(root);
		while(s1.size()!=0)
		{
			TreeNode<Integer> currentNode=s1.top();
			s1.pop();
			if(flag==false)
			{
				if(currentNode.left!=null)
					s2.push(currentNode.left);
				if(currentNode.right!=null)
					s2.push(currentNode.right);
			}
			else if(flag==true)
			{
				if(currentNode.right!=null)
					s2.push(currentNode.right);
				if(currentNode.left!=null)
					s2.push(currentNode.left);
			}
			if(s1.size()==0)
			{
				System.out.println();
				StackusingLinkedList<TreeNode<Integer>> temp=new StackusingLinkedList<TreeNode<Integer>>();
				temp=s1;
				s1=s2;
				s2=s1;
			}
		}
	}
}
