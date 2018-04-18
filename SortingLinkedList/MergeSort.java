package l13;
import java.util.concurrent.LinkedBlockingDeque;

import l12.*;

public class MergeSort extends Nodeuse{
	public static LinkedListNode<Integer> mergeSortll(Node head)
	{
		if(head==null||head.next==null)
		{
			return head;
		}

		Node mid=midPoint(head);
		Node head2=mid.next;
		mid.next=null;
		head=mergeSortll(head);
		head2=mergeSortll(head2);
		Node ansHead=mergeTwoSortedll(head, head2);
		return ansHead;
		
	}
	public static void main(String[] args) {
		Node head=takeInput();
		head=mergeSortll(head);
		print(head);
	}
}
