/**
* The Generator class generates coils of rope and customer orders 

* Do NOT modify the names and signatures of the two generator methods
* 
* @author  Rouaa Yassin-Kassab & John Colquhoun
* @since   30/10/2017
* extended by @author 
*/
 
 
import java.util.ArrayList;
import java.util.List;


public class Generator {
	//This variable represents the longest possible length of rope that a customer can order
	private final static int MAX_ORDER_LENGTH = 100;
		
	//These variables represent the longest and smallest possible coils of rope that the manufacturers can supply
	private final static int MIN_ROPE_LENGTH = 100;
	private final static int MAX_ROPE_LENGTH = 200;
			
	
	/**
	   * This method will generate a list of orders of random lengths between 
	   * the min and max order sizes (currently 1 and 100m)
	   * @param numberOfOrders: the number of customer orders to generate
	   * @return a list of customer orders
	   */
	public static List<Integer> generateMultipleOrders (int numberOfOrders)
	{
		int minLength = 1;
	
		List<Integer> orderList = new ArrayList<Integer> ();
			

		for(int i = 0; i <= numberOfOrders; i++) {
			orderList.add((int)(Math.random() *MAX_ORDER_LENGTH + minLength));
		}
		
		return orderList; 
	}
	
	
	/**
	   * This method will generate a list of new coils of rope from the manufacturer of 
	   * random lengths between the min and max order sizes (currently 100 and 200m)
	   * @param numberOfCoils: the number of ropes to generate
	   * @return a list of coils of rope supplied by the manufacturer 
	   * 
	   */
 	 
	public static List<Rope> orderRopeFromManufacturer(int numberOfCoils)
	{
		Rope rope = new Rope((int)(Math.random() * MAX_ROPE_LENGTH + MIN_ROPE_LENGTH));	
		List<Rope> coils= new ArrayList<Rope> ();
		for(int i = 0; i <= numberOfCoils; i++) {
			coils.add(rope);
		}
	
		
		return coils;
	}
		

}
