package l15;
import l12.*;
public class QueueImplementation<T>  {
	private LinkedListNode<T> front;
	private LinkedListNode<T> tail;
	public QueueImplementation() {
		front =null;
		tail=null;
	}
	public int size()
	{
		int count=0;
		LinkedListNode<T> ptr=front;
		while(ptr!=null)
		{
			ptr=ptr.next;
		}
		return count;
	}
	public boolean isEmpty()
	{
		if(front==null)
		{
			return true;
		}else
			return false;
	}
	T frontReturn() throws QueueEmptyException
	{
		if(front==null)
		{
			throw new QueueEmptyException();
		}else{
			return front.data;
		}
	}
	public void enqueue(T data)
	{
		LinkedListNode<T> newNode=new LinkedListNode<>(data);
		
		if(front==null)
		{
			front=newNode;
			tail=newNode;
		}else{
			tail.next=newNode;
			tail=newNode;
		}
	}
	public T dequeue() throws QueueEmptyException
	{
		LinkedListNode<T> newNode=front;
	
		if(front==null)
		{
			throw new QueueEmptyException();
		}else if(this.size()==1){
			front=null;
			tail=null;
		}
		else
		{
			
			
			front=front.next;
		}
		return newNode.data;
	}
};	
	

