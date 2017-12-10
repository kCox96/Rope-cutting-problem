/**
* The Test class is your main testing suite for the coursework

* You can add additional methods if you need to in this class 
* 
* @author  Rouaa Yassin-Kassab & John Colquhoun
* @since   30/10/2017
* extended by @author 
*/
 

import java.util.*; //needed for usage of the List interface

public class Test {
	
	
	//input: up to you if you populate the arguments array

	 /**
	   * This method is the main method to run your algorithms
	   *  
	   */
	public static void main (String [] args)
	{
	 /* 
 		  * You must complete the Generator class in order to generate a random test values 
		  * You must complete the Algorithms class in order to call the two algorithms
		  * Remember: You need to calculate the time and number of coils used for each run of each algorithm
		  * You can use any additional method you created in this class
		  */	
		   
		System.out.println("*********** Correctness testing ************");
		System.out.println();
		
		List<Integer> customerOrders = new ArrayList<Integer>();
		customerOrders = Generator.generateMultipleOrders(100); 
	    
	    List<Rope> coilsOfRope = new ArrayList<Rope>(100);
	    coilsOfRope = Generator.orderRopeFromManufacturer(100); 
	  
	    int test = Algorithms.firstFit(customerOrders, coilsOfRope);
	    System.out.println(test);
	    

	     
	   
		/*
		 * Here you will need to validate that your algorithms behave as expected on small data sets.
		 * You can use any additional method you created in this class
		 */
		
		
		
		System.out.println("************** Main testing **************");
		System.out.println("*********** Performance analysis **************");
		System.out.println();
		/*
		 * Here you will need to do performance testing
		 */
		
		int noOfTests =0;  //total number of tests - you need to CHANGE this value 
		int noOfRep =0;    //number of times to run each test - you need to CHANGE this value 
		int noOfOrders =0; //the number of customer orders needed for the first run - you need to CHANGE this value 
		int increment =0;  //the increment in the number of orders - you need to CHANGE this value 
		
		performanceTesting(noOfTests,noOfRep,noOfOrders,increment);
		
		
	}
	
	
	/**
	 *  performanceTesting (comparing the two algorithms in term of time and total number of coils used)
	 * 
	 * @param noOfTests - the number of tests 
	 * @param noOfRep - the number of repetitions for each test
	 * @param noOfOrders - the number of orders in the first order sequence
	 * @param increment - increment of the number of orders
	 *
     */
	public static void performanceTesting(int noOfTests, int noOfRep, int noOfOrders, int increment)
	{
		/*
		 * Here you will need to set up and run your Performance analysis
		 * You are expected  to run several tests (e.g. noOfTests=5) of your programs
		 * for, 10000, 20000, 30000, 40000, 50000 orders (noOfOrders=10000, increment=10000)
		 * so that one can see how the algorithms perform for large datasets.
		 *  
		 * You are expected to run the same test a number of times to ensure accurate result (noOfRep=4). In
		 * this case, you need to calculate the average time and coils needed for each run
         */
		
 		
	
	}
	
}
