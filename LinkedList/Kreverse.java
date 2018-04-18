package l12;

import java.util.Scanner;

public class Kreverse extends Nodeuse {
	 public static int len(LinkedListNode<Integer> head)
	    {
	        int count=0;
	        while(head!=null)
	        {
	            head=head.next;
	            count++;
	            
	        }
	        return count;
	    }
	    public static LinkedListNode<Integer> reverse(LinkedListNode<Integer> head)
	    {
	        LinkedListNode<Integer> prev,current,temp;
	        prev=null;
	        current=head;
	        temp=current.next;
	        while(current!=null)
	        {
	            if(prev==null)
	            {
	                prev=current;
	                current.next=null;
	                current=temp;
	                temp=temp.next;
	                continue;
	            }
	            
	            else{
	            current.next=prev;
	            prev=current;
	            current=temp;
	            if(temp!=null)
	            		temp=temp.next;
	            
	            }
	            
	        }
//	        print(prev);
	        return prev ;
	        
	    }
		public static LinkedListNode<Integer> kReverse(LinkedListNode<Integer> head, int k) {
		    LinkedListNode<Integer> temp=head;
		    LinkedListNode<Integer> tail=head;
		    LinkedListNode<Integer> prev=null;
		    LinkedListNode<Integer> help=null;
		    int length_of_linkeList=len(head);
		    if(head==null)
		        return null;
		    
		    int i=length_of_linkeList/k;
		    while(i>0)
		    {
		    int count=0;
		    while(count<k)
		    {
		        prev=tail;
		       tail=tail.next;
		       count++;
		    }
		    prev.next=null;
		    LinkedListNode<Integer> newHead=reverse(temp);
		    LinkedListNode<Integer> iterator=newHead;
		    while(iterator.next!=null)
		    {
		        iterator=iterator.next;
		    }
		    if(help!=null)
		    {
		        help.next=newHead;
		    }
		    if(help==null)
		    {
		        head=newHead;
		    }
		    iterator.next=tail;
		    temp=tail;
		    help=iterator;
		    i--;
		    }
		    
		    if(length_of_linkeList%k>0){
		    LinkedListNode<Integer> newHead=reverse(tail);
		    help.next=newHead;
		    }
		    return head;
		}
		public static void main(String[] args) {
			LinkedListNode<Integer> head=takeInput();
			System.out.println("\n enter k");
			Scanner s=new Scanner(System.in);
			int k=s.nextInt();
			head=kReverse(head, k);
			print(head);
		}
}
