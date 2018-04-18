package l8;

public class returnCodes {
	
	    public static String[] printCodes(String s,String output){
			
			if(s.length()==0){
			    String ans[]=new String[1];
				ans[0]=output;
				return ans;
			}
		    String ans[],ans1[];
			String s1=s.substring(0,1);
			int n1=Integer.parseInt(s1);
			if(n1!=0){
				char c = (char)('a'+n1-1);
				 ans=printCodes(s.substring(1),output+c);
			}
			if(s.length()<=1)
				return new String[0];
			String s2=s.substring(0,2);
			int n2=Integer.parseInt(s2);
			if(n2<=26){
				char c = (char)('a'+n2-1);
			 ans1=printCodes(s.substring(2),output+c);
			}
			String answer[]=new String[ans.length+ans1.length];
			for(int i=0;i<ans.length;i++)
			{
			    answer[i]=ans[i];
			}
			for(int j=0;j<ans1.length;j++)
			{
			    answer[j+ans.length]=ans1[j];
			}
			return answer;
		
		}


		// Return a string array that contains all possible codes
		public static  String[] getCode(String input){
			// Write your code here
			String ans[]=printCodes(String input,"");
			return ans;
			
		}

	

}
