package com.livingit.test.word_count;

import java.util.List;

import com.livingit.test.word_count.model.IWordCount;

public class WordCount{
	
	/**
	 * method created to perform functionality of the program. Expected as parameters:
	 * args[0] - text to be scan
	 * args[1] - word to looking for in the text
	 * args[2] - number of top results to get
	 * @param args
	 */
    public static void main( String[] args ){
        IWordCountAnalyser analyser = new WordCountAnalyserImpl();
        
        String text = (args.length > 0? args[0]: "");
        String word = (args.length > 1? args[1]: "");
        Integer top = (args.length > 2? Integer.getInteger(args[2]): Integer.valueOf(1));
        
        System.out.println("Highest word count: " + analyser.CalculateHighestWordCount(text));
        System.out.println("Word '" + word + "' count: " + analyser.CalculateWordCount(text, word));
        
        List<IWordCount> topN = analyser.GetMostCountedWords(text, top);
        System.out.println("Most " + top + " counted words: " + topN.toString());
    }
}
