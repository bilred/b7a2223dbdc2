package com.devskiller.tasks.blog.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class Comment {

	public Comment() {
	}

	public Comment(String comment, String author, LocalDateTime creationDate) {
		this.comment = comment;
		this.author = author;
		this.creationDate = creationDate;
	}

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private String comment;

	private String author;

	@Column(nullable = false)
	private LocalDateTime creationDate;


	public Long getId() {
		return id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}
}
