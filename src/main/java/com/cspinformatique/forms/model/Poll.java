package com.cspinformatique.forms.model;

import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;

@Entity
public class Poll {
	private int id;
	private String title;
	private boolean active;
	private Map<String, String> descriptionByLanguages;
	private Map<String, String> noticeByLanguages;
	private List<QuestionGroup> questionGroups;

	public Poll() {

	}

	public Poll(int id, String title, boolean active,
			Map<String, String> descriptionByLanguages,
			Map<String, String> noticeByLanguages,
			List<QuestionGroup> questionGroups) {
		this.id = id;
		this.title = title;
		this.active = active;
		this.descriptionByLanguages = descriptionByLanguages;
		this.noticeByLanguages = noticeByLanguages;
		this.questionGroups = questionGroups;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
	@Lob
	@ElementCollection
	@Column(columnDefinition="TEXT")
	public Map<String, String> getDescriptionByLanguages() {
		return descriptionByLanguages;
	}

	public void setDescriptionByLanguages(
			Map<String, String> descriptionByLanguages) {
		this.descriptionByLanguages = descriptionByLanguages;
	}
	
	@Lob
	@ElementCollection
	@Column(columnDefinition="TEXT")
	public Map<String, String> getNoticeByLanguages() {
		return noticeByLanguages;
	}

	public void setNoticeByLanguages(Map<String, String> noticeByLanguages) {
		this.noticeByLanguages = noticeByLanguages;
	}

	@OneToMany
	public List<QuestionGroup> getQuestionGroups() {
		return questionGroups;
	}

	public void setQuestionGroups(List<QuestionGroup> questionGroups) {
		this.questionGroups = questionGroups;
	}
}
