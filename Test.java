
/**
* The Test class is your main testing suite for the coursework

* You can add additional methods if you need to in this class 
* 
* @author  Rouaa Yassin-Kassab & John Colquhoun
* @since   30/10/2017
* extended by Kiana Cox
*/

import java.util.*; //needed for usage of the List interface

public class Test {

	/*
	 * create algorithms objects for correctness testing and performance testing
	 */
	static Algorithms correctness = new Algorithms();
	static Algorithms performance = new Algorithms();
	/* create a generator object to initialise customer orders and order rope */
	static Generator g = new Generator();

	static int noOfTests = 5; // total number of tests to run in performance
								// testing
	static int noOfRep = 5; // number of times to run each test in performance
							// testing
	static int noOfOrders = 10000; // the number of customer orders needed for
									// the first run in performance testing
	static int increment = 10000; // the increment in the number of orders in
									// performance testing

	public static void main(String[] args) {

		System.out.println("*********** Correctness testing ************");
		System.out.println();
		/* run the correctness test for next fit */
		Test.testNextFit();
		/* run the correctness test for first fit */
		Test.testFirstFit();

		System.out.println("\n\n************** Main testing **************");
		System.out.println("\n*********** Performance analysis **************");
		System.out.println();
		/* run the performance tests */
		Test.performanceTesting(noOfTests, noOfRep, noOfOrders, increment);
	}

	/* this method tests next fit */
	public static void testNextFit() {

		/* initialise an array of customer orders with test values */
		List<Integer> customerOrders = Arrays.asList(new Integer[] { 70, 52, 48, 36, 78 });

		/* create ropes to initialise an array of ropes */
		Rope a = new Rope(128);
		Rope b = new Rope(117);
		Rope c = new Rope(165);
		Rope d = new Rope(101);
		Rope e = new Rope(127);
		/* add ropes to list of ropes */
		List<Rope> coilsOfRope = Arrays.asList(new Rope[] { a, b, c, d, e });
		/*
		 * print out the sizes of the customer orders to ensure the results are
		 * correct
		 */
		for (int i = 0; i <= customerOrders.size() - 1; i++) {
			int currentIndex = customerOrders.get(i);
			System.out.println("\nOrder size: " + currentIndex);
		}
		/*
		 * print out the initial coils of rope to ensure the results are correct
		 */
		for (int j = 0; j <= coilsOfRope.size() - 1; j++) {
			Rope currentIndex = coilsOfRope.get(j);
			System.out.print("\n\nRope: " + currentIndex);
		}
		/* apply the next fit algorithm algorithms object */
		int test = correctness.nextFit(customerOrders, coilsOfRope);
		/* print out number of customer orders and number of coils used */
		System.out.println("\n\n****************** Next fit test *********************");
		System.out.println("\n\nCustomer orders: " + customerOrders.size());
		System.out.println("\n\nCoils of rope used: " + test);

		/*
		 * this is a manual trace that validates the correctness of the
		 * algorithm
		 */
		System.out.println("\n\n******************** Maths to validate correctness **********************");
		System.out
				.println("\n\nFirst run: " + "\n\n128 - 70 = 58" + "\nPreviouslyCut? = False" + "\nNumberOfCoils = 1");
		System.out.println("\n\nSecond run: " + "\n\n58 - 52 = 6" + "\nPreviouslyCut? = True" + "\nNumberOfCoils = 1");
		System.out.println("\nThis coil can no longer be used so move on to the next one");
		System.out
				.println("\n\nThird run: " + "\n\n117 - 48 = 69" + "\nPreviouslyCut? = False" + "\nNumberOfCoils = 2");
		System.out
				.println("\n\nFourth run: " + "\n\n69 - 36  = 33" + "\nPreviouslyCut? = True" + "\nNumberOfCoils = 2");
		System.out.println("\nThis coil can no longer be used so move on to the next one");

		System.out
				.println("\n\nFifth run; " + "\n\n165 - 78 = 87" + "\nPreviouslyCut? = False" + "\nNumberOfCoils = 3");
		System.out.println("\n\nRopes used : 3" + "\nRope lengths after next fit: ");

		/*
		 * print out the lengths of the coils of rope remaining to validate the
		 * manual trace
		 */
		for (int k = 0; k <= coilsOfRope.size() - 1; k++) {
			Rope currentIndex = coilsOfRope.get(k);
			System.out.print("\n\nRope: " + currentIndex);
		}
	}

