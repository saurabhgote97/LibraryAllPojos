
package com.app.pojos;

import java.util.Date;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="payments")
public class Payment 
{
	private Integer pid;
	private Users user;
	private double amount;
	private PayType type;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date trx_date;
	@JsonFormat(pattern="yyyy-MM-dd")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date due_date;
	
	public Payment() 
	{
		System.out.println("inside the ctr of the payment");
	}

	public Payment(Users user, double amount, PayType type, Date date, Date due_date) {
		super();
		this.user = user;
		this.amount = amount;
		this.type = type;
		this.trx_date = date;
		this.due_date = due_date;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	@ManyToOne
	@JoinColumn(name="user_id")
	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Enumerated(EnumType.STRING)
	@Column(name ="pay_type")
	public PayType getType() {
		return type;
	}

	public void setType(PayType type) {
		this.type = type;
	}

	
	@Temporal(TemporalType.DATE)
	@Column(name="trx_date")
	public Date getDate() {
		return trx_date;
	}

	public void setDate(Date date) {
		this.trx_date = date;
	}

	

	@Temporal(TemporalType.DATE)
	@Column(name="due_date")
	public Date getDue_date() {
		return due_date;
	}

	public void setDue_date(Date due_date) {
		this.due_date = due_date;
	}
	
	
	

	@Override
	public String toString() {
		return "Payment [user=" + user + ", amount=" + amount + ", type=" + type + ", trx_date=" + trx_date
				+ ", due_date=" + due_date + "]";
	}

	
	
	
	

}