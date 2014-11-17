//import javax.swing.*; 
//import java.awt.*;
//import java.awt.event.*;
//
//import java.awt.BorderLayout; 
//import java.util.List;
//import java.awt.GridLayout;
//
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;


public class View {
    Scanner scanner = new Scanner( System.in );

	
//	private JFrame frame; 
//	private JLabel label;
//	private JButton button; 
//	ButtonGroup starter = null;
//	 	
//	public View()
//	{
//		frame = new JFrame("View"); 
//		frame.getContentPane().setLayout(new BorderLayout()); 
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
//		frame.setSize(500,500);
//		frame.setVisible(true);
//		 
//	 	label = new JLabel(""); 
//		frame.getContentPane().add(label, BorderLayout.CENTER);
//	      starter = new ButtonGroup();
//	      JPanel p = new JPanel();
//	  
//	      frame.add(p);
//
//		//button = new JButton("Select"); 		
//	      //frame.getContentPane().add(button, BorderLayout.SOUTH);
//		
//	}
//	
//	public JButton getButton()
//	{
//		return button; 
//	}
//	
//	public void setText(String text)
//	{
//		label.setText(text); 
//	}
//	
//	public int selectMainMenu(List<String> options)
//	{
//		 
//		int selectedInt = 3; 
//		JPanel mainMenu = new JPanel();
//	    final ButtonGroup mainGroup = new ButtonGroup();
//	    JRadioButton radioButton;
//	    Container c = frame.getContentPane();
//
//	    
//	    frame.setLayout(new BoxLayout(c,BoxLayout.Y_AXIS));
//
//	    c.add(radioButton = new JRadioButton(options.get(0)));
//	    radioButton.setActionCommand("1");
//	    c.add(radioButton);
//	    c.add(radioButton = new JRadioButton(options.get(1)));
//	    radioButton.setActionCommand("2");
//	    mainGroup.add(radioButton);
//	    c.add(radioButton = new JRadioButton(options.get(2)));
//	    radioButton.setActionCommand("3");
//	    c.add(radioButton);
//
//
//	    JPanel selectionPanel = new JPanel();
//	    JButton selectButton = new JButton("Select");
//	    c.add(selectButton);
//	    
//	    frame.setLayout(new BoxLayout(c,BoxLayout.Y_AXIS));
//	    //frame.setLayout(new GridLayout(1, 3));
//	  
//	    
//	    frame.add(mainMenu);
//	    
//	    frame.add(selectionPanel);
//	 
//	  
//	
//	   
//		return selectedInt; 
//	}
//
//	
	  int displayMenu(List<String> options)
	  {
		  //might modify for less hardcoded lines of books. 
		  for(int i = 0; i < options.size(); i++)
		  {
			  int j = i + 1; 
			  System.out.println(options.get(i));
		  }
		    int input = scanner.nextInt();
		    System.out.println("\n"); 
		  return input; //selectMainMenu(); 
	  }
	  
	  /*
	   * @return: number of category selected (i.e. 1 for first category listed)
	   * 			or 0 to return to main menu
	   */
	  int displayCategories(List<String> categoryNames)
	  {
		  // strings in list will ONLY be category names (not numbers)
		  // include option to return to main menu by entering 0
		  System.out.println("Select a category or press 0 to retun to main menu:");
		  System.out.println("0. Return to main menu"); 
		  for(int i = 0; i < categoryNames.size(); i++)
		  {
			  int j = i + 1; 
			  System.out.println(j + ". " + categoryNames.get(i)); 
		  }
		  int input = scanner.nextInt();
		    System.out.println("\n"); 
		  return input; 
	  }
	  
	  /*
	   * @return: number of book selected (i.e. 1 for first book listed)
	   * 			or 0 to return to main menu
	   */
	  int displayBooks(List<Book> books)
	  {
		  // will only pass in a list of books, so format as needed (need to ensure spacing is ok)
		  System.out.println("Select a book or press 0 to return to main menu:");
		  System.out.println("Number  Title                                      Author            Category           Price");
		  System.out.println("0.      Return to main menu"); 
		  for(int i = 0; i < books.size(); i++)
		  {
			  String title = books.get(i).getTitle();
			  String author = books.get(i).getAuthor();
			  double price = books.get(i).getPrice();
			  String category = books.get(i).getCategory();
			  int j = i + 1; 
			  
			  System.out.println(j + ".      " + title + "  " + author + "  " + category + "  " + price); 
		  }
		  int input = scanner.nextInt();
		    System.out.println("\n"); 
		  return input; 

	  }
	  
	  /*
	   * @param items: Cart that contains list of books plus the total price
	   * @param options: List of options for how to proceed (check out, remove item, return to main menu)
	   */
	  int displayCart(Cart items, List<String> options)
	  {
		 
		  System.out.println("Please review your shopping cart:");
		  System.out.println("Total Amount Owed: " + items.getTotalPrice());
		  System.out.println("Number  Title                                      Author            Category           Price");
		  for(int i = 0; i < items.getBooks().size(); i++)
		  {
			  String title = items.getBooks().get(i).getTitle();
			  String author = items.getBooks().get(i).getAuthor();
			  double price = items.getBooks().get(i).getPrice();
			  String category = items.getBooks().get(i).getCategory();
			  int j = i + 1; 
			  
			  System.out.println(title + "  " + author + "  " + category + "  " + price); 
		  }
		  
		  for(int i = 0; i < options.size(); i++)
		  {
			  int j = i + 1; 
			  System.out.println(j + ". " + options.get(i));
		  }
		  
		  int input = scanner.nextInt();
		    System.out.println("\n"); 
		  return input; 

	  }
	  
	  /*
	   * Display cart and prompt for which item to remove
	   * @return int: either item number in cart (i.e. 1 for first item) or 0 to cancel
	   */
	  int removeOption(Cart items)
	  {
		  System.out.println("Please select an item to remove: ");
		  System.out.println("Number  Title                                      Author            Category           Price");
		  // maybe print this at the end of the list?
		  System.out.println("0. Return to main menu");
		  // check for empty cart?
		  for(int i = 0; i < items.getBooks().size(); i++)
		  {
			  String title = items.getBooks().get(i).getTitle();
			  String author = items.getBooks().get(i).getAuthor();
			  double price = items.getBooks().get(i).getPrice();
			  String category = items.getBooks().get(i).getCategory();
			  int j = i + 1; 
			  
			  System.out.println(j + ". " + title + "  " + author + "  " + category + "  " + price); 
		  }
		  
	
		  int input = scanner.nextInt();
		    System.out.println("\n"); 
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
	  public int displayInvalidSelection() 
	  {
		  System.out.println("Please enter one of the numbers listed above.");

		  int input = scanner.nextInt();
		    System.out.println("\n"); 
		  return input; 
	  }
	  
	  /*
	   * Displays message that book was successfully added to cart
	   */
	  public void displaySuccessfullyAdded()
	  {
		  System.out.println("Book added to cart"); 
	  }
	  
	  
	}
