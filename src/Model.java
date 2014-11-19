/*
 * EECS 448
 * HW 4
 * 2014.11.19
 * Lynne Lammers, Christine Perinchery, Roxanne Calderon
 * Model.java
 */

import java.util.ArrayList;
import java.util.List;

public class Model 
{
	private Category sciFiBooks;
	private Category travelBooks;
	private Category computerScienceBooks;
	private Cart cart;
	
	/*
	 * Constructor
	 */
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
	
	/*
	 * Adds book to cart
	 * @param book: Book to add to cart
	 */
	public void addToCart(Book book){
		cart.addBook(book);
	}
	
	/*
	 * Removes book from cart
	 * @param book: Book to remove from cart
	 */
	public void removeFromCart(Book book){
		cart.removeBook(book);
	}
	
	/*
	 * Gets price of cart
	 * @return: price
	 */
	private double getTotalPrice(){
		return cart.getTotalPrice();
	}
	
	/*
	 * Adds book to inventory based on its category
	 * @param book: Book to add to inventory
	 */
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
	
	/*
	 * Gets all books in inventory
	 * @return: list of books
	 */
	public List<Book> getAllBooks() {
		List<Book> allBooks = new ArrayList<Book>();
		allBooks.addAll(sciFiBooks.getBooks());
		allBooks.addAll(travelBooks.getBooks());		
		allBooks.addAll(computerScienceBooks.getBooks());
		return allBooks;
	}
	
	/*
	 * Gets books for a specified category
	 * @param categoryName: Category to get books from
	 * @return: list of books
	 */
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
	
	/*
	 * Gets names of categories in inventory
	 * @return: list of category names
	 */
	public List<String> getCategoryNames() {
		List<String> categoryNames =  new ArrayList<String>();
		categoryNames.add(sciFiBooks.getName());
		categoryNames.add(travelBooks.getName());
		categoryNames.add(computerScienceBooks.getName());
		return categoryNames;
	}
	
	/*
	 * Gets user's cart
	 * @return cart
	 */
	public Cart getCart() {
		return cart;
	}
}
