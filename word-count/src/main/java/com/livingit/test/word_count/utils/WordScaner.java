package com.livingit.test.word_count.utils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.TreeMap;

import com.livingit.test.word_count.model.IWordCount;
import com.livingit.test.word_count.model.WordCountImpl;

/**
 * Class to perform operations over a given text
 * @author lrey
 */
public class WordScaner {

	private Map<String, Integer> words;
	
	/**
	 * Constructor: receive text to be scan
	 * @param newText
	 */
	public WordScaner(final String newText) {
		this.words  = new HashMap<>();
		
		String itText = newText;
		
		while (!itText.isEmpty()) {
			String[] twoWords = itText.split("[ ,.]+", 2);
			String word = twoWords[0].toLowerCase();
			
			words.put(word, words.containsKey(word) ? words.get(word) + 1 : 1);
			
			if(twoWords.length > 1) {
				itText = twoWords[1];
			}else {
				itText = "";
			}
		}
	}
	
	/**
	 * Return number of occurrences from the given word
	 * @param word
	 * @return
	 */
	public Integer getWordCount(String word) {
		return words.get(word.toLowerCase());
	}
	
	/**
	 * Method that get the top n records from the sortedMap and convert to IWordCount object
	 * @param n
	 * @return
	 */
	public List<IWordCount> getTopNResults(int n){
		List<IWordCount> result = new ArrayList<>();
		TreeMap <String, Integer> ordered = (TreeMap<String, Integer>) getOrderedResults();
		int i = 0;
		
		for (Iterator<String> iterator = ordered.keySet().iterator(); iterator.hasNext() && i<n;) {
			String key = iterator.next();
			IWordCount wordCount = new WordCountImpl(key, ordered.get(key));
			result.add(wordCount);
			i++;
		}
		
		return result;
	}
	
	/**
	 * Return the top result form the sorted map
	 * @return
	 */
	public Integer getTopResult() {
		TreeMap <String, Integer> ordered = (TreeMap<String, Integer>) getOrderedResults();
		Entry<String, Integer> entry = ordered.firstEntry();
		return (entry != null? entry.getValue(): null);
	}
	
	/**
	 * Method that takes hashMap and convert into a sortedMap. Order using MapComparator class
	 * @param text
	 * @return
	 */
	private SortedMap <String, Integer> getOrderedResults(){
		MapComparator comparator = new MapComparator(this.words);
		TreeMap <String, Integer> ordered = new TreeMap <>(comparator);
		ordered.putAll(this.words);
		return ordered;
	}
	
	/**
	 * Comparator class to perform order using the number of occurrences and then alphabetic order
	 * @author lrey
	 */
	class MapComparator implements Comparator<String> {
	    Map<String, Integer> base;

	    public MapComparator(Map<String, Integer> base) {
	        this.base = base;
	    }

	    public int compare(String a, String b) {
	        if (base.get(a) > base.get(b)) {
	            return -1;
	        } else if (base.get(a) < base.get(b)) {
	            return 1;
	        } else {
	        	return a.compareTo(b);
	        }
	    }
	}
}
