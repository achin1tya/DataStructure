package l22;
import java.util.ArrayList;

class MapNode<K,V>
{
	K key;
	V value;
	MapNode<K,V> next;
	MapNode(K key,V value)
	{
		this.key=key;
		this.value=value;
		this.next=null;
	}
	
}
public class Map<K,V> {
	int size;
	int bucketSize;
	ArrayList<MapNode<K,V>> bucketlist;
	public Map() {
		bucketlist=new ArrayList<>(11);
		bucketSize=11;
		for(int i=0;i<11;i++)
		{
			bucketlist.add( null);
		}
	
	}
	public int size()
	{
		return size;
	}
	public boolean isEmpty()
	{
		return size==0;
	}
	private int getBucketIndex(K key)
	{
		int bucketIndex=key.hashCode()%bucketSize;
		if(bucketIndex<0)
			bucketIndex+=bucketSize;
		return bucketIndex;
	}
	public void remove(K key)
	{
		int bucketIndex=getBucketIndex(key);
		MapNode<K,V> head=bucketlist.get(bucketIndex);
		MapNode<K,V> prev=null;
		while(head!=null){
			
			if(head.key.equals(key))
			{
				if(prev==null)
				{
					bucketlist.set(bucketIndex, head.next);
					size--;
					break;
				}
				prev.next=head.next;
				size--;
			}
			prev=head;
			head=head.next;
		}
		
	}
	public void add(K key,V value)
	{
		
		int bucketIndex=getBucketIndex(key);
		MapNode<K,V> head=bucketlist.get(bucketIndex);
		while(head!=null)
		{
			if(head.key==key)
			{
				head.value=value;
				break;
			}
		}
		if(head!=null)
		{
			MapNode<K,V> temp=bucketlist.get(bucketIndex);
			MapNode<K,V> newNode=new MapNode(key,value);
 			bucketlist.set(bucketIndex,newNode );
 			newNode.next=temp;
		}
		if((1.0)*bucketlist.size()/bucketSize>0.7)
		{
			rehash();
		}
		
	}
	public V get(K key)
	{
		int bucketIndex=getBucketIndex(key);
		MapNode<K,V> head=bucketlist.get(bucketIndex);
		while(head!=null)
		{
			if(head.key==key)
			{
				return head.value;
				
			}
		}
		return null;
	}
	public void rehash()
	{
		ArrayList<MapNode<K,V>> temp=bucketlist;
		bucketlist=new ArrayList<>(2*size);
		bucketSize=2*bucketSize;
		size=0;
		for (MapNode<K, V> mapNode : temp) {
				MapNode<K,V> head=mapNode;
				int index=getBucketIndex(head.key);
				while(head!=null)
				{
					bucketlist.set(index,head);
				}
		}
		
	}
	
}
