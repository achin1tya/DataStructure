package l16;

import java.util.ArrayList;

class Node<T> {
T data;
Node<T> next;
Node(T data){
	this.data = data;
}
}
public class levelwiseLinkedList extends TreeUsingTreeNode {
	public static int heightOfTree(BinaryTreeNode<Integer> root)
    {
        if(root==null)
        {
            return 0;
        }
        int count1=heightOfTree(root.left);
        int count2=heightOfTree(root.right);
        int max;
        if(count1>=count2)
            max=count1;
        else
            max=count2;
        return 1+max;
    }
    public static Node<BinaryTreeNode<Integer>> goAtLevel(BinaryTreeNode<Integer> root,int level)
    {
        Node<BinaryTreeNode<Integer>> tail=null;
        Node<BinaryTreeNode<Integer>> newHead;
        if(root==null)
            return null;
       
        if(level==0)
        {
             Node<BinaryTreeNode<Integer>> newNode=new Node<BinaryTreeNode<Integer>>(root);
             newNode.next=null;
             tail=newNode;
        }
        if(level>0)
        {
            tail=goAtLevel(root.left,level-1);
            newHead=goAtLevel(root.right,level-1);
            Node<BinaryTreeNode<Integer>> ptr=tail;
            while(ptr.next!=null)
            {
                ptr=ptr.next;
            }
            ptr.next=newHead;
           
        }
        return tail;
    }
	public static ArrayList<Node<BinaryTreeNode<Integer>>> LLForEachLevel(BinaryTreeNode<Integer> root) {
		
		// Write your code here
		int height=heightOfTree(root);
		ArrayList<Node<BinaryTreeNode<Integer>>> arr=new ArrayList(height);
		for(int i=0;i<height;i++)
		{
		    Node<BinaryTreeNode<Integer>> ptr=goAtLevel(root,i);
		    arr.add(ptr);
		}
        return (arr);
	}
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root=takeInputLevelWise();
		root=LLForEachLevel(root);
	}


}

