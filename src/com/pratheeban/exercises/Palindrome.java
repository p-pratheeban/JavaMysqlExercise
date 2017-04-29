package com.pratheeban.exercises;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * @author Pratheepan
 * Check if a string is a palindrome or not
 */
public class Palindrome {
	/**
	 * Check whether the given input string is palindrome or not
	 * The time complexity of reverse() is O(n). So it would be done in o(n)
	 * @param inputStr
	 * @return true if string is palindrome otherwise return false
	 */
	public boolean isPalindrome(String inputStr){
		
		if (inputStr == null || inputStr ==""){
			return false;
		}
		String input = getOnlyString(inputStr.trim().toLowerCase());
		StringBuilder sb = new StringBuilder(input);
	    StringBuilder reverse = sb.reverse();
	    if (input.trim().toLowerCase().equals(String.valueOf(reverse))){
	        return true;
	    }
	    return false;
	}
	
	/**
	 * Display the result whether the given input string is palindrome or not
	 * @param inputStr
	 */
	public void display(String inputStr){
		if(isPalindrome(inputStr)){
			System.out.println(inputStr+ " is a palindrome");
		}
		else{
			System.out.println(inputStr+ " is not a palindrome");
		}
	}
	/**
	 * Remove special characters and space from string
	 * @param str
	 * @return a string without having special characters or space
	 */
	public String getOnlyString(String str) {
	    Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");
	    Matcher matcher = pattern.matcher(str);
	    return matcher.replaceAll("");
	}
		
	public static void main(String[] args) {
		Palindrome palindrome = new Palindrome();
		palindrome.display("1221");
		palindrome.display("1121");
		palindrome.display("Noel saw I was Leon.");
		palindrome.display("Live on evasions? No, I save no evil.");
	}
}
