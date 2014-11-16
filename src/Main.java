


public class Main {
	public static void main (String[] args) 
	{ 
		
		Model bookStoreModel = new Model();
		fileRead(bookStoreModel);
		
		View bookStoreView = new View();
		
        Controller bookStoreController = new Controller(bookStoreModel, bookStoreView);
        bookStoreController.control();
       
	}
	
	public static void fileRead(Model model)
	{
		// Do file reading shit here
	}
}


