import java.util.ArrayList;
import java.util.List;


public class Category {

	private List<Book> bookList;
	private String name;
	private double categoryPrice;
	
	public Category(){
		bookList = new ArrayList<Book>();
	}
	
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