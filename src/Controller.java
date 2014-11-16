import java.util.ArrayList;
import java.util.List;

public class Controller {

	private Model m_model;
	private View m_view;
	  
	public Controller(Model model, View view)
	{
		m_model = model;
		m_view = view;
	}
	
	public void control()
	{
		// start by displaying menu
		processMenu();
	}
	
	public void processMenu()
	{
		int menuSelection = 0;
		while (menuSelection != 3)
		{
			List<String> menuOptions = new ArrayList<String>();
			menuOptions.add("1. View books" );
			menuOptions.add("2. View cart");
			menuOptions.add("3. Exit");
			menuOptions.add("Please select an option: ");
			menuSelection = m_view.displayMenu(menuOptions);
			
			switch (menuSelection) {
			case 1: 
				processCategory();
				break;
			case 2:
				processCart();
				break;
			case 3:
				return;
			}
		}
	}
	
	public void processCategory()
	{
		List<String> categoryNames = m_model.getCategories();
		
		int selection = m_view.displayCategories(categoryNames);
		
		// if they choose to exit
		if (selection == 0) {
			return;
		}
		
		processBookSelection(categoryNames.get(selection - 1));
	}
	
	public void processBookSelection(String categoryName)
	{
		List<Book> books = m_model.getBooks(categoryName);
		
	}
	
	public void processCart()
	{
		
	}
	
	public void processRemoveOption()
	{
		
	}
}
