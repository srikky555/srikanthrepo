package com.prokarma.logging1;


import java.io.Serializable;
import java.util.List;

public class MainTask extends Abstracttask implements Serializable {

	private static final long serialVersionUID = 1L;
	List<Subtask> sb;
	Person p;
	String description;
	String title;
	Subtask st;

	public MainTask(String title, String description, Person p, List<Subtask> sb)

	{

		this.sb = sb;
		this.p = p;
		this.description = description;
		this.title = title;
	}

	
	public String getDescription() {
		return description;
	}

	public String getTitle() {
		return title;
	}

	
}