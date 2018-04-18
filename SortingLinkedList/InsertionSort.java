package l13;
import l12.*;
public class InsertionSort extends Nodeuse {
	public static LinkedListNode<Integer> insertionSort(LinkedListNode<Integer> head) {
		// write your code here
	LinkedListNode<Integer> ptr=head;
	if(ptr==null)
	{
	    return null;
	}
	LinkedListNode<Integer> newHead=null;
	
	while(ptr!=null)
	{
	    LinkedListNode<Integer> temp=ptr.next;
	    LinkedListNode<Integer> newNode=new LinkedListNode<Integer>(ptr.data);
	    newNode.next=null;
        LinkedListNode<Integer> ptr2=newHead;
	    LinkedListNode<Integer> prev=null;
	    if(newHead==null)
	    {
	        newHead=newNode;
	        ptr=temp;
	        continue;
	    }
	    int ptr2data=ptr2.data;
	    int newdata=newNode.data;
	    while(ptr2data<newdata&&ptr2!=null)
	    {
	        prev=ptr2;
	        ptr2=ptr2.next;
	        if(ptr2!=null)
	        	ptr2data=ptr2.data;
	        else
	        	break;
	        newdata=newNode.data;
	    }
	    if(prev==null)
	    {
	        newNode.next=newHead;
	        newHead=newNode;
	    }
	    else
	    {
	        newNode.next=prev.next;
	        prev.next=newNode;
	    }
	    ptr=temp;
	    
	}
	return newHead;

	}
public static void main(String[] args) {
	LinkedListNode<Integer> head=takeInput();
	head=insertionSort(head);
	print(head);
}	
}
