package com.skilli.application.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "GameCategory")
public class GameCategory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "Title")
	private String title;
	
	@Column(name = "Description")
	private String description;
	
	public GameCategory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GameCategory(String title, String description) {
		super();
		this.title = title;
		this.description = description;
	}

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "GameCategory [id=" + id + ", title=" + title + ", description=" + description + "]";
	}
	
}
