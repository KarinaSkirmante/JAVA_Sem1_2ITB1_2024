package service;

import java.util.Arrays;
import java.util.Random;

/**
 * Documentation
 * 
 */

public class MainService {

	private static final double GRAVITY = -9.81;

	public static void main(String[] args) {
		// oneline comments
		/*
		 * Multiline comments
		 */

		System.out.println("Hello!" + "fdasfsf ");

		System.out.println();
		try {
			System.out.println(positionCalc(1.2, 1.2, 1.2) + " m");
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		
		System.out.println(factorialForLoop(4));
		System.out.println(factorialForLoop(10));
		
		try {
			double[] mas = generateArray(10, 1, 5);
			System.out.println(Arrays.toString(mas));
			System.out.println("Avg:" + getMean(mas));
			System.out.println(Arrays.toString(arraySort(mas)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			System.out.println(Arrays.deepToString(generateMatrix(5)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//new function as comment
		
		try {
			System.out.println(Arrays.toString(coinFlip(10000000)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

	// new function
	public static double positionCalc(double initialVelocity, double initialPosition, double fallingTime)
			throws Exception {

		// TODO check verifications
		if ((initialVelocity > 0 && initialVelocity < 10000) && (initialPosition > 0 && initialPosition < 10000)
				&& (fallingTime > 0 && fallingTime < 1000000)) {
			// Example: Math.pow(fallingTime, 2)
			return 0.5 * GRAVITY * fallingTime * fallingTime + initialVelocity * fallingTime + initialPosition;
		}
		throw new Exception("Wrong input paramters");

	}
	
	//4! = 1 * 2 * 3 * 4 = 24
	public static int factorialForLoop(int N) {
		if(N < 0) return 0;
		else if(N == 0) return 1;
		//TODO bez else atslēgas vārda var iztikt
		else
		{
			int result = 1;
			for(int i = 1; i <=N; i++)
			{
				result = result * i;
				//īsa forma: result *= i;
			}
			return result;
		}
	}
	
	
	public static double[] generateArray(int N, double lower, double upper) throws Exception {
		if((N <= 0) || (upper < lower)) throw new Exception("Wrong input parameters");
		
		double[] result = new double[N];
		
		Random rand = new Random();
		
		for(int i = 0; i < result.length; i++) {
			result[i] = rand.nextDouble(lower, upper);
		}
		
		return result;		
		
	}
	
	public static double getMean(double[] array) throws Exception {
		if(array == null) throw new Exception("Wrong input parameter");
		double sum = 0;
		// tips mainigais : masivs
		for(double temp : array) {
			sum += temp;
		}
		
		return sum/array.length;
		
	}
	
	//TODO min and max functions
	
	
	
	public static double[] arraySort(double[] array) throws Exception {
		if(array == null) throw new Exception("Wrong input parameter");
		
		Arrays.sort(array);
		return array;
	}
	
	
	public static double[][] generateMatrix(int N) throws Exception{
		if(N <= 0) throw new Exception("Wrong input parameter");
		
		
		double[][] result = new double[N][N];
		Random rand = new Random();
		
		for(int i = 0; i < result.length; i++) {//rows
			for(int j = 0; j < result[i].length;j++) {//columns
				result[i][j] = rand.nextDouble();
			}
		}
		
		return result;
		
	}
	
	public static double[] coinFlip(int N) throws Exception
	{
		if(N <= 0) throw new Exception("Wrong input parameter");
		
		double[] result = new double[3]; // [51,0,0]
		
		Random rand = new Random();
		for(int i = 1; i <= N; i++) {
			boolean isHead = rand.nextBoolean();
			if(isHead) result[0] = result[0] + 1;
			else result[1] = result[1] + 1;
		}
		
		result[2] = result[0]/result[1];
		
		return result;
		
		
	}
	
	
}
