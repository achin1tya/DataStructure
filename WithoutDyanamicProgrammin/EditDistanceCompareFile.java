package l21;

import java.util.Scanner;

public class EditDistanceCompareFile {
public static int editDis(String s1,String s2)
{
	if(s1.length()==0&&s2.length()!=0)
	{
		return s2.length();
	}
	if(s2.length()==0&&s1.length()!=0)
	{
		return s1.length();
	}
	if(s2.length()==0&&s1.length()==0)
		return 0;
	//deletion
	if(s1.charAt(0)==s2.charAt(0))
	{
		return editDis(s1.substring(1), s2.substring(1));
	}
	int answer1=1+editDis(s1.substring(1), s2);
	//insertion
	int answer2=1+editDis(s1,s2.substring(1));
	//substitute
	int answer3=1+editDis(s1.substring(1), s2.substring(1));
	return Math.min(Math.min(answer1,answer2),answer3);
	
}

public static int editDisHelper(String s1,String s2,int[][] arr)
{
	int len1=s1.length();
	int len2=s2.length();
	if(s1.length()==0&&s2.length()==0)
	{
		return 0;
	}
	if(s1.length()==0&&s2.length()!=0)
	{
		arr[len1][len2]=s2.length();
		return s2.length();
	}
	if(s2.length()==0&&s1.length()!=0)
	{
		arr[len1][len2]=s1.length();
	}
	if(s1.charAt(0)==s2.charAt(0))
	{
		if(arr[len1][len2]!=-1){
		arr[len1][len2]=editDis(s1.substring(1), s2.substring(1));
		
		}
		return arr[len1][len2];
		
	}
	
	if(arr[len1][len2]==-1)
	{
		int answer1=1+editDis(s1, s2);
		int answer2=1+editDis(s1.substring(1), s2);
		int answer3=1+editDis(s1, s2.substring(1));
		arr[len1][len2]=Math.min(Math.min(answer1,answer2),answer3);
	}
	return arr[len1][len2];
	
}

//
public static int iterativeEditDistance(String s1,String s2)
{
	int arr[][]=new int[s1.length()+1][s2.length()+1];
	for(int i=0;i<s1.length();i++)
	{
		for(int j=0;j<s2.length();j++)
		{
			arr[i][j]=-1;
		}
	}
	if(s1.length()==0&&s2.length()==0)
	{
		return 0;
	}
	for(int i=1;i<=s1.length();i++)
	{
		for(int j=1;j<=s2.length();j++)
		{
			//deletion
			if(s1.charAt(s1.length()-i)==s2.charAt(s2.length()-j))
			{
				arr[i][j]=1+arr[i-1][j-1];
			}
			else if(s2.length()!=s1.length())
			{
				//insertion
				arr[i][j]=1+arr[i][j-1];
						
			}
			else if(s2.length()==s1.length())
			{
				//substitution
				arr[i][j]=1+arr[i-1][j];
			}
		}
		
	}
	return arr[s1.length()][s2.length()];
}
public static void main(String[] args) {
	System.out.println("\ne nter two string");
	Scanner s=new Scanner(System.in);
	String s1=s.next();
	String s2=s.next();
	int answer=editDis(s1, s2);
	System.out.println("answer for minimum operations"+answer+"\n");
	int answer2=iterativeEditDistance(s1, s2);
	System.out.println("answer for minimum operations iterative"+answer2 );

}
}
