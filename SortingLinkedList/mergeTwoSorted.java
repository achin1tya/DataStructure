package l13;
import l12.*;

public class mergeTwoSorted extends Nodeuse {
	
	public static  Node mergeTwoSortedll(Node head1,Node head2)
	{
		Node<Integer> outputHead;
		Node<Integer> outputTail;
		int h1data=(int) head1.data;
		int h2data=(int) head2.data;
		if(head1==null&&head2!=null)
		{
			return head2;
		}
		else if(head2==null&&head1!=null)
		{
			return head1;
		}
		if(h1data>=h2data)
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
			if(h1data>=h2data)
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
	public static <T> void main(String[] args) {
		Node<T> head1=(Node<T>) takeInput();
		Node<T> head2=(Node<T>) takeInput();
		Node<T> ans=mergeTwoSortedll(head1, head2);
		print(ans);
	}
	
}
