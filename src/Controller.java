import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener;

public class Controller {
	//order instance if empty new order
	//use some of the stuff from before

	  static Model sciFiList = new Model(); 
	  static Model travelList = new Model();
	  static Model softwareList = new Model(); 
	 
	  
	public void createBookstore()
	{
		 
		  String sciFi = new String("scifi.txt") ;
		  sciFiList.loadData(sciFi); 
		
		  String travel = new String("travelbooks.txt") ;
		  travelList.loadData(travel); 
		  
		  String software = new String("softwarebooks.txt") ;
		  softwareList.loadData(software); 
		  
		  goToBookStore();
	}
	 public void goToBookStore()
	{
		 View v = new View("Books"); 
		//options: 
			//add books -> database
			//view books -> view? 
			//delete books ->database
			//compute cost ->database
		
	}
	

}
