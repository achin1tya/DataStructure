package l12;

public class LinkedListNode<T> {
	public T data;
	public LinkedListNode<T> next;
	public LinkedListNode()
	{
		this.next=null;
	}
	public LinkedListNode(T data2) {
		
		this.data=data2;
		this.next=null;
	}
}
