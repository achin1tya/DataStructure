package l15;

import java.util.ArrayList;

public class QueueUse {
//public  static ArrayList<Integer> pr()
//{
//	ArrayList<Character> ar=new ArrayList<>();
//	ar.
//	return ar;
//}
public static <T> void main(String[] args) throws QueueEmptyException {
	QueueImplementation<Integer> p=new QueueImplementation<Integer>();
	
	try
		{
			p.dequeue();
		
		}catch(QueueEmptyException e){
			System.out.println("continue but add first");
		}
	p.enqueue(15);
	p.enqueue(16);
	int data=p.dequeue();
	System.out.println(data);
	data=p.dequeue();
	System.out.println(data);
}
}
