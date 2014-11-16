import java.util.List;


public class Cart {

	private List<Book> bookList;
	private double totalPrice;
	
	public List<Book> getBooks(){
		return bookList;
	}
	
	public void addBook(Book book){
		bookList.add(book);
		totalPrice += book.price;
	}
}
