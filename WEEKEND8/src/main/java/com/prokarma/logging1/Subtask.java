package com.prokarma.logging1;


import java.io.Serializable;

public class Subtask extends Abstracttask implements Serializable {

	private static final long serialVersionUID = 1L;
	protected int estimatehours ;
	 Person p1;
	 String title;
	 String description;
	 public String getTitle() {
		return title;
	}
	public String getDescription() {
		return description;
	}
	public Subtask(String title, String description,Person p1,int estimatehours)
	
	{
		super();
		this.description=description;
		this.title = title;		
		this.estimatehours=estimatehours;
		this.p1=p1;
	
	}
}