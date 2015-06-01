package com.cspinformatique.forms.model;

public class TextAnswer extends Answer{
	private String text;
	
	public TextAnswer(){
		super();
	}
	
	public TextAnswer(int id, Question question, Participant participant, String text){
		super(id, question, participant);
		
		this.text = text;
	}
	
	public String getText(){
		return this.text;
	}
	
	public void setText(String text){
		this.text = text;
	}
}
