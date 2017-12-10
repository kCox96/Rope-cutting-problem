/**
* The Algorithms class contains the two algorithms you have to implement for coursework 2

* Do NOT modify the names and signatures of the two algorithm methods
* 
* @author  Rouaa Yassin-Kassab & John Colquhoun
* @since   30/10/2017
* extended by @author 
*/

 
import java.util.*;

public class Algorithms{
	
	/**
	   * This method is used to implement the first fit algorithm 
	   * @param orders: a list of integers representing customer orders
	   * @param coils : a list of ropes representing available coils of ropes from the manufacturer
	   * @return the number of coils used to fulfil all customer orders
	   */
	public static int firstFit (List<Integer> orders, List <Rope> coils)
	{
		int numberOfCoils = 0;
		for(int i = 0; i <= orders.size(); i++) {
			for(int j = 0; j <= coils.size(); j++) {
				Rope currentRope = coils.get(i);
				int  currentRopeLen = currentRope.getLength();
				if(currentRopeLen >= orders.get(i)) {
					currentRope.cut(orders.get(i));
				}
				
				else if(currentRopeLen < 5) {
					coils.remove(currentRope);
					continue; 
				}
				
				else {
					((Generator) orders).orderRopeFromManufacturer(1);
					continue;
				}
				
				
			}
		
		numberOfCoils++;
	}
	
		return numberOfCoils;	
		}
	
	
	
	/**
	   * This method is used to implement the next fit algorithm 
	   * @param orders: a list of integers representing customer orders
	   * @param coils : a list of ropes representing available coils of ropes from the manufacturer
	   * @return the number of coils used to fulfil all customer orders
	   */ 
 	@SuppressWarnings("unlikely-arg-type")
	public int nextFit (List<Integer> orders, List <Rope> coils)
	{
 		int numberOfCoils = 0;
 		for(int i = 0; i <= orders.size(); i++) {
 			Rope lastRopeCut = coils.get(coils.size()-1);
 			int lastRopeLen = lastRopeCut.getLength();
 			if(lastRopeLen >= orders.get(i)) {
 			lastRopeCut.cut(orders.get(i));
 			}
 			else if(lastRopeLen < 5) {
 				orders.remove(lastRopeCut);
 				continue;
 			}
 			else {
 				((Generator) orders).orderRopeFromManufacturer(1); 
 				continue;
 			}
 			 numberOfCoils++;
 		}
 		
		return numberOfCoils;
	}

}
