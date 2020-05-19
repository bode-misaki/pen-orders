package com.example.thread.entity;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="threads")
public class ThreadEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	
	private String message;
	
	@OneToMany
	@JoinColumn(name="reply_id",insertable=false,updatable=false)
	private List<ReplyEntity> replyEntity;
	
	public List<ReplyEntity> getReplyEntity(){
		return replyEntity;
	}
	
	public void getReplyEntity(List<ReplyEntity> replyEntity){
		this.replyEntity = replyEntity;
	}
	
	
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
