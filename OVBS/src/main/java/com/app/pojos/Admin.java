package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="admin")
public class Admin {
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	private int user_id;
	@Column(name="role")
	private String  role;
	@Column(name="firstName")
	private String  firstName ;
	@Column(name="lastName")
	private String lastName;
	@Column(name="email", unique=true)
	private String email;
	@Column(name="contact_no", unique=true)
	private long contact_no;
	@Column(name="password")
	private String password ;
	@Column(name="account_balance")
	private int account_balance;
	
	public Admin() {
		System.out.println("in ctor of "+getClass().getName());
	}
		
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getContact_no() {
		return contact_no;
	}
	public void setContact_no(long contact_no) {
		this.contact_no = contact_no;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAccount_balance() {
		return account_balance;
	}
	public void setAccount_balance(int account_balance) {
		this.account_balance = account_balance;
	}
	
	@Override
	public String toString() {
		return "Admin [user_id=" + user_id + ", role=" + role + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", contact_no=" + contact_no + ", password=" + password + ", account_balance="
				+ account_balance  + "]";
	}
	
	
}
