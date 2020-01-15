
package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Pattern;


import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="user")
public class Users 
{
	private Integer id;
	private String name;
	
	@NotEmpty(message = "email should not be empty")
	@Email(message = "Email is not valid")
	private String email;
	//1.
	@JsonIgnore
	private List<IssueRecord> records = new ArrayList<>();
	
	private long phone;
	
	@Pattern(regexp="((?=.*\\d)(?=.*[a-z])(?=.*[#@$*]).{5,20})",message="Invalid Password format")
	private String password;
	private Role role;
	//2.
	@JsonIgnore
	private List<Payment> pay = new ArrayList<>();
	
	
	public Users() 
	{
		System.out.println("inside the ctr of the user");
		
	}


	public Users(String name, String email, long phone, String password, Role role) 
	{
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.password = password;
		this.role = role;
	}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}

    @Column(name="name")
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

    
	@Column(length=20,unique = true)
	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}

    
	@Column(length = 10)
	public long getPhone() {
		return phone;
	}


	public void setPhone(long phone) {
		this.phone = phone;
	}

   @Column(length= 20,nullable = false)
	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

     @Enumerated(EnumType.STRING)
     @Column(name="role")
	public Role getRole() {
		return role;
	}


	public void setRole(Role role) {
		this.role = role;
	}

	//////////////////////////////////////////1./////////////////////////////////////////////
	
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.EAGER)
	public List<Payment> getPay() {
		return pay;
	}


	public void setPay(List<Payment> pay) {
		this.pay = pay;
	}
	///////////////////////////////////////////////////////////////////////////////////////
	public void addPayment(Payment p)
	{
		pay.add(p);
		p.setUser(this);
	}
	

	public void removePayment(Payment p)
	{
		pay.remove(p);
		p.setUser(null);
	}

	//////////////////////////////////////////2./////////////////////////////////////////////	
    
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL,orphanRemoval = true)	
	public List<IssueRecord> getRecords() {
		return records;
	}


	public void setRecords(List<IssueRecord> records) {
		this.records = records;
	}


	////////////////////////////////////////////////////////////////////////////////////

	public void addPayment(IssueRecord rd)
	{
		records.add(rd);
		rd.setUser(this);
	}
	
	public void removeRecords(IssueRecord rd)
	{
		records.remove(rd);
		rd.setUser(null);
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", email=" + email + ", phone=" + phone + ", role=" + role + "]";
	}
	
	

}
