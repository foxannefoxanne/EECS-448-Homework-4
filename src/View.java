import javax.swing.*; 
import java.awt.BorderLayout; 
import java.util.List;

public class View {

//	private JFrame frame; 
//	private JLabel label;
//	private JButton button; 
//	ButtonGroup starter = null;
//
//	public View(String text)
//	{
//		frame = new JFrame("View"); 
//		frame.getContentPane().setLayout(new BorderLayout()); 
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
//		frame.setSize(200,200);
//		frame.setVisible(true);
//		 
//		label = new JLabel(text); 
//		frame.getContentPane().add(label, BorderLayout.CENTER);
//	      starter = new ButtonGroup();
//	      JPanel p = new JPanel();
//	   
//	      addOption(p,starter,"View Books ");
//	      addOption(p,starter,"Order Books");
//	      addOption(p,starter,"Remove Books");
//	      addOption(p,starter,"View Order" );
//	      frame.add(p);
//
//		button = new JButton("Select"); 
//		frame.getContentPane().add(button, BorderLayout.SOUTH);
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
//	 public void addOption(JPanel p, ButtonGroup g, String t) {
//	      JRadioButton b = new JRadioButton(t);
//	      b.setActionCommand(t);
//	      p.add(b);
//	      g.add(b);
//	   }
	  int displayMenu(List<String> options)
	  {
		  return 0; 
	  }
	  
	  int displayCategories(List<String> categoryNames)
	  {
		  // strings in list will ONLY be category names (not numbers)
		  // include option to return to main menu by entering 0
		  return 0; 
	  }
	  
	  int displayBooks(List<Book> books)
	  {
		  return 0;
	  }
	  
	  int cart(Cart items)
	  {
		  return 45; 
	  }
	  
	  int RemoveOption()
	  {
		  return 333; 
	  }
	}
