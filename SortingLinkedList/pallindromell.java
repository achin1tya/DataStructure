package l13;
import l12.*;
public class pallindromell extends Nodeuse{
	  public static Node mid(Node head)
	    {
			Node ptr,fastptr;
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
		public static boolean isPalindrome_2(Node head) {
		  
			Node mid=mid(head);
		  
		 Node temp,prev,current,head2;
		  head2=mid.next;
		  mid.next=null;
		  prev=null;
			current=head;

			while(current!=null)
			{
			    temp=current.next;
			    current.next=prev;
			   prev=current;
			    current=temp;
			}
			System.out.println(prev.data);
		  
		  Node ptr1,ptr2;
		  ptr1=prev;
		  ptr2=head2;
		  while(ptr1.data==ptr2.data&&ptr1.next!=null)
		  {
			  System.out.println("ptr1"+ptr1.data+"\n ptr 2"+ptr2.data);
		      ptr1=ptr1.next;
		      ptr2=ptr2.next;
		     
		  }
//	 	  head=null;
//	 	  current=prev;
//	 	  while(current!=null)
//	 	  {
//	 	      temp=current.next;
//	 	      current.next=head;
//	 	      head=current;
//	 	      current=temp;
//	 	  }
//	 	  mid.next=temp1;
		  if(ptr1.data==head.data)
		  {
		      return true;
		  }
		  else 
		     return false;
	}
		public static void main(String[] args) {
			Node head=takeInput();
			boolean ans=isPalindrome_2(head);
			System.out.println(ans);
		}
}
