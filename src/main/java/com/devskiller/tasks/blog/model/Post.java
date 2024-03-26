package com.devskiller.tasks.blog.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Post {

	public Post() {}

	public Post(String title, String content, LocalDateTime creationDate, List<Comment> comments) {
		this.title = title;
		this.content = content;
		this.comments = comments;
		this.creationDate = creationDate;
	}

	@Id
	@GeneratedValue
	private Long id;

	private String title;

	@Column(length = 4096)
	private String content;

	@OneToMany(fetch = FetchType.LAZY)
	private List<Comment> comments;

	private LocalDateTime creationDate;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

	public Long getId() {
		return id;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
}
