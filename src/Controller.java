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
		List<String> categoryNames = m_model.getCategoryNames();
		
		int selection = m_view.displayCategories(categoryNames);
		
		// if they choose to exit
		if (selection == 0) {
			return;
		}
		
		// if selection is invalid
		if (selection > categoryNames.size()) {
			m_view.displayOutOfBoundsError();
			return;
		}
		
		processBookSelection(categoryNames.get(selection - 1));
	}
	
	public void processBookSelection(String categoryName)
	{
		List<Book> books = m_model.getBooks(categoryName);
		int selection = m_view.displayBooks(books);
		
		// if they choose to exit
		if (selection == 0) {
			return;
		}
		
		// if selection is invalid
		if (selection > books.size()) {
			m_view.displayOutOfBoundsError();
			return;
		}
		
		m_model.addToCart(books.get(selection - 1));
		m_view.displaySuccessfullyAdded();
	}
	
	public void processCart()
	{
		List<String> options = new ArrayList<String>();
		options.add("1. Check out");
		options.add("2. Remove item from cart");
		options.add("3. Return to main menu");
		Cart cart = m_model.getCart();
		int selection = m_view.displayCart(cart, options);
		
		switch (selection) {
		case 1: 
			// TODO: figure out what to to do next
			break;
		case 2:
			processRemoveOption();
			break;
		case 3:
			processMenu();
			break;
		}
	}
	
	public void processRemoveOption()
	{
		Cart cart = m_model.getCart();
		int selection = m_view.removeOption(cart);
		
		// if they want to cancel removal
		if (selection == 0) {
			return;
		}
		
		// if the selection is invalid
		if (selection > cart.getBooks().size()) {
			m_view.displayOutOfBoundsError();
			return;
		}
		
		m_model.removeFromCart(cart.getBooks().get(selection - 1)); 
		m_view.displaySuccessfullyAdded();
			
	}
}
