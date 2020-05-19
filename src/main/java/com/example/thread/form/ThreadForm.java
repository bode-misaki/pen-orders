package com.example.thread.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class ThreadForm {
	@NotBlank(message="{blankMessage}")
	
	private String name;
	
	
	@Size(min=1,max=10,message="{sizeMessage}")
	private String message;
	
	private Integer id;
	
		
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}	
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	

}
