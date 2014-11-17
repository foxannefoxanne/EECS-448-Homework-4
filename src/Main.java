import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
	public static void main (String[] args) 
	{ 
		Model bookStoreModel = new Model();
		try {
			fileRead(bookStoreModel, "scifi.txt", "Science Fiction", 50);
			fileRead(bookStoreModel, "travelbooks.txt", "Travel", 40);
			fileRead(bookStoreModel, "softwarebooks.txt", "Computer Science", 100);
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
		}
		
		View bookStoreView = new View();
		
        Controller bookStoreController = new Controller(bookStoreModel, bookStoreView);
        bookStoreController.control();
	}
	
	public static void fileRead(Model model, String filePath, String category, double price) throws IOException
	{
		FileReader fin = new FileReader(filePath);
		BufferedReader reader = new BufferedReader(fin);
		
		String line = null;
		while ((line = reader.readLine()) != null) {
			Book bookToEnter = new Book();
			
			// get author
			line = reader.readLine();
			bookToEnter.setAuthor(line);
			
			// get title
			line = reader.readLine();
			bookToEnter.setTitle(line);
			
			// set other fields
			bookToEnter.setCategory(category);
			bookToEnter.setPrice(price);
			
			// add book to inventory
			model.addToInventory(bookToEnter);
		}
		
		reader.close();
		fin.close();
		
	}
}


