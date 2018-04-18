package l14;
import l12.LinkedListNode;
public class StackusingLinkedList<T>  {
	private LinkedListNode<T> head;
	private int length;
	public StackusingLinkedList() {
		head=new LinkedListNode<T>();
		length=0;
		}
	
	public void push(T string)
	{
			LinkedListNode<T> newNode=new LinkedListNode<T>(string);
			if(this.head==null)
			{
				this.head=newNode;
				this.length++;
			}
			else 
			{
				newNode.next=this.head;
				this.head=newNode;
				this.length++;
			}
		
	}
	public void  pop ()
	{
		if(this.head==null)
		{
			//TODO error
		}
		else
		{
			System.out.println(this.head.data);
			this.head=this.head.next;
			this.length--;
		}
	}
	public int size()
	{
		return this.length;
	}
	public T top()
	{
		if(this.head.next==null)
		{
			//TODO error
		}
		else 
		{	
			return this.head.data;
			
		}
		return this.head.data;
	}
	public  int len()
	{
		LinkedListNode<T> ptr=this.head;
		int count=0;
		while(ptr!=null)
		{
			count++;
			ptr=ptr.next;
		}
		return count;
		
	}
	public void print()
	{
		LinkedListNode<T> ptr=this.head;
		while(ptr.next!=null)
		{
			System.out.println(ptr.data);
			ptr=ptr.next;
		}
	}
	
}
