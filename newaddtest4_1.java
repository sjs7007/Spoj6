//addition part
//only input and sepration
// store in array
//format o/p in correct way
import java.io.*;

class newaddtest4_1
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
		int a3[] = new int[100];
		for(i=99;i>=0;i--)
		{
			int temp2 = a1[i]+a2[i]+a3[i];  //correction in addition algo
			if((temp2<=9))
			{
				a3[i]=temp2;
			}
			else
			{
				a3[i]=temp2%10;
				a3[i-1]=a3[i-1]+((temp2-temp2%10)/10);
			}	
		}
		for(i=0;i<100;i++)
		{
			System.out.print(a3[i]);
		}
		System.out.println();
		//next write code to format a1,a2 ,a3 in correct way and print it
		//int b1[],b2[],b3[];
		int b1[] = new int[S1.length()];
		int b2[] = new int [S2.length()];
		int s3;
		int greater;
		if(S1.length()>S2.length())
		{
			greater=S1.length();
		}
		else
		{
			greater=S2.length();
		}
		if(a3[99-greater]!=0)
		{
			s3=greater+1;
		}
		else
		{
			s3=greater;
		}
		int b3[] = new int[s3];
		int j=0;
		for(i=99-S1.length()+1;i<=99;i++)
		{
			//System.out.print("a1 : "+a1[i]+" ");
			b1[j]=a1[i];
			//System.out.print("b1 : "+b1[j]+" ");
			j++;
		}
		j=0;
		for(i=99-S2.length()+1;i<=99;i++)
		{
			//System.out.print("a2 : "+a2[i]+" ");
			b2[j]=a2[i];
			j++;
		}
		j=0;
		for(i=99-s3+1;i<=99;i++)
		{
			b3[j]=a3[i];
			j++;
		}
		//System.out.println("diff : "+(s3-S1.length()));
		for(i=1;i<=s3-S1.length()+1;i++)
			{
				System.out.print(" ");
			}
		for(i=0;i<S1.length();i++)
		{
			
			System.out.print(b1[i]); //b1
		}
		System.out.println();
		for(i=1;i<=s3-S2.length();i++)
		{
			System.out.print(" ");
		}
		System.out.print("+");
		for(i=0;i<S2.length();i++)
		{			
			System.out.print(b2[i]); //b2
		}
		System.out.println();
		for(i=1;i<=s3+1;i++)
		{
			System.out.print("-");
		}
		System.out.println();
		System.out.print(" ");
		for(i=0;i<s3;i++)
		{
			System.out.print(b3[i]); //b3
		}
	}
}
