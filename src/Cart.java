import java.util.List;


public class Cart {

	private List<Book> bookList;
	private String name;
	private double categoryPrice;
	
	public String getName(){
		return name;
	}	
	public void setName(String n){
		name = n;
	}	
	public double getCategoryPrice(){
		return categoryPrice;
	}	
	public void setCategoryPrice(double c){
		categoryPrice = c;
	}	
	public List<Book> getBooks(){
		return bookList;
	}	
	
	public void addBook(Book book){
		bookList.add(book);
	}
	
}
