//multiplication part
//only input and sepration
// store in array
// mul for n1 many digits and n2 1
import java.io.*;

class multest2
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
			if(temp.charAt(i)=='*')
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
		/*
		 * write multiplication code here
		 */
		int temp3=0;
		for(i=99;i>99-S1.length();i--) //change here
		{
			int temp2=a1[i]*a2[99]+temp3;
			if (temp2<10 || i==99-S1.length()+1) //change made here so that if last result is >=10
			{										//it should be written directly
				a3[i]=temp2;
			}
			else
			{
				a3[i]=temp2%10;
				temp3=((temp2-temp2%10)/10);//unneccessary+a3[i-1];
			}
		}
		for(i=0;i<100;i++)
		{
			System.out.print(a3[i]);
		}
	}
}
