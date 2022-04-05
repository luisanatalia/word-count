package com.livingit.test.word_count;

import java.util.List;

import com.livingit.test.word_count.model.IWordCount;
import com.livingit.test.word_count.utils.WordScaner;

/**
 * 
 * @author employee
 *
 */
public class WordCountAnalyserImpl implements IWordCountAnalyser{

	@Override
	public Integer CalculateHighestWordCount(final String text) {
		WordScaner scaner = new WordScaner(text);
		return scaner.getTopResult();
	}

	@Override
	public Integer CalculateWordCount(final String text, final String word) {
		WordScaner scaner = new WordScaner(text);
		return scaner.getWordCount(word);
	}

	@Override
	public List<IWordCount> GetMostCountedWords(final String text, final int top) {
		WordScaner scaner = new WordScaner(text);
		return scaner.getTopNResults(top);
	}

}
