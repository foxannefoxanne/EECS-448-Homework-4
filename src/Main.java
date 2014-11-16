


public class Main {
	public static void main (String[] args) 
	{
		Model bookStoreModel = new Model();
		// TODO: read in each category from text file to Model's categories
		
		View bookStoreView = new View();
		
        Controller bookStoreController = new Controller(bookStoreModel, bookStoreView);
        bookStoreController.control();
	}
	
}
