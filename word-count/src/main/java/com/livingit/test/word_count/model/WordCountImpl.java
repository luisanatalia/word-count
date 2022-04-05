package com.livingit.test.word_count.model;

/**
 * 
 * @author lrey
 *
 */
public class WordCountImpl implements IWordCount{
	private String word;
	private Integer count;

	/**
	 * Constructor: received values as parameter to be initialized
	 * @param newWord
	 * @param newCount
	 */
	public WordCountImpl(String newWord, Integer newCount) {
		this.word = newWord;
		this.count = newCount;
	}

	/**
	 * @return the word
	 */
	public String getWord() {
		return word;
	}

	/**
	 * @return the count
	 */
	public Integer getCount() {
		return count;
	}
	
	@Override
	public String toString() {
		return String.format("{\"%s\",%d}", this.word, this.count);
	}
	
}
