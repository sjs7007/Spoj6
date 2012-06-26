//addition part
//only input and sepration
// store in array s1,s2
//add s1,s2 for no carry over
import java.io.*;

class newaddtest1
{
	public static void main(String args[]) throws IOException
	{
		DataInputStream ip = new DataInputStream(System.in);
		String S1 = new String();
		String temp;
		String S2= new String();
		int i;
		System.out.print("Enter expression : ");
		temp = ip.readLine();
		for(i=0;i<temp.length();i++)
		{
			if(temp.charAt(i)=='+')
			{
				//System.out.println(temp.substring(0,i)); //i because of gorm [,)
				//System.out.println(temp.substring(i+1,temp.length()));
				S1=temp.substring(0,i); //i because of gorm [,)
				S2=temp.substring(i+1,temp.length());
			}
		}
		int a1[]= new int[100];
		int a2[]= new int[100];
		int k=0;
		for(i=S1.length()-1;i>=0;i--)
		{
			String temp2 = Character.toString(S1.charAt(i));
		    a1[99-k]= Integer.parseInt(temp2);
		    k++;
		}
		k=0;
		for(i=S2.length()-1;i>=0;i--)
		{
			String temp2 = Character.toString(S2.charAt(i));
		    a2[99-k]= Integer.parseInt(temp2);
		    k++;	
		}
		/*for(i=0;i<100;i++)
		{
			System.out.print(a1[i]);
		}
					
		for(i=0;i<100;i++)
		{
			System.out.print(a2[i]);
		}*/
		int a3[] = new int[100];
		/*if(S1.length() >= S2.length())
		{
			a3 = new int[S1.length()];
		}
		else
		{
			a3 = new int[S2.length()];
		}*/
		for(i=99;i>=0;i--)
		{
			//System.out.println(a1[i]+"   "+a2[i]);
			int temp2 = a1[i]+a2[i];
			int temp3;
			if(temp2<=9)
			{
				a3[i]=temp2;
			}
			//System.out.println("sum : "+temp2);
			
		}
		for(i=0;i<100;i++)
		{
			System.out.print(a3[i]);
		}
	}
}
