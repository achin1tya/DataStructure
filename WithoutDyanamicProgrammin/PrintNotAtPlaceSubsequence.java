package l21;

public class PrintNotAtPlaceSubsequence {
public static void printSubsequence(String arr,char a[],int index)
{
	if(index==arr.length())
	{
		int i=0;
		while(i<a.length)
		{
			System.out.print(a[i]);
		}
		return ;
	}
	int j=0;
	char input[]=a;
	
	while(j<arr.length())
	{
		int i=0;
		while(i<arr.length())
		{
			if(i!=index)
			{
				input[i]=arr.charAt(j);
				printSubsequence(arr, input, index+1);
			}
		}
	}
}
}
