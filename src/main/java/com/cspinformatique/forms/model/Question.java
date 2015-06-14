package com.cspinformatique.forms.model;

import java.util.Map;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Question {
	public static enum Type {
		OPTIONS, TEXT, TEXTAREA, FILE_UPLOAD
	}

	private int id;
	private int number;
	private Type type;
	private boolean mandatory;
	private Map<String, String> questionsByLanguage;
	private Map<String, String> answerExempleByLanguages;
	private Map<String, LanguageOptions> optionsByLanguages;
	private boolean displayedInSummary;

	public Question() {

	}

	public Question(int id, int number, Type type, boolean mandatory,
			Map<String, String> questionsByLanguage,
			Map<String, String> answerExempleByLanguages,
			Map<String, LanguageOptions> optionsByLanguages,
			boolean displayedInSummary) {
		this.id = id;
		this.number = number;
		this.type = type;
		this.mandatory = mandatory;
		this.questionsByLanguage = questionsByLanguage;
		this.answerExempleByLanguages = answerExempleByLanguages;
		this.optionsByLanguages = optionsByLanguages;
		this.displayedInSummary = displayedInSummary;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	@Enumerated(EnumType.STRING)
	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public boolean isMandatory() {
		return mandatory;
	}

	public void setMandatory(boolean mandatory) {
		this.mandatory = mandatory;
	}

	@ElementCollection
	public Map<String, String> getQuestionsByLanguage() {
		return questionsByLanguage;
	}

	public void setQuestionsByLanguage(Map<String, String> questionsByLanguage) {
		this.questionsByLanguage = questionsByLanguage;
	}

	@ElementCollection
	public Map<String, String> getAnswerExempleByLanguages() {
		return answerExempleByLanguages;
	}

	public void setAnswerExempleByLanguages(
			Map<String, String> answerExempleByLanguages) {
		this.answerExempleByLanguages = answerExempleByLanguages;
	}

	@ElementCollection
	public Map<String, LanguageOptions> getOptionsByLanguages() {
		return optionsByLanguages;
	}

	public void setOptionsByLanguages(
			Map<String, LanguageOptions> optionsByLanguages) {
		this.optionsByLanguages = optionsByLanguages;
	}

	public boolean isDisplayedInSummary() {
		return displayedInSummary;
	}

	public void setDisplayedInSummary(boolean displayedInSummary) {
		this.displayedInSummary = displayedInSummary;
	}

}
