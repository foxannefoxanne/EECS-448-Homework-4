import java.util.ArrayList;
import java.util.List;

public class Model 
{
	private Category sciFiBooks;
	private Category travelBooks;
	private Category computerScienceBooks;
	private Cart cart;
	
	// should we initialize the names of the categories here?
	public Model(){
		cart = new Cart();
		sciFiBooks = new Category();
		sciFiBooks.setCategoryPrice(50);
		travelBooks = new Category();
		travelBooks.setCategoryPrice(40);
		computerScienceBooks = new Category();
		computerScienceBooks.setCategoryPrice(100);
		
	}
	
	public void addToCart(Book book){
		cart.addBook(book);
	}
	
	public void removeFromCart(Book book){
		cart.removeBook(book);
	}
	
	private double getTotalPrice(){
		return cart.getTotalPrice();
	}
	
	public void addToInventory(Book book){
		String category = book.getCategory();
		switch(category){
		case "Science Fiction":
			sciFiBooks.addBook(book);
		case "Travel" :
			travelBooks.addBook(book);
		case "Computer Science":
			computerScienceBooks.addBook(book);
		}
	}
	
	// return books from all categories (i.e. all of inventory)
	public List<Book> getAllBooks() {
		return null;
	}
	
	public List<Book> getBooks(String categoryName){
		switch(categoryName){
		case "Science Fiction":
			return sciFiBooks.getBooks();
		case "Travel" :
			return travelBooks.getBooks();
		case "Computer Science":
			return computerScienceBooks.getBooks();
		default:
			return null;
		}
	}
	
	//maybe pull these names from the categories themselves?
	public List<String> getCategoryNames() {
		List<String> categoryNames =  new ArrayList<String>();
		categoryNames.add("Science Fiction");
		categoryNames.add("Travel");
		categoryNames.add("Computer Science");
		return categoryNames;
	}
	
	public Cart getCart() {
		return cart;
	}
}
