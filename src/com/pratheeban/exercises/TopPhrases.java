package com.pratheeban.exercises;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
/**
 * Find the top K number of  most frequent phrases
 * @author Pratheepan
 *
 */
public class TopPhrases {
	/**
	 * Find the top K number of  most frequent phrases from large file
	 * @param file
	 * @param k
	 * @return
	 * @throws IOException
	 */
	public Map<String, Integer> getTopKPhrases(File file, int k) throws IOException {
		String line = null;

		Map<String, Integer> phrasesMap = new LinkedHashMap<String, Integer>();
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
			while ((line = bufferedReader.readLine()) != null) {
				String[] linePhrases = line.toLowerCase().trim().split("\\|");
				for (String phrase : linePhrases) {
					int freq = 1;
					if (phrasesMap.containsKey(phrase.trim())) {
						freq = phrasesMap.get(phrase.trim()) + 1;
					}
					phrasesMap.put(phrase.trim(), freq);
				}
			}
		}
		Map<String, Integer> topPhrasesMap = phrasesMap.entrySet().stream()
				.sorted(Map.Entry.<String, Integer> comparingByValue().reversed()).limit(k)
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));

		return topPhrasesMap;
	}
	/**
	 * Display the top K number of  most frequent phrases from large file
	 * @param file
	 * @param k
	 * @throws IOException
	 */
	public void display(File file, int k) throws IOException{
		System.out.println("Top " + k + " most frequent phrases. ");
		Map<String, Integer> topPhrasesMap = getTopKPhrases(file,k);
		topPhrasesMap.forEach((x,y)->System.out.println("("+x+ " , " + y +")"));
	}
	
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
