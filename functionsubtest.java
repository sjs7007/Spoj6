//subtracion part
//only input and sepration
// store in array
//works for all
//store result in array
//now format in form of o/p
import java.io.*;

class functionsubtest
{
	public static void sub(String a) throws IOException
	{
		DataInputStream ip = new DataInputStream(System.in);
		String S1 = new String();
		String temp;
		String S2= new String();
		int i,j;
		//System.out.print("Enter expression : ");
		//temp = ip.readLine();
		temp=a;
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
		//extract a1 to b1 now because a1 will change for cases like 122-29
		int b1[] = new int[S1.length()];
		j=0;
		for(i=99-S1.length()+1;i<=99;i++)
		{
			b1[j]=a1[i];
			j++;
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
				for(j=i-1;j>=0;j--)
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
		/*for(i=0;i<100;i++)
		{
			System.out.print(a3[i]);
		} 	removed in functionsubtest
		System.out.println();*/
		
		//next write code to format a1,a2 ,a3 in correct way and print it
		//int b1[],b2[],b3[];
		int b2[] = new int [S2.length()];
		int s3;
		int smaller;
		if(S1.length()<S2.length())
		{
			smaller=S1.length();
		}
		else
		{
			
			smaller=S2.length();
		}
		if(a3[99-smaller]!=0) //used to find length 0f s3
		{
			s3=smaller-1;
		}
		else
		{
			s3=smaller;
		}
		int b3[] = new int[s3];
		j=0;
		//print 1 space,s1
		System.out.print(" ");
		for(i=0;i<S1.length();i++)
		{
			System.out.print(b1[i]);
		}
		for(i=99-S2.length()+1;i<=99;i++)
		{
			b2[j]=a2[i];
			j++;
		}
		System.out.println();
		//print (s1-s2) space ,-
		for(i=1;i<=S1.length()-S2.length();i++)
		{
			System.out.print(" ");
		}
		System.out.print("-");
		for(i=0;i<S2.length();i++)
		{
			System.out.print(b2[i]);
		}
		System.out.println();
		j=0;
		for(i=99-s3+1;i<=99;i++)
		{
			b3[j]=a3[i];
			j++;
		}
		//print s1+1 dashes
		for(i=1;i<=S1.length()+1;i++)
		{
			System.out.print("-");
		}
		System.out.println();
		//print(s1+1-s3) space then s3
		for(i=1;i<=S1.length()+1-s3;i++)
		{
			System.out.print(" ");
		}
		for(i=0;i<s3;i++)
		{
			System.out.print(b3[i]);
		}
	}
	
	public static void main(String args[]) throws IOException
	{
		DataInputStream ip = new DataInputStream(System.in);
		String temp = new String(ip.readLine());
		sub(temp);
	}
}

