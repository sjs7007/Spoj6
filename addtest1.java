//addition part
//only input and sepration
import java.io.*;

class add
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
				S1=temp.substring(0,i); //i because of gorm [,)
				S2=temp.substring(i+1,temp.length());
			}
		}
		System.out.print(S1+" "+S2);
	}
}