	/* this method tests the first fit algorithm */
	public static void testFirstFit() {

		/* initialise an array of customer orders with test values */

		List<Integer> customerOrders2 = Arrays.asList(new Integer[] { 28, 5, 48, 87, 41 });
		/* create ropes to initialise an array of ropes */
		Rope a = new Rope(190);
		Rope b = new Rope(141);
		Rope c = new Rope(127);
		Rope d = new Rope(116);
		Rope e = new Rope(154);
		/* add ropes to list of ropes */
		List<Rope> coilsOfRope2 = Arrays.asList(new Rope[] { a, b, c, d, e });

		System.out.println("\n\n******************** First fit test *******************");
		/*
		 * print out the sizes of the customer orders to ensure the results are
		 * correct
		 */

		for (int y = 0; y <= customerOrders2.size() - 1; y++) {
			int currentIndex = customerOrders2.get(y);
			System.out.println("\n\nOrder size: " + currentIndex);
		}
		/*
		 * print out the initial coils of rope to ensure the results are correct
		 */

		for (int l = 0; l <= coilsOfRope2.size() - 1; l++) {
			Rope currentIndex = coilsOfRope2.get(l);
			System.out.print("\n\nRope: " + currentIndex);
		}
		/* apply the first fit algorithm to the algorithms object */
		int test2 = correctness.firstFit(customerOrders2, coilsOfRope2);

		/*
		 * print out the number of customer orders and the number of coils used
		 */
		System.out.println("\n\nCustomer orders: " + customerOrders2.size());
		System.out.println("\n\nCoils of rope used: " + test2);

		/* prints out a manual trace of the algorithm */
		System.out.println("\n\n******************** Maths to validate correctness **********************");
		System.out
				.println("\n\nFirst run: " + "\n\n190 - 28 = 162" + "\nPreviouslyCut? = False" + "\nNumberOfCoils = 1");
		System.out
				.println("\n\nSecond run: " + "\n\n162 - 5 = 157" + "\nPreviouslyCut? = True" + "\nNumberOfCoils = 1");
		System.out
				.println("\n\nThird run: " + "\n\n157 - 48 = 109" + "\nPreviouslyCut? = True" + "\nNumberOfCoils = 1");
		System.out
				.println("\n\nFourth run: " + "\n\n109 - 87  = 22" + "\nPreviouslyCut? = True" + "\nNumberOfCoils = 1");
		System.out.println("This coil is now too short to fulfill the rest of the orders");

		System.out
				.println("\n\nFifth run; " + "\n\n141 - 41 = 100" + "\nPreviouslyCut? = False" + "\nNumberOfCoils = 2");
		System.out.println("\n\nRopes used : 2" + "\nRope lengths after next fit: ");

		/*
		 * print out the new sizes of the remaining ropes to validate the manual
		 * trace
		 */
		for (int x = 0; x <= coilsOfRope2.size() - 1; x++) {
			Rope currentIndex = coilsOfRope2.get(x);
			System.out.print("\n\nRope: " + currentIndex);
		}
	}

	/*
	 * this method copies the randomly generated rope lengths into a new array,
	 * so that both algorithms can be tested using the same set of values, and
	 * so that all changes made to rope lengths can be reversed
	 */

	public static List<Rope> copyCoils(List<Rope> coils) {
		/* create an array to store the copies in */
		List<Rope> copy = new ArrayList<Rope>();
		/* for each rope in coils, add to the copies array */
		for (Rope r : coils) {
			copy.add(new Rope(r.getLength()));
		}
		/* return the copy array */
		return copy;
	}

