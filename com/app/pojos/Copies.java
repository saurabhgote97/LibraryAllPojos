package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "copies")
public class Copies 
{
	private Integer id;
	private int rack;
	private Status status;
	private Book book;
	private List<IssueRecord> list = new ArrayList<>();
	
	public Copies() 
	{
		
	}
	
	public Copies(int rack, Status status, Book book) 
	{
		this.rack = rack;
		this.status = status;
		this.book = book;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	public int getRack() {
		return rack;
	}

	public void setRack(int rack) {
		this.rack = rack;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name = "status")
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
//////////////////////////////////////////////////////////////////////////////////////////
	@ManyToOne
	@JoinColumn(name = "book_id")
	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
////////////////////////////////////////////////////////////////////////////////////////////
	@OneToMany(mappedBy = "copy",cascade = CascadeType.ALL,orphanRemoval = true)
	public List<IssueRecord> getList() {
		return list;
	}

	public void setList(List<IssueRecord> list) {
		this.list = list;
	}	
////////////////////////////////////////////////////////////////////////////////////////////	
	//Helper Method//
	
	public void addIssueRecord(IssueRecord rd)
	{
		this.list.add(rd);
		rd.setCopy(this);
	}
	public void removeIssueRecord(IssueRecord rd)
	{

		this.list.add(rd);
		rd.setCopy(null);
	}
	
	@Override
	public String toString() {
		return "Copies [id=" + id + ", rack=" + rack + ", status=" + status + ", book=" + book + "]";
	}


	
	

	
	
	
	
}
