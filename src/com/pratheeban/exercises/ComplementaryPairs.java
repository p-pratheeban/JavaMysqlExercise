package com.pratheeban.exercises;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
/**
 * Find K-complementary pairs in a given array of integers
 * @author Pratheepan
 *
 */
public class ComplementaryPairs {
	/**
	 * Find K-complementary pairs from the given array of integers
	 * Time Complexity is O(n) + O(n) = O(n)
	 * @param k
	 * @param numbers
	 * @return K-complementary pairs
	 */
	public Map<Integer, Integer> getComplementaryPairs(int k, int[] numbers) {
		Map<Integer, Integer> pairs = new LinkedHashMap<>();
		Map<Integer, Integer> complementaryPairs = new LinkedHashMap<>();
		// Time complexity is O(n)
		for (int number : numbers) {
			pairs.put(number, k - number);
		}

		// Time complexity is O(n)
		for (int number : numbers) {
			int complementary = k - number;
			if (pairs.containsKey(complementary)) {
				complementaryPairs.put(number, complementary);
			}
		}
		return complementaryPairs;
	}
	
	/**
	 * Display K-complementary pairs from the given array of integers
	 * @param k
	 * @param numbers
	 */
	public void display(int k, int[] numbers) {
		Map<Integer, Integer> complementaryPairs= getComplementaryPairs(k,numbers);
		System.out.print("K-complementary pairs in a given array " + Arrays.toString(numbers) +" are ");
		complementaryPairs.forEach((x,y)->System.out.print("("+x+ " , " + y +")"));
		System.out.println();
	}
	
	public static void main(String[] args) {
		ComplementaryPairs complementary = new ComplementaryPairs();
		complementary.display(10,new int[]{3,8,7,4,6,2});
		
		ComplementaryPairs complementary1 = new ComplementaryPairs();
		complementary1.display(9,new int[]{1,8,7,4,6,2});
	}
}
