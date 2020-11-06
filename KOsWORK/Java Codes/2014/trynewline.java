import java.util.*;
import java.io.*;

public class trynewline {
public static void main(String[] args) throws FileNotFoundException {
	
	File file = new File("C:/Users/Me/Desktop/directory/file.txt");
	file.getParentFile().mkdirs();
	try
	{
		PrintWriter writer = new PrintWriter("the-file-name.txt");
		writer.println("The first line");
		writer.println("The second line");
		writer.close();
	}
	    catch (FileNotFoundException ex)  
    {

        // insert code to run when exception occurs
    }
}
}