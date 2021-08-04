package com.skilli.application.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
* Model
* Consist all Game Table Element
* @author  Pramatma Ram
* 
*/

@Entity
@Table(name = "Game")
public class Game {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name="title")
	private String title;
	
	@Column(name="category")
	private String category;
	
	@Column(name="imageUrl")
	private String imageUrl;
	
	public Game() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Game(String title, String category ,String imageUrl) {
		super();
		this.title = title;
		this.category = category;
		this.imageUrl = imageUrl;
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	@Override
	public String toString() {
		return "Game [id=" + id + ", title=" + title + ", category=" + category + ", imageUrl=" + imageUrl + "]";
	}
	
}
