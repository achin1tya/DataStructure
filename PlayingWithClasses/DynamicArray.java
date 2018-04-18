package l10;

public class DynamicArray {
	int nextIndex;
	int data[];
	public DynamicArray()		//initialize
	{
		nextIndex=0;
		data=new int[5];
	}
	public boolean isEmpty()
	{
		if(size()==0)
		{
			return true;
		}
		else 
			return false;
	}
	public int size()
	{
			return nextIndex;
	}
	public int removelast()
	{
		if(isEmpty())
		{
			return -1;
		}
		int value=data[nextIndex-1];
		nextIndex--;
		return value;
	}
	private void restructure()
	{
		int temp[]=data;
		data=new int[data.length*2];
		for(int i=0;i<temp.length;i++)
		{
			data[i]=temp[i];
		}
	}
	public  void add(int index,int element)
	{
		if(nextIndex==index)
		{
			restructure();
		}
		else if(nextIndex<index)
		{
			return;
		}
		
		
			data[nextIndex]=element;
			nextIndex++;
		
	}
	public void set(int index,int element)
	{
		if(nextIndex<index)
		{
			//TODO error out;
			return;
		}
		else if(nextIndex==index)
		{
			add(index,element);
		}
		else if(nextIndex>index)
		{
			data[index]=element;
		}
	}
	public void addInBetween0(int nonZeroIndex,int element)
	{
		if(nonZeroIndex>this.size())
		{
			restructure();
		}
		else 
		{
			int temp=data.length-1;
			while(temp<nonZeroIndex)
			{
				data[temp]=0;
				temp++;
			}
			data[temp]=element;
		}
	}
	public int  get(int index)
	{
		if(index>=nextIndex)
		{
			return -1 ;
		}
		else
			return data[index];
	}
	
	
	
	public static void main(String[] args) {
		
		
		DynamicArray d=new DynamicArray();
		System.out.println(d.removelast());
		for(int i=0;i<10;i++)
		{
			d.add(i,i+10);
			
		}
		System.out.println("ans at 6 th index"+d.get(5));
		d.set(5, 100);
		for(int i=0;i<d.size();i++)
		{
			System.out.println("element at "+i+ "is"+d.get(i));
		}
		System.out.println("ans at 6 th index"+d.get(6));
		System.out.println("size of array"+d.size());
	}
}
