package l16;
import l14.*;
import java.lang.Math;
import java.lang.reflect.Array;

import l15.QueueEmptyException;
import l15.QueueImplementation;
import l15.QueueUse;

import java.util.ArrayList;
import java.util.Scanner;
class Pair<T,V>
{
	public T diameter;
	public V height;
	public Pair(T data,V value)
	{
		this.diameter=data;
		this.height=value;
	}
	
}
public class TreeUsingTreeNode extends QueueUse{
	public static void print(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return;
		}
		System.out.print(root.data + ":");
		if (root.left != null) {
			System.out.print(root.left.data + ",");
		}
		if (root.right != null) {
			System.out.print(root.right.data + ",");
		}
		System.out.println();

		print(root.left);
		print(root.right);
	}

	public static  BinaryTreeNode<Integer> takeInputLevelWise()
	{
		System.out.println("Enter root data");
		Scanner s = new Scanner(System.in);
		int rootData = s.nextInt();
		if (rootData == -1) {
			return null;
		}
		BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
		QueueImplementation<BinaryTreeNode<Integer>> queue = new QueueImplementation<>();
		queue.enqueue(root);
		while (!queue.isEmpty()) {
			BinaryTreeNode<Integer> parent;
			try {
				parent = queue.dequeue();
			} catch (QueueEmptyException e) {
				return null;
			}
			System.out.println("Enter left child of " + parent.data);
			int leftData = s.nextInt();
			if (leftData != -1) {
				BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<Integer>(leftData);
				queue.enqueue(leftChild);
				parent.left = leftChild;
			}

			System.out.println("Enter right child of " + parent.data);
			int rightData = s.nextInt();
			if (rightData != -1) {
				BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<Integer>(rightData);
				queue.enqueue(rightChild);
				parent.right = rightChild;
			}
		}
		return root;



	}

	public static int  maxElement(BinaryTreeNode<Integer> root)
	{
		if(root==null)
		{
			return Integer.MIN_VALUE;
		}
		int left=maxElement(root.left);
		int right=maxElement(root.right);
		int currentData=root.data;
		if(currentData>=left&&currentData>=right)
		{
			return currentData;
		}
		else if(left>currentData&&left>right){
			return left;
		}
		else
			return right;
	}
	public static boolean searchAnElement(BinaryTreeNode<Integer> root,int element)
	{
		boolean ans;
		if(root==null)
		{
			return false;
		}
		if(root.data==element)
		{
			return true;
		}
		ans=searchAnElement(root.left, element);
		if(ans==true)
		{
			return ans;
		}
		ans=searchAnElement(root.right, element);
		return ans;
	}
	public static int heightOfTree(BinaryTreeNode<Integer> root)
	{
		ArrayList<Integer> arr=new ArrayList<>();
		arr.si
		if(root==null)
		{
			return 0;
		}
		int ans=0;
		int count1=0;
		int count2=0;
		count1=heightOfTree(root.left);
		count2=heightOfTree(root.right);
		if(count1>=count2)
		{
			ans=count1+1;
			return count1+1;
		}
		else if(count2>count1){
			ans=count2+1;
			return count2+1;
		}
		return ans;	


	}
	public static int noOfLeafNodes(BinaryTreeNode<Integer> root)
	{
		int count=0;
		if(root==null)
		{
			return 0;
		}
		if(root.left==null&&root.right==null)
			return 1;
		count=count+noOfLeafNodes(root.left);
		count=count+noOfLeafNodes(root.right);
		return count;
	}
	
	public static void printLevelWise(BinaryTreeNode<Integer> root) throws QueueEmptyException
	{
		QueueImplementation<BinaryTreeNode> newQueue=new QueueImplementation<>();
		if(root==null)
		{
			return;
		}
		System.out.println(root.data);
		newQueue.enqueue(root.left);
		newQueue.enqueue(root.right);
		while(newQueue!=null)
		{
			try{

				BinaryTreeNode<Integer> current=newQueue.dequeue();
				if(current==null)
				{
					return ;
				}

				System.out.println(current.data);
				newQueue.enqueue(current.left);
				newQueue.enqueue(current.right);
			}catch(QueueEmptyException e){

			}
		}
	}
	
	public static void printAtILevel(BinaryTreeNode<Integer> root,int level)
	{
		if(root==null)
			return;
		if(level==0)
		{
			System.out.println(root.data);
		}
		printAtILevel(root.left, level-1);
		printAtILevel(root.right, level-1);
	}
	public static int MaxNode(BinaryTreeNode<Integer> root)	
	{
		int leftChildSum=0;
		int rightChildSum=0;
		int currentSum=0;
		int ans=0;
		if(root==null)
		{
			return 0;
		}
		if(root.left==null&&root.right==null)
		{
			currentSum=currentSum+root.data;
		}else if(root.left==null){
			currentSum=currentSum+root.data+root.right.data;

		}
		else if(root.right==null){
			currentSum=currentSum+root.data+root.left.data;
		}
		else
			currentSum=currentSum+root.data+root.left.data+root.right.data;
		leftChildSum=leftChildSum+MaxNode(root.left);
		rightChildSum=rightChildSum+MaxNode(root.right);
		if(currentSum>=rightChildSum&&currentSum>=leftChildSum)
		{
			ans=currentSum;
		}else if(leftChildSum>currentSum&&leftChildSum>rightChildSum){
			ans=leftChildSum;
		}else if(rightChildSum>currentSum&&rightChildSum>leftChildSum){
			ans=rightChildSum;
		}
		return ans;
	} 
	public static boolean isBalanced(BinaryTreeNode<Integer> root) 
	{
		boolean ans = false;
		boolean leftBalance;
		boolean rightBalance;
		if(root==null)
		{
			ans=true;
			return ans;
		}
		int left=heightOfTree(root.left);
		int right=heightOfTree(root.right);
		if(Math.abs(left-right)<2)
		{
			 leftBalance=isBalanced(root.left);
			 rightBalance=isBalanced(root.right);
		}
		else 
		{
			ans=false;
			return ans;
		}
		if(leftBalance==true&&rightBalance==true)
		{
			ans=true;
			
		}
		return ans;

}
	//1 2 3 
	public static int minElement(BinaryTreeNode<Integer> root)
	{
		if(root==null)
		{
			return Integer.MAX_VALUE;
		}
		int left=minElement(root.left);
		int right=minElement(root.right);
		int currentData=root.data;
		if(currentData<=left&&currentData<=right)
		{
			return currentData;
		}
		else if(left<currentData&&left<right){
			return left;
		}
		else
			return right;
	}
	public static int diameterOfTree(BinaryTreeNode<Integer> root)
	{
		Pair<Integer,Integer> answer=modifiedDiameter(root);
		return answer.diameter;
//		if(root==null)
//		{
//			return 0;
//		}
//		int leftHeight=heightOfTree(root.left);
//		int rightHeight=heightOfTree(root.right);
//		int currentDiameter=leftHeight+rightHeight;
//		int leftDiameter=diameterOfTree(root.left);
//		int rightDiameter=diameterOfTree(root.right);
//		int ans;
//		if(currentDiameter>=leftDiameter&&currentDiameter>=rightDiameter)
//		{
//			ans=currentDiameter;
//		}else if(leftDiameter>currentDiameter&&leftDiameter>currentDiameter)
//		{
//			ans=leftDiameter;
//		}
//		else
//			ans=rightDiameter;
//		return ans;
	}

	public static Pair<Integer,Integer> modifiedDiameter(BinaryTreeNode<Integer> root)
	{
		Pair<Integer,Integer> answer=new Pair<Integer, Integer>(0,0);
		
		if(root==null)
		{
			return answer;
		}
		Pair<Integer,Integer> left=modifiedDiameter(root.left);
		Pair<Integer,Integer> right=modifiedDiameter(root.right);
		
		int height=1+Math.max(left.height,right.height);
		int diameter=left.height+right.height;
		Pair<Integer,Integer> current=new Pair<Integer, Integer>(diameter,height);
		System.out.println("current diameter is"+current.diameter);
		if(current.diameter>=left.diameter&&current.diameter>=right.diameter)
		{
			answer=current;
		}
		else if(left.diameter>current.diameter&&left.diameter>right.diameter)
		{
			answer=left;
		}else
			answer=right;
		return answer;
	}
	
	public static void printAncestors(BinaryTreeNode<Integer> root,int n)
	{
		if(root==null)
			return;
		
		printAncestors(root.left,n);
		printAncestors(root.right,n);
		if(root.data==n)
		{
			return;
		}
		boolean ans1=searchAnElement(root.left, n);
		if(ans1==true)
			System.out.print(root.data+" ");
		boolean ans2=searchAnElement(root.right,n);
		if(ans2==true)
		{
			System.out.print(root.data);
		}
	}
	
	public static ArrayList<BinaryTreeNode<Integer>> getAncestors(BinaryTreeNode<Integer> root,int n)
	{
		ArrayList<BinaryTreeNode<Integer>> list;
		
		if(root==null)
		{
			return null;
		}
		if(root.data==n)
		{
			list=new ArrayList<BinaryTreeNode<Integer>>();
			list.add(root);
			return list ;
		}
		list=getAncestors(root.left, n);
		if(list!=null)
		{
			
			list.add(root);
			return list;
		}
		ArrayList<BinaryTreeNode<Integer>> list2;
		list2=getAncestors(root.right, n);
		
		if(list2!=null);
		{
			
			list2.add(root);
			list=list2;
			
		}
		return list;
				
		
	}
