package com.cspinformatique.forms.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class PollParticipantAnswers {
	private int id;
	private Poll poll;
	private List<Answer> answers;

	public PollParticipantAnswers() {

	}

	public PollParticipantAnswers(int id, Poll poll, List<Answer> answers) {
		this.id = id;
		this.poll = poll;
		this.answers = answers;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@ManyToOne
	public Poll getPoll() {
		return poll;
	}

	public void setPoll(Poll poll) {
		this.poll = poll;
	}

	@OneToMany(cascade = CascadeType.ALL)
	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}
}
