package com.pratheeban.exercises;
public class KComplementaryMainApp {
	public static void main(String[] args) {
		ComplementaryPairs complementary = new ComplementaryPairs();
		complementary.display(10,new int[]{3,8,7,4,6,2});
		
		ComplementaryPairs complementary1 = new ComplementaryPairs();
		complementary1.display(9,new int[]{1,8,7,4,6,2});
	}
}
/*
===========Output=========
K-complementary pairs in a given array [3, 8, 7, 4, 6, 2] are (3 , 7)(8 , 2)(7 , 3)(4 , 6)(6 , 4)(2 , 8)
K-complementary pairs in a given array [1, 8, 7, 4, 6, 2] are (1 , 8)(8 , 1)(7 , 2)(2 , 7)


*/