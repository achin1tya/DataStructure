package l8;

import java.util.Scanner;

public class recTowerOfHanoi {



	public static int towerOfHanoi(int disks, char source, char auxiliary, char destination) {
		// Write your code here
		int count=0;
		if(disks==0)
		{
		    return count;
		}
		if(disks==1)
		{
			count=count+towerOfHanoi(1,source,auxiliary,destination);
	        count++;
	        return count;
		}
        
        count=count+towerOfHanoi(disks-1,source,destination,auxiliary);
        count++;
       
        count=count+towerOfHanoi(disks-1,auxiliary,source,destination);
        count++;
        return count;
	}
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("\n enter no of disks");
		int disks=s.nextInt();
		int ans=towerOfHanoi(disks, );
		
	}
}

