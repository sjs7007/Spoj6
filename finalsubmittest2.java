//led to error on  spoj (maybe because of only 10000 digit nos)
//modifying it to support 10k digit nos
import java.io.*;

class finalsubmittest2
{
	public static void add(String a) throws IOException
	{
		DataInputStream ip = new DataInputStream(System.in);
		String S1 = new String();
		String temp;
		String S2= new String();
		int i;
		//System.out.print("Enter expression : ");
		//temp = ip.readLine();
		temp=a;
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
		int a1[]= new int[10000];
		int a2[]= new int[10000];
		int k=0;
		for(i=S1.length()-1;i>=0;i--)
		{
			String temp2 = Character.toString(S1.charAt(i));
		    a1[9999-k]= Integer.parseInt(temp2);
		    k++;
		}
		k=0;
		for(i=S2.length()-1;i>=0;i--)
		{
			String temp2 = Character.toString(S2.charAt(i));
		    a2[9999-k]= Integer.parseInt(temp2);
		    k++;	
		}
		int a3[] = new int[10000];
		for(i=9999;i>=0;i--)
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
		/*for(i=0;i<10000;i++)
		{
			System.out.print(a3[i]);
		}  //removed in this prog first
		System.out.println();*/ 
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
		if(a3[9999-greater]!=0)
		{
			s3=greater+1;
		}
		else
		{
			s3=greater;
		}
		int b3[] = new int[s3];
		int j=0;
		for(i=9999-S1.length()+1;i<=9999;i++)
		{
			//System.out.print("a1 : "+a1[i]+" ");
			b1[j]=a1[i];
			//System.out.print("b1 : "+b1[j]+" ");
			j++;
		}
		j=0;
		for(i=9999-S2.length()+1;i<=9999;i++)
		{
			//System.out.print("a2 : "+a2[i]+" ");
			b2[j]=a2[i];
			j++;
		}
		j=0;
		for(i=9999-s3+1;i<=9999;i++)
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
		int a1[]= new int[10000];
		int a2[]= new int[10000];
		int k=0;
		for(i=S1.length()-1;i>=0;i--)
		{
			String temp2 = Character.toString(S1.charAt(i));
		    a1[9999-k]= Integer.parseInt(temp2);
		    k++;
		}
		//extract a1 to b1 now because a1 will change for cases like 122-29
		int b1[] = new int[S1.length()];
		j=0;
		for(i=9999-S1.length()+1;i<=9999;i++)
		{
			b1[j]=a1[i];
			j++;
		}
		k=0;
		for(i=S2.length()-1;i>=0;i--)
		{
			String temp2 = Character.toString(S2.charAt(i));
		    a2[9999-k]= Integer.parseInt(temp2);
		    k++;	
		}
		int a3[] = new int[10000];
		int count=0;
		for(i=9999;i>=0;i--)
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
		/*for(i=0;i<10000;i++)
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
		if(a3[9999-smaller]!=0) //used to find length 0f s3
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
		for(i=9999-S2.length()+1;i<=9999;i++)
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
		for(i=9999-s3+1;i<=9999;i++)
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
	
	public static void mul(int[] a1 ,String S1, String S2, int[] a2 , int[][] a3,int k)
	{
		int temp3=0;
		for(int i=9999;i>9999-S1.length();i--) //change here
		{
			int temp2=a1[i]*a2[9999-k]+temp3; //9999-k to multiply with diff digits like in 45*67 first 7 , then 6
			temp3=0; //addition to correct code since it was not being set to zero it was causing errors
			if (temp2<10 || i==9999-S1.length()+1) //change made here so that if last result is >=10
			{										//it should be written directly
				a3[k][i-k]=temp2;
			}
			else
			{
				a3[k][i-k]=temp2%10; //i-k to take care of units first start from 9999 then 98 and so on
				temp3=((temp2-temp2%10)/10);
			}
		}
	}
	
	public static void mulmain (String a) throws IOException
	{
		DataInputStream ip = new DataInputStream(System.in);
		String S1 = new String();
		String temp;
		String S2= new String();
		int i,temp4=0,lengthcount=0;
		int lnos[] = new int[10000];
		//System.out.print("Enter expression : ");
		//temp = ip.readLine();
		temp=a;
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
		int a1[]= new int[10000];
		int a2[]= new int[10000];
		int k=0;
		for(i=S1.length()-1;i>=0;i--)
		{
			String temp2 = Character.toString(S1.charAt(i));
		    a1[9999-k]= Integer.parseInt(temp2);
		    k++;
		}
		k=0;
		for(i=S2.length()-1;i>=0;i--)
		{
			String temp2 = Character.toString(S2.charAt(i));
		    a2[9999-k]= Integer.parseInt(temp2);
		    k++;	
		}
		//int a3[] = new int[10000];
		/*
		 * write multiplication code here
		 */
	/* Method for n1=ndigit and n2 = 1 digit starts
		int temp3=0;
		for(i=9999;i>=9999-S1.length();i--)
		{
			int temp2=a1[i]*a2[9999]+temp3;
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
		* 2nd should begin from 9999-1
		* 3rd from 9999-2 and so on
		* this will take care of the units
		*/
		int a3[][]= new int[10000][10000];
		for(k=0;k<S2.length();k++)
		{
			mul(a1,S1,S2,a2,a3,k);
		}
		/*for(i=0;i<10000;i++)
		{
			System.out.print(a3[0][i]);
		}
		System.out.println();
		for(i=0;i<10000;i++)
		{
			System.out.print(a3[1][i]);
		}*/
		/*for(i=0;i<S2.length();i++)		removed in functionmultest
		{
			for(int j=0;j<10000;j++)
			{
				System.out.print(a3[i][j]);
			}
			System.out.println();
		}*/
		int a4[]= new int[10000];
		/*for(k=0;k<=9999;k++)
		{
			int temp2;
			for(i=0;i<S2.length();i++)
			{
				a4[9999-k] = a4[9999-k] + a3[i][9999-k];  used to add corresponding values of a3[i][j]
				* 									modify it to work when sum is >=10
			}
		}*/ 
		for(k=0;k<=9999;k++)
		{
			int temp2;
			for(i=0;i<S2.length();i++)
			{
				temp2 = a4[9999-k] + a3[i][9999-k]; 
				 if(temp2<10)
				 {
					 a4[9999-k]=temp2;
				 }
				 else
				 {
					 a4[9999-k]=temp2%10;
					 a4[9999-k-1]=((temp2-a4[9999-k])/10)+a4[9999-k-1];
				 }
			}
		}
		/*for(i=0;i<10000;i++)
		{
			System.out.print(a4[i]);
		}		removed in functionmultest
		System.out.println();*/
		//extract from all and store in corresponding b arrays
		//and print
		int j,start;
		start=0;
		for(i=0;i<10000;i++)
		{
			if(a1[i]!=0)
			{
				start=i;
				break;
			}
		}
		int b1[] = new int[S1.length()];
		j=0;
		for(i=start;i<10000;i++)
		{
			b1[j]=a1[i];
			j++;
		}
		//print l(ans)-s1 spaces then b1
		int lans=0;
		for(i=0;i<10000;i++)
		{
			if(a4[i]!=0)
			{
				lans=9999-i+1;
				break;
			}
		}
		for(i=1;i<=lans-S1.length();i++)
		{
			System.out.print(" ");
		}
		for(i=0;i<S1.length();i++)
		{
			System.out.print(b1[i]);
		}
		System.out.println();
		
		start=0;
		for(i=0;i<10000;i++)
		{
			if(a2[i]!=0)
			{
				start=i;
				break;
			}
		}
		int b2[] = new int[S2.length()];
		j=0;
		for(i=start;i<10000;i++)
		{
			b2[j]=a2[i];
			j++;
		}
		//print lans-s2-1 spaces then * then b2
		for(i=1;i<=lans-S2.length()-1;i++)
		{
			System.out.print(" ");
		}
		System.out.print("*");
		for(i=0;i<S2.length();i++)
		{
			System.out.print(b2[i]);
		}
		System.out.println();
		//print dashes, no of dashes = max of(s1,(s2+1 , because of *),length of 1st result)
		//before that print lans-max spaces
		int lfirst=0;
		for(j=0;j<=9999;j++)
		{
			if(a3[0][j]!=0)
			{
				lfirst=9999-j+1;
				break;
			}
		}
		int max=S1.length();
		int find[]=new int[2];
		find[0]=S2.length()+1;//change made here in finalsumbittest1
		find[1]=lfirst+1;
		for(i=0;i<=1;i++)
		{
			if(max<find[i])
			{
				max=find[i];
			}
		}
		for(i=1;i<=lans-max;i++)
		{
			System.out.print(" ");
		}
		for(i=1;i<=max;i++)
		{
			System.out.print("-");
		}
		System.out.println();
		//now extract other results
		//but how to store as each multiplication result will be of diff length
		//so just print it
		//but before that print (lans-mul result) spaces
		int end=0;
		int lresult=0;
		for(i=0;i<S2.length();i++)
		{
			start=0;
			end=0;
			for( j=0;j<10000;j++)
			{
				if(a3[i][j]!=0)
				{
					start=j;
					break;
				}
			}
			/*for( j=9999;j>=0;j--)
			{
				if(a3[i][j]!=0)
				{
					end=j;
					break;
				}
			}*/
			if(a3[i][start]!=0)   //checking if nos. is zero , if zero then keeping end ,lresult same as prev
			{					 	//we will then dec no. of spaces to one less than earlier number and print 0
				end=9999;
				lresult=end-start+1;
			}
			int temp5=lans-lresult;     
			if(start==0 && end==0 && start>end-i)
			{
				temp4++;
				temp5=temp5-temp4;
				temp5=temp5+lnos[lengthcount-1]+1;
			}
			for( k=1;k<temp5;k++)
			{
				System.out.print(" ");
			}
			if(start==0 && end==0 && start>end-i)
			{	
				System.out.print("0");
			}
			for(j=start;j<=end-i;j++)  //end-i so that the following zeros get removed
			{
				lnos[lengthcount]=end-i-start;
				if(a3[i][start]==0)
				{
					System.out.print("0");
					break;
				}
				else
				{	
					System.out.print(a3[i][j]);
				}
			}
			if(start<=end-i)
			{	
				lengthcount++;
			}
			
			System.out.println();
		}
		//print lans dashes and below if S2.length!=1
		if(S2.length()!=1)
		{
			for(k=1;k<=lans;k++)
			{
				System.out.print("-");
			}
			System.out.println();
			//now print final multiplication result
			for(i=0;i<10000;i++)
			{
				if(a4[i]!=0)
				{
					start=i;
					break;
				}
			}
			for(i=start;i<10000;i++)
			{
				System.out.print(a4[i]);
			}
		}
	}
	
	public static void main(String args[]) throws IOException
	{
		DataInputStream ip = new DataInputStream(System.in);
		int T=0;
		T=Integer.parseInt(ip.readLine());
		for(int k=1;k<=T;k++)
		{
			String temp = new String(ip.readLine());
			for(int i=0;i<temp.length();i++)
			{
				if(temp.charAt(i)=='+')
				{
					add(temp);
					break;
				}
			
				else if(temp.charAt(i)=='-')
				{
					sub(temp);
					break;
				}
			
				else if(temp.charAt(i)=='*')
				{
					mulmain(temp);
					break;
				}
			}	
			System.out.println();
			System.out.println();
		}	
	}
}