	/**
	 * performanceTesting (comparing the two algorithms in term of time and
	 * total number of coils used)
	 * 
	 * @param noOfTests
	 *            - the number of tests
	 * @param noOfRep
	 *            - the number of repetitions for each test
	 * @param noOfOrders
	 *            - the number of orders in the first order sequence
	 * @param increment
	 *            - increment of the number of orders
	 *
	 */
	public static void performanceTesting(int noOfTests, int noOfRep, int noOfOrders, int increment) {

		/* initialise variables */

		List<Integer> customerOrders;
		/* create arrays to store the results of each iteration of tests */
		List<Integer> results = new ArrayList<Integer>();
		List<Integer> results2 = new ArrayList<Integer>();
		/* create arrays to store the times of each iteration of tests */
		List<Long> averageTime = new ArrayList<Long>();
		/*
		 * iterate through the number of tests given, generating a new array of
		 * ropes with random lengths in each iteration
		 */
		for (int i = 0; i < noOfTests; i++) {
			List<Rope> coilsOfRope = g.orderRopeFromManufacturer(noOfOrders);

			System.out.println("\n\n**************************** Next fit tests ***********************************");

			/*
			 * carry out each test as many times as the noOfReps variable given
			 */
			for (int j = 0; j < noOfRep; j++) {
				/* begin timing the algorithm */
				long startTime = System.currentTimeMillis();
				/* generate customer orders */
				customerOrders = g.generateMultipleOrders(noOfOrders);
				/* copy the initial lengths of the ropes into a new array */
				List<Rope> coilsOfRopeCopy = Test.copyCoils(coilsOfRope);
				/* apply the next fit algorithm to the given data sets */
				int performanceTest = performance.nextFit(customerOrders, coilsOfRopeCopy);

				/* calculate the time taken for the algorithm to complete */
				long elapsedTime = System.currentTimeMillis() - startTime;
				/*
				 * print out the number of orders, the number of coils of rope
				 * used and the time taken to complete
				 */
				System.out.println("\nNumber of orders: " + noOfOrders);
				System.out.println("Coils of rope used: " + performanceTest);
				System.out.println("Time taken: " + elapsedTime + " milliseconds");
				/*
				 * add the number of coils used of each repetition to the
				 * results array
				 */
				results.add(performanceTest);
				/*
				 * add the time taken for each repetition to the averageTime
				 * array
				 */
				averageTime.add(elapsedTime);
			}

			/* print out the values in the results array */
			System.out.print("\n\nCoils used each time: " + results);
			/* calculate the average of the values in the results array */
			int sum = 0;
			for (int r : results) {
				sum += r;
			}
			int average = sum / results.size();
			/* print out the average number of coils used for each test */
			System.out.print("\n\nAverage number of coils used: " + average);
			/* clear the results array */
			results.removeAll(results);
			/* print out the average time taken to complete each test */
			System.out.print("\n\nTime taken for each test: " + averageTime);
			/* calculate the average of the values in the averageTime array */
			long timeSum = 0;
			for (long a : averageTime) {
				timeSum += a;
			}
			long timeAverage = timeSum / averageTime.size();
			/* print out the average time taken to complete each test */
			System.out.print("\n\nAverage time taken: " + timeAverage + " milliseconds");
			/* clear the averageTime array */
			averageTime.removeAll(averageTime);

			System.out.println("\n\n**************************** First fit tests ***********************************");
			/*
			 * carry out each test as many times as the noOfReps variable given
			 */

			for (int k = 0; k < noOfRep; k++) {
				/* begin timing the algorithm */
				long startTime = System.currentTimeMillis();
				/* generate customer orders */
				customerOrders = g.generateMultipleOrders(noOfOrders);
				/* copy the initial lengths of the ropes into a new array */
				List<Rope> coilsOfRopeCopy = Test.copyCoils(coilsOfRope);
				/* apply the first fit algorithm to the given data sets */
				int performanceTest = performance.firstFit(customerOrders, coilsOfRopeCopy);
				/* copy the initial lengths of the ropes into a new array */
				long elapsedTime = System.currentTimeMillis() - startTime;
				/*
				 * print out the number of orders, the number of coils of rope
				 * used and the time taken to complete
				 */

				System.out.println("\nNumber of orders: " + noOfOrders);
				System.out.println("Coils of rope used: " + performanceTest);
				System.out.println("Time taken: " + elapsedTime + " milliseconds");
				/*
				 * add the number of coils used for each repetition to the
				 * results2 array
				 */
				results2.add(performanceTest);
				/*
				 * add the time taken to complete each repetition to the
				 * averageTime array
				 */
				averageTime.add(elapsedTime);
			}
			/* print out the values in the results2 array */
			System.out.print("\n\nCoils used each time: " + results2);
			/* calculate the average of the values in the results2 array */
			int sum2 = 0;
			for (int r : results2) {
				sum2 += r;
			}
			int average2 = sum2 / results2.size();
			/* print out the average number of coils used in each test */
			System.out.print("\n\nAverage number of coils used: " + average2);
			/* clear the results2 array */
			results2.removeAll(results2);
			/* print out the values in the averageTime array */
			System.out.print("\n\nTime taken for each test: " + averageTime);
			/* calculate the average of the values in the averageTime array */
			long timeSum2 = 0;
			for (long a : averageTime) {
				timeSum2 += a;
			}
			long timeAverage2 = timeSum2 / averageTime.size();
			/* print out the average time taken to complete each test */
			System.out.print("\n\nAverage time taken: " + timeAverage2 + " milliseconds");
			/* clear the averageTime array */
			averageTime.removeAll(averageTime);
			/* increment the number of orders by the given value */
			noOfOrders = noOfOrders + increment;

		}

	}
}
