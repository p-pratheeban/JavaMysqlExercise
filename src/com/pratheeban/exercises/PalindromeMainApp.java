package com.pratheeban.exercises;

public class PalindromeMainApp {
	public static void main(String[] args) {
		Palindrome palindrome = new Palindrome();
		palindrome.display("1221");
		palindrome.display("1121");
		palindrome.display("Noel saw I was Leon.");
		palindrome.display("Live on evasions? No, I save no evil.");
	}
}
/*
=============Output================
1221 is a palindrome
1121 is not a palindrome
Noel saw I was Leon. is a palindrome
Live on evasions? No, I save no evil. is a palindrome
*/