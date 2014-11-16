import java.util.List;

public class Cart {

	private List<Book> bookList;
	private double totalPrice;
	
	// default constructor
	public Cart() 
	{
		totalPrice = 0;
	}
	
	public List<Book> getBooks(){
		return bookList;
	}
	
	public void addBook(Book book){
		bookList.add(book);
		totalPrice += book.getPrice();
	}
}
