package l22;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class hasmapuse {
	

	public static void arrayIntersection(int a1[],int a2[])
	{
		
		HashMap<Character, Integer > newHash=new HashMap<Character,Integer>();
		newHash.
		int answer = -1;
		
		Map<Integer, Integer> map=new Map<Integer,Integer>();
		for(int i=0;i<a1.length;i++)
		{
			if(map.get(a1[i])!=null)
				map.add(a1[i],map.get(a1[i])+1);
			else
				map.add(a1[i],1);
		}
		for(int i=0;i<a2.length;i++)
		{
			HashSet<Integer> e=new HashSet<>();
			
			if(map.get(a2[i])!=null);
			{
				if(map.get(a2[i])==null||map.get(a2[i])==0)
				{
					continue;
				}
				System.out.println(a2[i]);
				if(map.get(a2[i])!=0)
					map.add(a2[i],map.get(a2[i])-1);
				else
					map.add(a2[i],0);
				
			}
		}
		
	}
	public static void main(String[] args) {
//		System.out.println("\n enter size of arrays");
//		Scanner s=new Scanner(System.in);
//		int size1=s.nextInt();
//		int size2=s.nextInt();
//		System.out.println("\n enter arrays to find intersection ");
		int a1[]={100,2,101};
		int a2[]={3,2,100};
//		for (int i : a1) {
//			a1[i]=s.nextInt();
//		}
//		for (int i : a2) {
//			a2[i]=s.nextInt();
//		}
		arrayIntersection(a1, a2);
		
	}


}
