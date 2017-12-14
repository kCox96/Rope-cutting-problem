
/**
* The Algorithms class contains the two algorithms you have to implement for coursework 2

* Do NOT modify the names and signatures of the two algorithm methods
* 
* @author  Rouaa Yassin-Kassab & John Colquhoun
* @since   30/10/2017
* extended by Kiana Cox*/

import java.util.*;

public class Algorithms {

	/*
	 * This method is used to implement the first fit algorithm
	 * 
	 * @param orders:
	 *            a list of integers representing customer orders
	 * @param coils
	 *            : a list of ropes representing available coils of ropes from
	 *            the manufacturer
	 * @return the number of coils used to fulfil all customer orders
	 */
	public int firstFit(List<Integer> orders, List<Rope> coils) {
		/* set number of coils used to zero */
		int numberOfCoils = 0;
		/*
		 * create an ArrayList of booleans to check if a rope has been cut or
		 * not
		 */
		ArrayList<Boolean> haveCut = new ArrayList<Boolean>();
		for (int i = 0; i < coils.size(); i++) {
			/* initialise each rope value to false */
			haveCut.add(new Boolean(false));
		}
		/* iterate through array of orders */
		for (int i = 0; i < orders.size(); i++) {
			/* iterate through array of coils */
			for (int j = 0; j < coils.size(); j++) {

				Rope currentRope = coils.get(j);
				int currentRopeLen = currentRope.getLength();

				/*
				 * check if the rope at current index can be cut to fill current
				 * order
				 */
				if (currentRope.cut(orders.get(i))) {
					/*
					 * if the rope has not been previously cut, set its boolean
					 * value to true
					 */
					if (haveCut.get(j).booleanValue() == false) {
						haveCut.set(j, new Boolean(true));
						/* increment the number of coils used */
						numberOfCoils++;
					}
					/* break out of the inner loop */
					break;
				}
				/*
				 * check if the rope at current index is unable to fill current
				 * order
				 */
				else if (currentRope.cut(orders.get(i)) == false) {
					/*
					 * if rope's boolean value is false, ensure it stays false
					 */
					if (haveCut.get(j).booleanValue() == false) {
						haveCut.set(j, new Boolean(false));
					}

				}
				/*
				 * check if the length of the rope at the current index is
				 * shorter than 5 remove it from the array of coils
				 */

				if (currentRopeLen < 5) {
					coils.remove(currentRope);
					/* remove the boolean value from the array of booleans */
					haveCut.remove(j);
					/* break out of the inner loop */
					break;
				}

			}
		}
		/* return the number of coils used */
		return numberOfCoils;

	}

	/**
	 * This method is used to implement the next fit algorithm
	 * 
	 * @param orders:
	 *            a list of integers representing customer orders
	 * @param coils
	 *            : a list of ropes representing available coils of ropes from
	 *            the manufacturer
	 * @return the number of coils used to fulfil all customer orders
	 */

	public int nextFit(List<Integer> orders, List<Rope> coils) {
		/* set number of coils used to zero */
		int numberOfCoils = 0;
		/* initialise a coils index for incrementing through array of coils */
		int coilsIndex = 0;
		/*
		 * set a boolean value to check if a rope has been previously cut and
		 * initialise it to false
		 */
		boolean previouslyCut = false;
		/* iterate through the list of orders */
		for (int i = 0; i < orders.size(); i++) {

			Rope lastRopeCut = coils.get(coilsIndex);
			int lastRopeLen = lastRopeCut.getLength();

			/*
			 * check if the rope at current index can be cut to fulfil current
			 * order
			 */
			if (lastRopeCut.cut(orders.get(i))) {
				/*
				 * if rope has been marked as not previously cut, change boolean
				 * value to indicate it has been cut
				 */
				if (previouslyCut == false) {
					previouslyCut = true;
					/*
					 * increment number of coils used if coil at current index
					 * has not been previously cut
					 */
					numberOfCoils++;
				}
			}

			/*
			 * check if rope at current index is unable to fulfil current order
			 */
			else if (lastRopeCut.cut(orders.get(i)) == false) {
				/*
				 * check for index out of bounds error and increment the coils
				 * index to check next coil
				 */

				if (coilsIndex < coils.size()) {
					coilsIndex++;
					/*
					 * set boolean value to false since the current rope has not
					 * been cut
					 */
					previouslyCut = false;
					/*
					 * check for index out of bounds error and decrement the
					 * orders index, since the order hasn't been fulfilled
					 */

					if (i > 0) {
						i--;
					}

				}
			}
			/* check if current rope length is less than 5 */
			if (lastRopeLen < 5) {
				/*
				 * remove this rope from the coils array and decrement the coils
				 * index to compensate
				 */

				coils.remove(lastRopeCut);
				coilsIndex--;

			}

		}
		/* return the number of coils used */
		return numberOfCoils;

	}
}
