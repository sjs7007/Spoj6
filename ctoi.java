//char to int

class ctoi
{
	public static void main(String args[])
	{
		String S = new String("456");
		String temp = Character.toString(S.charAt(0));
		int i = Integer.parseInt(temp);
	}
}
