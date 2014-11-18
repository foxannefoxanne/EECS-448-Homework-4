
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException; 

public class View {
    Scanner scanner = new Scanner( System.in );


	  int displayMenu(List<String> options)
	  {
		  //might modify for less hardcoded lines of books. 
		  int input = -1;
		  for(int i = 0; i < options.size(); i++)
		  {
			  int j = i + 1; 
			  System.out.println(options.get(i));
		  }
		  
		  try
		  {
		  	input = scanner.nextInt();
		    System.out.println("\n"); 
		  
		  }
		  catch(InputMismatchException exception)
		  {

			  scanner.next();
			  	input = -1; 
		  }
		  return input; 
	  }
	  
	  /*
	   * @return: number of category selected (i.e. 1 for first category listed)
	   * 			or 0 to return to main menu
	   */
	  int displayCategories(List<String> categoryNames)
	  {
		  // strings in list will ONLY be category names (not numbers)
		  // include option to return to main menu by entering 0
		
		  int input = -1;
		  System.out.println("Select a category or press 0 to retun to main menu:");
		  System.out.println("0. Return to main menu"); 
		  for(int i = 0; i < categoryNames.size(); i++)
		  {
			  int j = i + 1; 
			  System.out.println(j + ". " + categoryNames.get(i)); 
		  }
		  try
		  {
		  	input = scanner.nextInt();
		    System.out.println("\n"); 
		  
		  }
		  catch(InputMismatchException exception)
		  {

			  scanner.next();
			  	input = -1; 
		  }
		  return input; 
	  }
	  
	  /*
	   * @return: number of book selected (i.e. 1 for first book listed)
	   * 			or 0 to return to main menu
	   */
	  int displayBooks(List<Book> books)
	  {
		  int input = -1;
		  
		  int titleSize = maxSize(books,1);
		  int authorSize = maxSize(books,2); 
		  int categorySize = maxSize(books,3); 
		  
		  int titleHeader = titleSize - 1; 
		  int authorHeader = authorSize - 3; 
		  int categoryHeader = categorySize - 6;
				  
		  String titleSpace = String.format("%" + titleHeader+ "s", " "); 
		  String authorSpace = String.format("%" + authorHeader + "s", " "); 
		  String categorySpace = String.format("%" + categoryHeader + "s", " ");
		  
		  // will only pass in a list of books, so format as needed (need to ensure spacing is ok)
		  System.out.println("Select a book or press 0 to return to main menu:");
		  System.out.println("Number " + "Title" + titleSpace + "Author" + authorSpace + "Category" +categorySpace +  " Price");
		
		  for(int i = 0; i < books.size(); i++)
		  {
			  String title = books.get(i).getTitle();
			  String author = books.get(i).getAuthor();
			  double price = books.get(i).getPrice();
			  String category = books.get(i).getCategory();
			  
			  int j = i + 1; 
			  
			  int titleAlignment = titleSize + 3 - books.get(i).getTitle().length();
			  int authorAlignment = authorSize + 3 - books.get(i).getAuthor().length();
			  int categoryAlignment = categorySize + 3 - books.get(i).getCategory().length();
			  
			  titleSpace = String.format("%" + titleAlignment + "s", " "); 
			  authorSpace = String.format("%" + authorAlignment + "s", " "); 
			  categorySpace = String.format("%" + categoryAlignment + "s", " ");
			  
			  if(i < 9)
			  System.out.println("0" + j + ".     " + title + titleSpace + author + authorSpace + category + categorySpace + "$" + price + "0"); 
			  
			  else 
				 System.out.println(j + ".     " + title + titleSpace + author + authorSpace + category + categorySpace+ "$" + price + "0"); 
			  
			  titleAlignment = 0; 
		  }
		  System.out.println("00.     Return to main menu"); 
		  
		  try
		  {
		  	input = scanner.nextInt();
		    System.out.println("\n"); 
		  
		  }
		  catch(InputMismatchException exception)
		  {

			  scanner.next();
			  	input = -1; 
		  }
		  return input; 

	  }
	  
