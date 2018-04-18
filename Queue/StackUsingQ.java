package l15;

import java.util.Queue;

public class StackUsingQ {
	public static void main(String[] args) throws QueueEmptyException {
		QueueImplementation<Integer> q1=new QueueImplementation<>();
		QueueImplementation<Integer> q2=new QueueImplementation<>();
		for(int i=0;i<4;i++)
		{
			q1.enqueue(i);
		}
		for(int i=0;i<4;i++)
		{
			for(int j=i-1;j>=0;j--)
			{
				q2.enqueue(q1.dequeue());
			}
			System.out.println(q1.dequeue());
			QueueImplementation<Integer> temp=q1;
			q1=q2;
			q2=temp;
		}
		
	}
}
