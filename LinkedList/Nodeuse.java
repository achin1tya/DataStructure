package l12;

import java.util.Scanner;
import java.util.Stack;



public class Nodeuse {
	public static LinkedListNode<Integer> findMid(LinkedListNode<Integer> head)
	{
		Stack<Character> s=new Stack<Character>();
		s.isEmpty();
		
	    LinkedListNode<Integer> fast=head.next;
	     LinkedListNode<Integer> slow=head;
	    while(fast!=null&&fast.next!=null)
	    {
	        fast=fast.next.next;
	        slow=slow.next;
	    }
	    return slow;
	}

		public static boolean isPalindrome_2(LinkedListNode<Integer> head) {
		    if(head==null)
		    {
		        return true;
		    }
		    LinkedListNode<Integer> mid=findMid(head);
		    LinkedListNode<Integer> temp=mid.next;
		    mid.next=null;
		    LinkedListNode<Integer> prev=null;
		    LinkedListNode<Integer> current=head;
		    LinkedListNode<Integer> helper;
		     boolean ans=false;
		
		    
		    while(current!=null)
		    {
		        if(prev==null)
		        {
		            prev=current;
		            current=current.next;
		        }
		        else
		        {
		            helper=current.next;
		            current.next=prev;
		            prev.next=null;
		            current=helper;
		            
		        }
		        
		            
		    }
		    LinkedListNode<Integer> head2=prev;
		    LinkedListNode<Integer> ptr1,ptr2,ptr3;
		    ptr1=head2;
		    ptr2=head2.next;
		    ptr3=temp;
		    int len1=0;
		    int len2=0;
		    while(ptr1!=null)
		    {
		        ptr1=ptr1.next;
		        len1++;
		    }
		    while(ptr3!=null)
		    {
		        ptr3=ptr3.next;
		        len2++;
		    }
		     ptr1=head2;
		      ptr3=temp;
		    if(len1==len2)
		    {
		        while(ptr1.data.equals(ptr3.data))
		        {
		            ptr1=ptr1.next;
		            ptr3=ptr3.next;
		            if(ptr1==null||ptr3==null)
		            {
		                break;
		            }
		        }
		        if(ptr1==null&&ptr3==null)
		        {
		            ans=true;
		        }
		    }
		    else if(len1==len2+1)
		    {
		        while(ptr3.data.equals(ptr1.data)||ptr3.data.equals(ptr2.data))
		        {
		            ptr1=ptr1.next;
		            ptr2=ptr1.next;
		            if(ptr2==null)
		            {
		                ptr3=ptr3.next;
		                break;
		            }
		        
		        }
		   
		        if(ptr2==null&&ptr3==null)
		        {
		         ans=true; 
		        }
		    }
		    else
		    ans=false;
		   
		   return false; 
		    
	    }
	public static LinkedListNode<Integer> takeInput()
	{
		LinkedListNode<Integer> head=null;
		System.out.println("\n enter data");
		int nextData;
		Scanner s=new Scanner(System.in);
		nextData=s.nextInt();
		
		while(nextData!=-1)
		{
			LinkedListNode<Integer> nextNode=new LinkedListNode<Integer>(nextData);
			if(head==null)
			{
				head=nextNode;
			}
			else
			{
				LinkedListNode<Integer> tail=head;
				while(tail.next!=null)
					tail=tail.next;
				tail.next=nextNode;
			}
			nextData=s.nextInt();
			
		}
		return head;
	}
	public static int len(LinkedListNode<Integer> head)
	{
		int len=0;
		LinkedListNode<Integer> tail=head;
		while(tail!=null)
		{
			tail=tail.next;
			len++;
		}
		return len;
	}
	public static <Integer> void print(LinkedListNode<Integer> ans)
	{
		LinkedListNode<Integer> tail=(LinkedListNode<Integer>) ans;
		while(tail!=null)
		{
			System.out.println(tail.data+"-->");
			tail=tail.next;
		}
		
	}
	public static void printAtI(LinkedListNode<Integer> head,int position)
	{
		int len=1;
		LinkedListNode<Integer> tail=head;
		if(head==null&&position>=0)
		{
			System.out.println("no elemet");
		}
		else
		{
			while(len<position)
			{
				tail=tail.next;
				len++;
			}
			System.out.println("element at "+position+"th is"+tail.data );
		}
	}
	public static LinkedListNode<Integer> insertAtI(LinkedListNode<Integer> head,int position ,int element)
	{
		int len=1;
		LinkedListNode<Integer> start=head;
		LinkedListNode<Integer> tail=head;
		
		LinkedListNode<Integer> n=new LinkedListNode<Integer>(element);
		if(head==null)
		{
			start=n;
		}
		else if(position==0)
		{
			n.next=head;
			start=n;
		}
		else
			while(len<position&&tail.next!=null)
			{
				len++;
				tail=tail.next;
				
			}
			n.next=tail.next;
			tail.next=n;
		
		return start;
	}
	public static LinkedListNode<Integer> DeletionAtIR(LinkedListNode<Integer> head,int position)
	{
		if(head==null&&position>0)
		{
			return head;
		}
		if(position==2)
		{
			head.next=head.next.next;
			return head;
		}
		head.next=DeletionAtIR(head.next, position-1);
		return head;
	}
	public static<T> LinkedListNode<Integer> DeletionAtI(LinkedListNode<Integer> head,int position)
	{
		LinkedListNode<Integer> prev=head;
		if(head==null)
			return head;
		int i=1;
		if(position==0)
		{
			head=head.next;
		}
		while(i<position&&prev.next!=null)
		{
			prev=prev.next;
			i++;
		}
		
		prev.next=prev.next.next;
		return head;
	}
	
