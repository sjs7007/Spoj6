//subtracion part
//only input and sepration
// store in array
//currently works with only 1 carry over
import java.io.*;

class subtest2
{
	public static void main(String args[]) throws IOException
	{
		DataInputStream ip = new DataInputStream(System.in);
		String S1 = new String();
		String temp;
		String S2= new String();
		int i,j;
		System.out.print("Enter expression : ");
		temp = ip.readLine();
		for(i=0;i<temp.length();i++)
		{
			if(temp.charAt(i)=='-')
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
		int count=0;
		for(i=99;i>=0;i--)
		{
			int temp2 = a1[i]-a2[i];  //subtraction
			if(temp2>=0)
			{
				a3[i]=temp2;
			}
			else
			{
				for(j=99-1;j>=0;j--)
				{
					if(a1[j]>=1)
					{
						a1[j]=a1[j]-1;
						a1[j+1]=a1[j+1]+10;
						count=j+1;
						break;
					}
				}
				
				for(j=count;j<i;j++)
				{
					if(j<i)
					{
						a1[j]=a1[j]-1;
						a1[j+1]=a1[j+1]+10;
					}
				}
				a3[i]=a1[i]-a2[i];
			}	
		}
		for(i=0;i<100;i++)
		{
			System.out.print(a3[i]);
		}
	}
}

