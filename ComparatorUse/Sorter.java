package l23;

import l23.Teacher;

import java.util.ArrayList;
import java.util.Scanner;
public class Sorter {

	public static <T extends comparator<T>> void SortThings(T elements[])
	{
		for(int i=0;i<elements.length;i++)
		{
			for(int j=0;j<elements.length-i-1;j++)
			{
				if(elements[j].sort(elements[j+1])==-1)
				{
					T temp=elements[j];
					elements[j]=elements[j+1];
					elements[j+1]=temp;
				}
			}
		}
	}
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int no_of_teachers=s.nextInt();
		Teacher[] teach=new Teacher[no_of_teachers];
		int j=10;
		for(int i=0;i<no_of_teachers;i++)
		{
			
			teach[i]=new Teacher(j);
			j--;
		}
		SortThings(teach);
		for(int i=0;i<no_of_teachers;i++)
		{
			ArrayList<Integer> arr=new ArrayList<>();
			arr.
			System.out.println(teach[i].id);
		}
	}
}
