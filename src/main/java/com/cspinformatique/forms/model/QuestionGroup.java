package com.cspinformatique.forms.model;

import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class QuestionGroup {
	private int id;
	private Map<String, String> titleByLanguages;
	private Map<String, String> descriptionByLanguages;
	private List<Question> questions;
	
	public QuestionGroup(){
		
	}

	public QuestionGroup(int id, Map<String, String> titleByLanguages,
			Map<String, String> descriptionByLanguages, List<Question> questions) {
		this.id = id;
		this.titleByLanguages = titleByLanguages;
		this.descriptionByLanguages = descriptionByLanguages;
		this.questions = questions;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@ElementCollection
	public Map<String, String> getTitleByLanguages() {
		return titleByLanguages;
	}

	public void setTitleByLanguages(Map<String, String> titleByLanguages) {
		this.titleByLanguages = titleByLanguages;
	}

	@ElementCollection
	public Map<String, String> getDescriptionByLanguages() {
		return descriptionByLanguages;
	}

	public void setDescriptionByLanguages(Map<String, String> descriptionByLanguages) {
		this.descriptionByLanguages = descriptionByLanguages;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> question) {
		this.questions = question;
	}
}