	public static <Integer> LinkedListNode<Integer> midPoint(LinkedListNode<Integer> head)
	{
		LinkedListNode<Integer> ptr,fastptr;
		ptr=head;
		fastptr=head.next;
		while(fastptr!=null)
		{
			
			if(fastptr.next!=null)
			{	fastptr=fastptr.next.next;
				ptr=ptr.next;
			}	
			else 
				break;
			
		}
		return ptr;
	}
	public static<Integer> LinkedListNode<Integer> removeDuplicates(LinkedListNode<Integer> head) {
	    LinkedListNode<Integer> ptr=head;
	    if(head==null)
	        return head;
	    else if(head.next==null)
	        return head;
	   else
	   {
	    while(ptr.next!=null)
	    {
	        if(ptr.data==ptr.next.data)
	           {
	               ptr.next=ptr.next.next;
	           }
	           else 
	           ptr=ptr.next;
	    }
	   }
	    return head;
	}
	public static  <Integer> LinkedListNode<Integer> mergeTwoSortedll(LinkedListNode<Integer> head1,LinkedListNode<Integer> head2)
	{
		LinkedListNode<Integer> outputHead;
		LinkedListNode<Integer> outputTail;
		if(head1==null&&head2!=null)
		{
			return head2;
		}
		else if(head2==null&&head1!=null)
		{
			return head1;
		}
		int data1=(int)head1.data;
		int data2=(int)head2.data;
		if(data1>=data2)
		{
			
			outputHead=head2;
			outputTail=head2;
			head2=head2.next;
		}
		else
		{
			outputHead=head1;
			outputTail=head1;
			head1=head1.next;
		}
		while(head1!=null&&head2!=null)
		{
			int data11=(int) head1.data;
			int data21=(int) head2.data;
			if(data11>=data21)
			{
				
				outputTail.next=head2;
				outputTail=head2;
				head2=head2.next;
			}
			else
			{
				outputTail.next=head1;
				outputTail=head1;
				head1=head1.next;
			}
		}
		while(head1!=null)
		{
			outputTail.next=head1;
			outputTail=head1;
			head1=head1.next;
		}
		while(head2!=null)
		{
			outputTail.next=head2;
			outputTail=head2;
			head2=head2.next;
		}
		return outputHead;
	}
	public static<T> void main(String[] args) {
//	Node head=takeInput();
//	print(head);
//	Scanner s=new Scanner(System.in);
//	int anslen=len(head);
//	System.out.println("length of list "+anslen);
//	System.out.println("\n enter position to print");
//	int position=s.nextInt();
//	printAtI(head,position);
//	System.out.println("\n opening new node portal");
//	System.out.println("enter position ");
//	int pos=s.nextInt();
//	System.out.println("enetr data");
//	
//	int element =s.nextInt();
//	head=insertAtI(head, pos, element);
//	print(head);
//	System.out.println("deleting new element");
//	head=DeletionAtIR(head,pos+1);
//	System.out.println();
//	print(head);
//	Node mid=midPoint(head);
//	System.out.println("midpoint is"+mid.data);
//	System.out.println("\n enter element to be searched");
//	int search=s.nextInt();
//	
//	head=removeDuplicates(head);
//	print(head);
	
	LinkedListNode<Integer> head1=takeInput();
	boolean ans=isPalindrome_2(head1);
	System.out.println("ans is"+ ans);
//	Node<Integer> head2=takeInput();
//	Node<Integer> MergedAns=mergeTwoSortedll(head1, head2);
//	print(MergedAns);
//	Node<Integer> ans=midPoint(MergedAns);
//	System.out.println(ans.data);
}
}
