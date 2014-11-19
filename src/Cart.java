/*
 * EECS 448
 * HW 4
 * 2014.11.19
 * Lynne Lammers, Christine Perinchery, Roxanne Calderon
 * Cart.java
 */

import java.util.ArrayList;
import java.util.List;

public class Cart {

	private List<Book> bookList;
	private double totalPrice;
	
	public Cart() {
		totalPrice = 0;
		bookList = new ArrayList<Book>();
	}
	
	public List<Book> getBooks() {
		return bookList;
	}
	
	public double getTotalPrice() {
		return totalPrice;
	}
	
	public void addBook(Book book) {
		bookList.add(book);
		totalPrice += book.getPrice();
	}
	
	public void removeBook(Book book) {
		bookList.remove(book);
		totalPrice -= book.getPrice();
	}
}
