package com.cspinformatique.forms.model;

public class FileUploadAnswer extends Answer {
	private String filePath;
	
	public FileUploadAnswer(){
		
	}
	
	public FileUploadAnswer(int id, Question question, Participant participant, String filePath){
		super(id, question, participant);
		
		this.filePath = filePath;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
}
