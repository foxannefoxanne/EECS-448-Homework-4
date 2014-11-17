import java.util.ArrayList;
import java.util.List;

public class Controller {

	private Model m_model;
	private View m_view;

	/*
	 * Constructor
	 * @param model: model controller will connect with
	 * @param view: view controller will connect with
	 */
	public Controller(Model model, View view)
	{
		m_model = model;
		m_view = view;
	}
	
	/*
	 * Starting point for controller
	 */
	public void control()
	{
		// start by displaying menu
		m_view.welcomeMessage();
		processMenu();
	}
	
	/*
	 * Tells view to display menu and processes menu selection
	 */
	public void processMenu()
	{
		int menuSelection = 0;
		// menu will redisplay until check out is complete or user selects exit
		while (menuSelection != 4) {
			List<String> menuOptions = new ArrayList<String>();
			menuOptions.add("1. View all books");
			menuOptions.add("2. View books by category");
			menuOptions.add("3. View cart");
			menuOptions.add("4. Exit");
			menuOptions.add("Please select an option: ");
			menuSelection = m_view.displayMenu(menuOptions);
			
			switch (menuSelection) {
			case 1:
				processAllBooks();
				break;
			case 2: 
				processCategory();
				break;
			case 3:
				if (processCart()) {
					// done with menu, exit
					menuSelection = 4;
				}
				break;
			case 4:
				break;
			default:
				m_view.displayInvalidSelection();
			}
		}
	}
	
	/*
	 * Gets categories from model, tells view to display categories,
	 * and processes category selection
	 */
	public void processCategory()
	{
		List<String> categoryNames = m_model.getCategoryNames();
		
		int selection = m_view.displayCategories(categoryNames);

		// if selection is invalid
		if ((selection > categoryNames.size()) || (selection < 0)) {
			m_view.displayInvalidSelection();
			processCategory();
			return;
		}
		
		// if they choose to exit
		if (selection == 0) {
			return;
		}
		
		processBookSelection(categoryNames.get(selection - 1));
	}
	
	/*
	 * Gets all books from model, tells view to display books,
	 * and processes book selection
	 */
	public void processAllBooks() 
	{
		List<Book> books = m_model.getAllBooks();
		int selection = m_view.displayBooks(books);
		
		// if selection is invalid
		if ((selection > books.size()) || (selection < 0)) {
			m_view.displayInvalidSelection();
			processAllBooks();
			return;
		}
		
		// if they choose to exit
		if (selection == 0) {
			return;
		}
		
		m_model.addToCart(books.get(selection - 1));
		m_view.displaySuccessfullyAdded();
	}
	
	/*
	 * Gets books of specified category from model, passes
	 * them to viewer, and processes user selection
	 */
	public void processBookSelection(String categoryName)
	{
		List<Book> books = m_model.getBooks(categoryName);
		int selection = m_view.displayBooks(books);

		// if selection is invalid
		if ((selection > books.size()) || (selection < 0)) {
			m_view.displayInvalidSelection();
			processBookSelection(categoryName);
			return;
		}
		
		// if they choose to exit
		if (selection == 0) {
			return;
		}
		
		m_model.addToCart(books.get(selection - 1));
		m_view.displaySuccessfullyAdded();
	}
	
	/*
	 * Gets cart from model, passes it to viewer,
	 * and processes cart selection
	 * @return: True if check out is complete, false if check out not complete
	 */
	public boolean processCart()
	{
		List<String> options = new ArrayList<String>();
		options.add("1. Check out");
		options.add("2. Remove item from cart");
		options.add("3. Return to main menu");
		Cart cart = m_model.getCart();
		int selection = m_view.displayCart(cart, options);
		
		switch (selection) {
		case 1: 
			m_view.displayCheckOutMessage();
			return true;
		case 2:
			processRemoveOption();
			return false;
		case 3:
			processMenu();
			return false;
		default:
			m_view.displayInvalidSelection();
			return(processCart());
		}
	}
	
	/*
	 * Gets cart from model, passes it to viewer, and 
	 * processes removal selection
	 */
	public void processRemoveOption()
	{
		Cart cart = m_model.getCart();
		int selection = m_view.removeOption(cart);
	
		// if the selection is invalid, 
		if ((selection > cart.getBooks().size()) || selection < 0) {
			m_view.displayInvalidSelection();
			processRemoveOption();
		}
		
		// if they want to cancel removal
		if (selection == 0) {
			return;
		}
		
		m_model.removeFromCart(cart.getBooks().get(selection - 1)); 
		m_view.displaySuccessfullyRemoved();
			
	}
}
