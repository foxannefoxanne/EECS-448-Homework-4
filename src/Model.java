import java.io.BufferedReader;
import java.util.List;
import java.io.IOException;
import java.io.FileReader; 

public class Model 
{
	
//	static String[] textData; 
//		
//	public void loadData(String testFile) 
//		{
//				boolean fileNotFound = true; 
//				try
//				{
//				
//				FileReader fr = new FileReader(testFile); 
//				BufferedReader textReader = new BufferedReader(fr); 
//				
//				int numberOfLines = 60; 
//				textData = new String[numberOfLines];
//				
//				for(int i = 0; i < numberOfLines; i++)
//				{	
//					fileNotFound = false; 
//					textData[i] = textReader.readLine();
//				}
//				
//				textReader.close();
//				if(fileNotFound) {
//				throw new IOException(); 
//				} 
//				} catch (IOException e) {
//					System.out.println("File not found."); 
//				}
//		}
//		
//	public void printData() 
//	{
//	
//	}
	
	private Category sciFiBooks;
	private Category travelBooks;
	private Category computerScienceBooks;
	private Cart theCart;
	
	public void addToCart(Book book){
		
	}
	
	public void removeFromCart(Book book){
		
	}
	
	// don't think we need this now since the cart updates the price as books are added/removed
	private double computeTotalPrice(){
		return 0;
		
	}
	
	public void addToInventory(Book book){
		
	}
	
	// may not actually need this?
	public void removeFromInventory(Book book){
		
	}
	
	public List<Book> getBooks(String categoryName){
		return null;
		
	}
	
	public List<String> getCategoryNames() {
		// return all model categories in a list
		return null;
	}
	
	public Cart getCart() {
		return null;
	}
}
