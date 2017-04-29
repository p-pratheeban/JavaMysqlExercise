package com.pratheeban.exercises;
import java.io.File;
import java.io.IOException;

public class TopKPhrasesMainApp {
	public static void main(String[] args) {
		TopPhrases topPhrases = new TopPhrases();
		try{
			File file= new File("phrases.txt");
			topPhrases.display(file,10);
			topPhrases.display(file,4);
		}catch(IOException e){
			System.out.println("Exception while reading a file "+ e.getMessage());
		}
	}
}
/*
==============Output================
Top 10 most frequent phrases.
(foobar candy , 19)
(cnet , 19)
(ibm , 19)
(microsoft bing , 14)
(ascii , 12)
(olympics 2017 , 11)
(pga , 10)
(vga , 9)
(unicode , 7)
(google , 5)


Top 4 most frequent phrases.
(foobar candy , 19)
(cnet , 19)
(ibm , 19)
(microsoft bing , 14)
*/