import java.util.ArrayList;
import java.util.List;

public class Model 
{
	private Category sciFiBooks;
	private Category travelBooks;
	private Category computerScienceBooks;
	private Cart cart;
	
	public Model(){
		cart = new Cart();
		sciFiBooks = new Category();
		sciFiBooks.setName("Science Fiction");
		sciFiBooks.setCategoryPrice(50);		
		travelBooks = new Category();
		travelBooks.setName("Travel");
		travelBooks.setCategoryPrice(40);
		computerScienceBooks = new Category();
		computerScienceBooks.setName("Computer Science");
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
			break;
		case "Travel" :
			travelBooks.addBook(book);
			break;
		case "Computer Science":
			computerScienceBooks.addBook(book);
			break;
		}
	}
	
	public List<Book> getAllBooks() {
		List<Book> allBooks = new ArrayList<Book>();
		allBooks.addAll(sciFiBooks.getBooks());
		allBooks.addAll(travelBooks.getBooks());		
		allBooks.addAll(computerScienceBooks.getBooks());
		return allBooks;
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
	
	public List<String> getCategoryNames() {
		List<String> categoryNames =  new ArrayList<String>();
		categoryNames.add(sciFiBooks.getName());
		categoryNames.add(travelBooks.getName());
		categoryNames.add(computerScienceBooks.getName());
		return categoryNames;
	}
	
	public Cart getCart() {
		return cart;
	}
}
