package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="items")
public class ListItem {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	@Column(name="TITLE")
	private String title;
	@Column(name="ISBN")
	private String isbn;
	@Column(name="AUTHOR")
	private String author;
	@Column(name="SUBJECT")
	private String subject;
	@Column(name="PUBLISHED")
	private String published;
	
	// constructors
	public ListItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ListItem(String title, String isbn, String author, String subject, String published) {
		this.title = title;
		this.isbn = isbn;
		this.author = author;
		this.subject = subject;
		this.published = published;
	}

	// setters + getters
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

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getPublished() {
		return published;
	}

	public void setPublished(String published) {
		this.published = published;
	}

	@Override
	public String toString() {
		return "ListItem [id=" + id + ", title=" + title + ", isbn=" + isbn + ", author=" + author + ", subject="
				+ subject + ", published=" + published + "]";
	}


	

}