	  /*
	   * @param items: Cart that contains list of books plus the total price
	   * @param options: List of options for how to proceed (check out, remove item, return to main menu)
	   */
	  int displayCart(Cart items, List<String> options)
	  {
		  int input = -1;

		  System.out.println("Please review your shopping cart:");
		  System.out.println("Total: " + items.getTotalPrice() + "\n");
		  
		  
		  int titleSize = maxSize(items.getBooks(),1);
		  int authorSize = maxSize(items.getBooks(),2); 
		  int categorySize = maxSize(items.getBooks(),3); 
		  
		  int titleHeader = titleSize - 2; 
		  int authorHeader = authorSize - 3; 
		  int categoryHeader = categorySize - 6;
				  
		  String titleSpace = String.format("%" + titleHeader+ "s", " "); 
		  String authorSpace = String.format("%" + authorHeader + "s", " "); 
		  String categorySpace = String.format("%" + categoryHeader + "s", " ");
		  
		  
		  System.out.println("Title" + titleSpace + "Author" + authorSpace + "Category" +categorySpace +  " Price");
		  
		  for(int i = 0; i < items.getBooks().size(); i++)
		  {
			  String title = items.getBooks().get(i).getTitle();
			  String author = items.getBooks().get(i).getAuthor();
			  double price = items.getBooks().get(i).getPrice();
			  String category = items.getBooks().get(i).getCategory();
			  int j = i + 1; 
			  
			  int titleAlignment = titleSize + 3 - items.getBooks().get(i).getTitle().length();
			  int authorAlignment = authorSize + 3 - items.getBooks().get(i).getAuthor().length();
			  int categoryAlignment = categorySize + 3 - items.getBooks().get(i).getCategory().length();
			  
			  titleSpace = String.format("%" + titleAlignment + "s", " "); 
			  authorSpace = String.format("%" + authorAlignment + "s", " "); 
			  categorySpace = String.format("%" + categoryAlignment + "s", " ");
			 
			  System.out.println(title + titleSpace + author + authorSpace + category + categorySpace+ "$" + price + "0"); 
		  }
		  
		  System.out.println(" "); 
		  for(int i = 0; i < options.size(); i++)
		  {
			  int j = i + 1; 
			  System.out.println(options.get(i));
		  }
		  
		  try
		  {
		  	input = scanner.nextInt();
		    System.out.println("\n"); 
		  
		  }
		  catch(InputMismatchException exception)
		  {

			  scanner.next();
			  	input = -1; 
		  }
		  return input; 

	  }
	  
	  /*
	   * Display cart and prompt for which item to remove
	   * @return int: either item number in cart (i.e. 1 for first item) or 0 to cancel
	   */
	  int removeOption(Cart items)
	  {
		  int input = -1;
		  int titleSize = maxSize(items.getBooks(),1);
		  int authorSize = maxSize(items.getBooks(),2); 
		  int categorySize = maxSize(items.getBooks(),3); 
		  
		  int titleHeader = titleSize - 1; 
		  int authorHeader = authorSize - 3; 
		  int categoryHeader = categorySize - 6;
				  
		  String titleSpace = String.format("%" + titleHeader+ "s", " "); 
		  String authorSpace = String.format("%" + authorHeader + "s", " "); 
		  String categorySpace = String.format("%" + categoryHeader + "s", " ");
		  
	
		  
		  System.out.println("Please select an item to remove: ");
		  System.out.println("Number " + "Title" + titleSpace + "Author" + authorSpace + "Category" +categorySpace +  " Price");
		  
		 
		
		  // check for empty cart?
		  for(int i = 0; i < items.getBooks().size(); i++)
		  {
			  String title = items.getBooks().get(i).getTitle();
			  String author = items.getBooks().get(i).getAuthor();
			  double price = items.getBooks().get(i).getPrice();
			  String category = items.getBooks().get(i).getCategory();
			  int j = i + 1; 
			  
			  int titleAlignment = titleSize + 3 - items.getBooks().get(i).getTitle().length();
			  int authorAlignment = authorSize + 3 - items.getBooks().get(i).getAuthor().length();
			  int categoryAlignment = categorySize + 3 - items.getBooks().get(i).getCategory().length();
			  
			  titleSpace = String.format("%" + titleAlignment + "s", " "); 
			  authorSpace = String.format("%" + authorAlignment + "s", " "); 
			  categorySpace = String.format("%" + categoryAlignment + "s", " ");
			  
			  if(i < 9)
			  System.out.println("0" + j + ".     " + title + titleSpace + author + authorSpace + category + categorySpace + "$" + price + "0"); 
			  
			  else 
				 System.out.println(j + ".     " + title + titleSpace + author + authorSpace + category + categorySpace+ "$" + price + "0"); 
			  
			  titleAlignment = 0; 
			
		  }
		  
		  
		  System.out.println("00.     Return to main menu");
		  
		  try
		  {
		  	input = scanner.nextInt();
		    System.out.println("\n"); 
		  
		  }
		  catch(InputMismatchException exception)
		  {

			  scanner.next();
			  	input = -1; 
		  }
		  return input; 
	  }
	  
	  /*
	   * Display message that check out was successful, etc.
	   */
	  public void displayCheckOutMessage()
	  {
		  System.out.println("Thank you for shopping with us today! Your payment is being processed!"); 
	  }
	  
	  /*
	   * Displays message that option selected was invalid
	   */
	  public void displayInvalidSelection() 
	  {
		  System.out.println("\nPlease enter one of the numbers listed."); 
	  }
	  
	  /*
	   * Displays message that book was successfully added to cart
	   */
	  public void displaySuccessfullyAdded()
	  {
		  System.out.print("Book added to cart \n"); 
	  }

	  public void displaySuccessfullyRemoved() {
		// TODO Auto-generated method stub
		System.out.print("Book removed from cart \n"); 
		  
	  }

	  public void welcomeMessage() {
		// TODO Auto-generated method stub
		System.out.println("Welcome to our bookstore!");
	  }

	  public int maxSize(List<Book> books, int request)
	  {
		  int biggest = 0;
		  int length = 0;
		  for(int i = 0; i < books.size(); i++)
		  {
			  if(request == 1)
				 length = books.get(i).getTitle().length(); 
			  
			  else if(request == 2)
				  length = books.get(i).getAuthor().length();
			  
			  else
				  length = books.get(i).getCategory().length();
			  
			  if (biggest < length)
				  biggest = length; 
		  }
		  
		return biggest; 
	  }
	  
	 
}


