import java.io.*;
public class FileWriterDemo
{
	public static void main (String[] args)
	{
		try
		{
			FileWriter fOut = new FileWriter("HeyBuddy.txt");
			BufferedWriter buffOut = new BufferedWriter(fOut);
			buffOut.write("Hey Buddy!\n");
			buffOut.close();
		}
		catch (IOException ex)
		{
			System.err.println("An exception occured: " + ex.toString());
		}
	}
}