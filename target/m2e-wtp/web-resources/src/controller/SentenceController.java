package controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import model.FirstQuestionResponse;
import model.InputResource;
import model.SecondQuestionResponse;

@RestController
public class SentenceController {
	
	/**
	 * 
	 * @param request
	 * @return individual sentences along with a word count for the sentence. 
	 */

	@RequestMapping(method = RequestMethod.POST, value="/word_count_per_sentence")
	@ResponseBody
	public FirstQuestionResponse wordCountPerSentence(@RequestBody InputResource request) {

		FirstQuestionResponse outputResponse = new FirstQuestionResponse();
		String inputSentence = request.getSentence();
		//  a sentence is any grouping of letters and words ending in a period, question mark or exclamation point. 
		String[] sentences = inputSentence.split("\\.|\\!|\\?");
		Map<String, Integer> word_count_per_sentence =  new LinkedHashMap<String, Integer>();
		for (int i = 0; i < sentences.length; i++) {
			String eachSentence = sentences[i];
			String trimmedSentence = eachSentence.trim();
			// A word is text delimited by spaces. 
			word_count_per_sentence.put(trimmedSentence, trimmedSentence.split(" ").length);
		}
		outputResponse.setIndividualSentences(word_count_per_sentence);
		return outputResponse;
	}
	
	/**
	 * 
	 * @param request
	 * @return For each case-insensitive letter, return the number of times that letter appears in the entire text. 
	 */
	@RequestMapping(method = RequestMethod.POST, value="/total_letter_count")
	@ResponseBody SecondQuestionResponse totalLetterCount(@RequestBody InputResource request) {

		SecondQuestionResponse outputResponse = new SecondQuestionResponse();
		String inputSentence = request.getSentence().toUpperCase().replaceAll("[^a-zA-Z]", "").trim();
		
		char [] alphabets = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
		String finalResponse = "The text contains ";
		for (int i = 0; i < alphabets.length; i++) {
			final char alpha = alphabets[i];
			long charCount = inputSentence.codePoints().filter(ch -> ch ==alpha).count();
			finalResponse = finalResponse+charCount+" "+alpha+"s, ";
		}
		if(finalResponse.endsWith(", "))
		{
			finalResponse = finalResponse.substring(0,finalResponse.length() - 2);
		}
		outputResponse.setResult(finalResponse);
		return outputResponse;
	}
}