//public static TreeNode<Integer> 
	
	
	

	public static void main(String[] args) throws QueueEmptyException {
		Scanner s=new Scanner(System.in);
		BinaryTreeNode<Integer> root=takeInputLevelWise();
		print(root);
//		int ans=maxElement(root);
//		System.out.println("largest is "+ans);
//		System.out.println("\n enter element to be searched");
//		//	int element=s.nextInt();
//		//	System.out.println("seached element is "+searchAnElement(root, element));
//		int height=heightOfTree(root);
//		System.out.println("height of tree is"+height);
//		int leafNodes=noOfLeafNodes(root);
//		System.out.println("leaf nodes"+leafNodes);
//		//printLevelWise(root);
//		System.out.println("enter level to print");
//		int level=s.nextInt();
//		printAtILevel(root, level);
//		int MaxNodeSum=MaxNode(root);
//		System.out.println("maxNode sum is"+MaxNodeSum);
//		boolean Bal=isBalanced(root);
//		System.out.println("the tree is "+ Bal);
//		int Diameter=diameterOfTree(root);
//		System.out.println("diameter is "+Diameter);
		System.out.println("\neneter n");
		int n=s.nextInt();
		printAncestors(root, n);
		System.out.println();
		ArrayList<BinaryTreeNode<Integer>> list=getAncestors(root, n);
		for(int i=0;i<list.size();i++)
		{
			System.out.print(list.get(i).data);
		}

	}
}
