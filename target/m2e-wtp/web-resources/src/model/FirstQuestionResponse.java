package model;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstQuestionResponse {
	private Map<String, Integer> individualSentences = new LinkedHashMap<String, Integer>();

	public Map<String, Integer> getIndividualSentences() {
		return individualSentences;
	}

	public void setIndividualSentences(Map<String, Integer> individualSentences) {
		this.individualSentences = individualSentences;
	}
}
