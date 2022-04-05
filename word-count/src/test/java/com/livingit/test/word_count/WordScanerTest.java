package com.livingit.test.word_count;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.livingit.test.word_count.model.IWordCount;
import com.livingit.test.word_count.utils.WordScaner;

/**
 * Test for WordScaner class
 * @author lrey
 */
public class WordScanerTest {
	
	private String text = "hallo hallo lieve, beste VRIEND DEAR, hallo hallo super Vriend, ik hou van je, ik wil hallo zeggen";
	private WordScaner scaner;
	
	@Before
	public void init() {
		scaner = new WordScaner(text);
	}

	@Test
	public void getTopResultTest() {
		int result = scaner.getTopResult();
		assertEquals(5, result);
	}
	
	@Test
	public void getWordCountTest() {
		Integer result = scaner.getWordCount("vrIenD");
		assertEquals(Integer.valueOf(2), result);
		
		Integer nullResult = scaner.getWordCount("hi");
		assertNull(nullResult);
	}
	
	@Test
	public void getTopNResults() {
		List<IWordCount> result = scaner.getTopNResults(3);
		assertEquals(3, result.size());
		assertEquals("[{\"hallo\",5}, {\"ik\",2}, {\"vriend\",2}]", result.toString());
		
		List<IWordCount> exeedResult = scaner.getTopNResults(15);
		assertEquals(12, exeedResult.size());
	}
}
