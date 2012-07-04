//multiplication part
//only input and sepration
// store in array
// mul for n1 many digits and n2 1
//now extending for n2 - ndigit
//all multiplic results stored in arrays
//using multest3_1 from spoj6 as start
//working big multiplication
import java.io.*;

class multest4
{
	public static void mul(int[] a1 ,String S1, String S2, int[] a2 , int[][] a3,int k)
	{
		int temp3=0;
		for(int i=99;i>99-S1.length();i--) //change here
		{
			int temp2=a1[i]*a2[99-k]+temp3; //99-k to multiply with diff digits like in 45*67 first 7 , then 6
			temp3=0; //addition to correct code since it was not being set to zero it was causing errors
			if (temp2<10 || i==99-S1.length()+1) //change made here so that if last result is >=10
			{										//it should be written directly
				a3[k][i-k]=temp2;
			}
			else
			{
				a3[k][i-k]=temp2%10; //i-k to take care of units first start from 99 then 98 and so on
				temp3=((temp2-temp2%10)/10);
			}
		}
	}
	
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
		//int a3[] = new int[100];
		/*
		 * write multiplication code here
		 */
	/* Method for n1=ndigit and n2 = 1 digit starts
		int temp3=0;
		for(i=99;i>=99-S1.length();i--)
		{
			int temp2=a1[i]*a2[99]+temp3;
			if (temp2<10)
			{
				a3[i]=temp2;
			}
			else
			{
				a3[i]=temp2%10;
				temp3=((temp2-temp2%10)/10)+a3[i-1];
			}
		}
		* Method ends
		* 
		* Now extend this for n2=ndigit in following
		* create multiple arrays for each result of multiplication
		* but 1st array should directly start
		* 2nd should begin from 99-1
		* 3rd from 99-2 and so on
		* this will take care of the units
		*/
		int a3[][]= new int[100][100];
		for(k=0;k<S2.length();k++)
		{
			mul(a1,S1,S2,a2,a3,k);
		}
		/*for(i=0;i<100;i++)
		{
			System.out.print(a3[0][i]);
		}
		System.out.println();
		for(i=0;i<100;i++)
		{
			System.out.print(a3[1][i]);
		}*/
		for(i=0;i<S2.length();i++)
		{
			for(int j=0;j<100;j++)
			{
				System.out.print(a3[i][j]);
			}
			System.out.println();
		}
		int a4[]= new int[100];
		/*for(k=0;k<=99;k++)
		{
			int temp2;
			for(i=0;i<S2.length();i++)
			{
				a4[99-k] = a4[99-k] + a3[i][99-k];  used to add corresponding values of a3[i][j]
				* 									modify it to work when sum is >=10
			}
		}*/ 
		for(k=0;k<=99;k++)
		{
			int temp2;
			for(i=0;i<S2.length();i++)
			{
				temp2 = a4[99-k] + a3[i][99-k]; 
				 if(temp2<10)
				 {
					 a4[99-k]=temp2;
				 }
				 else
				 {
					 a4[99-k]=temp2%10;
					 a4[99-k-1]=((temp2-a4[99-k])/10)+a4[99-k-1];
				 }
			}
		}
		for(i=0;i<100;i++)
		{
			System.out.print(a4[i]);
		}
		System.out.println();
		//extract from all and store in corresponding b arrays
		int j,start;
		start=0;
		for(i=0;i<100;i++)
		{
			if(a1[i]!=0)
			{
				start=i;
				break;
			}
		}
		int b1[] = new int[S1.length()];
		j=0;
		for(i=start;i<100;i++)
		{
			b1[j]=a1[i];
			j++;
		}
		for(i=0;i<S1.length();i++)
		{
			System.out.print(b1[i]);
		}
		System.out.println();
		
		start=0;
		for(i=0;i<100;i++)
		{
			if(a2[i]!=0)
			{
				start=i;
				break;
			}
		}
		int b2[] = new int[S2.length()];
		j=0;
		for(i=start;i<100;i++)
		{
			b2[j]=a2[i];
			j++;
		}
		for(i=0;i<S2.length();i++)
		{
			System.out.print(b2[i]);
		}
		System.out.println();
		//now extract other results
		//but how to store as each multiplication result will be of diff length
		//so just print it
		int end=0;
		for(i=0;i<S2.length();i++)
		{
			start=0;
			end=0;
			for( j=0;j<100;j++)
			{
				if(a3[i][j]!=0)
				{
					start=j;
					break;
				}
			}
			for( j=99;j>=0;j--)
			{
				if(a3[i][j]!=0)
				{
					end=j;
					break;
				}
			}
			for(j=start;j<=end;j++)
			{
				System.out.print(a3[i][j]);
			}
			System.out.println();
		}
		//now print final multiplication result
		for(i=0;i<100;i++)
		{
			if(a4[i]!=0)
			{
				start=i;
				break;
			}
		}
		for(i=start;i<100;i++)
		{
			System.out.print(a4[i]);
		}

	}
}

