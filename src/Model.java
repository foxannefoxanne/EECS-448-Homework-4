import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader; 

public class Model 
{
	static String[] textData; 
		
	public void loadData(String testFile) 
		{
				boolean fileNotFound = true; 
				try
				{
				
				FileReader fr = new FileReader(testFile); 
				BufferedReader textReader = new BufferedReader(fr); 
				
				int numberOfLines = 60; 
				textData = new String[numberOfLines];
				
				for(int i = 0; i < numberOfLines; i++)
				{	
					fileNotFound = false; 
					textData[i] = textReader.readLine();
				}
				
				textReader.close();
				if(fileNotFound) {
				throw new IOException(); 
				} 
				} catch (IOException e) {
					System.out.println("File not found."); 
				}
		}
		
	public void printData() 
	{
	
	}
	
}
