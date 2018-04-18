package l7;
import java.util.Scanner;
public class recpower {
	public static int powerof(int x,int n)
	{
		int ans;
		if(n==0)
		{
			ans=1;
			return ans; 
		}
		ans=x*powerof(x,n-1);
		return ans;
	}
public static void main(String[] args) {
	System.out.print("\n enter x");
	Scanner s=new Scanner(System.in);
	int x=s.nextInt();
	System.out.println("enter power");
	int pow=s.nextInt();
	int ans=powerof(x,pow);
	System.out.println("answer is"+ans);
	
	
}
}
