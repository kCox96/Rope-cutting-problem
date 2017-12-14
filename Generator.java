/**
* The Generator class generates coils of rope and customer orders 

* Do NOT modify the names and signatures of the two generator methods
* 
* @author  Rouaa Yassin-Kassab & John Colquhoun
* @since   30/10/2017
* extended by Kiana Cox
*/
 
 
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Generator {
	// This variable represents the longest possible length of rope that a
	// customer can order
	private final int MAX_ORDER_LENGTH = 100;

	// These variables represent the longest and smallest possible coils of rope
	// that the manufacturers can supply
	private final int MIN_ROPE_LENGTH = 100;
	private final int MAX_ROPE_LENGTH = 200;

	/**
	 * This method will generate a list of orders of random lengths between the
	 * min and max order sizes (currently 1 and 100m)
	 * 
	 * @param numberOfOrders:
	 *            the number of customer orders to generate
	 * @return a list of customer orders
	 */
	public List<Integer> generateMultipleOrders(int numberOfOrders) {
		/* sets the min length an order can be */
		int minLength = 1;
		/* creates a new list to store the orders in */
		List<Integer> orderList = new ArrayList<Integer>();

		/* iterate through the number of orders given */
		for (int i = 0; i <= numberOfOrders - 1; i++) {
			/*
			 * for each order index generate a random length between the min
			 * length and max length
			 */
			orderList.add((int) (Math.random() * ((1 + MAX_ORDER_LENGTH) - minLength) + minLength));

		}
		/* return the initialised list of orders */
		return orderList;
	}

	/**
	 * This method will generate a list of new coils of rope from the
	 * manufacturer of random lengths between the min and max order sizes
	 * (currently 100 and 200m)
	 * 
	 * @param numberOfCoils:
	 *            the number of ropes to generate
	 * @return a list of coils of rope supplied by the manufacturer
	 * 
	 */

	public List<Rope> orderRopeFromManufacturer(int numberOfCoils) {

		/* create a new list to store the coils in */
		List<Rope> coils = new ArrayList<Rope>();
		/* iterate through the number of coils given */
		for (int i = 0; i <= numberOfCoils - 1; i++) {
			/*
			 * for each Rope index, create a new rope with a randomly generated
			 * length between the min length and max length
			 */

			Rope rope = new Rope((int) (Math.random() * ((1 + MAX_ROPE_LENGTH) - MIN_ROPE_LENGTH) + MIN_ROPE_LENGTH));
			/* add each newly generated rope to the coils list */
			coils.add(rope);
		}

		/* return the initialised list of coils */
		return coils;
	}

}
