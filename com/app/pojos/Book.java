 package com.app.pojos;

import java.util.ArrayList;
import java.util.List;


import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


import javax.persistence.*;

@Entity
@Table(name = "books")
public class Book 
{
	private Integer id;
	private String name;
	private String author;
	private String subject;
	private double price;
	private String isbn;
	@JsonIgnore
	private List<Copies> list = new ArrayList<>();
	
	public Book() 
	{
	
	}
	
	public Book(String name, String author, String subject, double price, String isbn) 
	{
		this.name = name;
		this.author = author;
		this.subject = subject;
		this.price = price;
		this.isbn = isbn;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(columnDefinition = "varchar(50)")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	
	@Column(name = "price",columnDefinition = "double(6,2)")
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	
	@OneToMany(mappedBy = "book",cascade = CascadeType.ALL,orphanRemoval = true)
	public List<Copies> getList() {
		return list;
	}

	public void setList(List<Copies> list) {
		this.list = list;
	}

	
	//////////////////////////////////////////////Help Method///////////////////////////////////////////
	public void addBooks(Copies b)
	{
		list.add(b);
		b.setBook(this);
	}
	public void removeBooks(Copies b)
	{
		list.remove(b);
		b.setBook(null);
	}
	
	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", author=" + author + ", subject=" + subject + ", price=" + price
				+ ", isbn=" + isbn + "]";
	}
	
	
	
}
