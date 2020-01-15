package com.app.pojos;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.app.pojos.*;
import javax.persistence.*;

@Entity
@Table(name = "IssueRecord")
public class IssueRecord 
{
	private Integer id;
	private Users user;
	@JsonFormat(pattern="yyyy-MM-dd")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date issueDate;
	@JsonFormat(pattern="yyyy-MM-dd")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dueDate;
	@JsonFormat(pattern="yyyy-MM-dd")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date returnDate;
	private double amount;
	private Copies copy;
	

	public IssueRecord() 
	{
		
	}
	
	public IssueRecord(Users user, Date issueDate, Date dueDate, Date returnDate, double amount) 
	{

		this.user = user;
		this.issueDate = issueDate;
		this.dueDate = dueDate;
		this.returnDate = returnDate;
		this.amount = amount;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() 
	{
		return id;
	}

	public void setId(Integer id) 
	{
		this.id = id;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "issue_date")
	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "due_date")
	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}


	@Temporal(TemporalType.DATE)
	@Column(name = "return_date")
	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
/////////////////////////////////////////////////////////////////////////////////////////
	@ManyToOne
	@JoinColumn(name = "copy_id")
	public Copies getCopy() {
		return copy;
	}

	public void setCopy(Copies copy) {
		this.copy = copy;
	}
/////////////////////////////////////////////////////////////////////////////////////////
	@ManyToOne
	@JoinColumn(name = "user_id")
	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}
	
	@Override
	public String toString() {
		return "IssueRecord [id=" + id + ", user=" + user + ", issueDate=" + issueDate
				+ ", dueDate=" + dueDate + ", returnDate=" + returnDate + ", amount=" + amount + "]";
	}
	
	
}

