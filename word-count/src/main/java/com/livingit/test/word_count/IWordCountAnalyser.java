package com.livingit.test.word_count;

import java.util.List;

import com.livingit.test.word_count.model.IWordCount;

/**
 * 
 * @author lrey
 *
 */
public interface IWordCountAnalyser {

	/**
	 * Returns the highest word count in the provided text
	 * @param text
	 * @return
	 */
	Integer CalculateHighestWordCount(String text);
	
	/**
	 * Returns the word count for the provided word inside the provided text
	 * @param text
	 * @param word
	 * @return
	 */
	Integer CalculateWordCount(String text, String word);
	
	/**
	 * Returns the words that are counted the most including the number of times that 
	 * the word occurred in the text. Take only the top results specified by ‘top’
	 * @param text
	 * @param top
	 * @return
	 */
	List<IWordCount> GetMostCountedWords(String text, int top);
}
