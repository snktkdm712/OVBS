package com.app.pojos;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SecondaryTable;
import javax.persistence.SecondaryTables;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="customers")
public class Customer {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	private int cust_id;
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
	@Column(name="address")
	private String Address ;
	@Column(name="aadhar_no")
     private long AadharNo;
	@Column(name="bkstatus" )
	private boolean bkstatus;
	@Column(name="role" )
	private String role ;
	
	
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL,orphanRemoval = true)
	@JsonIgnore
	private List<Booking> bkids;
	
//	@OneToMany(mappedBy = "customer")
//	private List <Request>requests;
	 
	public Customer() {
		System.out.println("in ctor of "+getClass().getName());
	}
	
	public int getCust_id() {
		return cust_id;
	}
	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
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
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public long getAadharNo() {
		return AadharNo;
	}
	public void setAadharNo(long aadharNo) {
		AadharNo = aadharNo;
	}
	public boolean isBkstatus() {
		return bkstatus;
	}

	public void setBkstatus(boolean bkstatus) {
		this.bkstatus = bkstatus;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<Booking> getBkids() {
		return bkids;
	}

	public void setBkids(List<Booking> bkids) {
		this.bkids = bkids;
	}

//	public List<Request> getRequests() {
//		return requests;
//	}

//	public void setRequests(List<Request> requests) {
//		this.requests = requests;
//	}

	@Override
	public String toString() {
		return "Customer [cust_id=" + cust_id + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", contact_no=" + contact_no + ", password=" + password + ", Address=" + Address
				+ ", AadharNo=" + AadharNo + ", bkstatus=" + bkstatus +"]";
	}
	
	
	 
	 

}
