package com.app.pojos;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

//@SuppressWarnings("serial")
@Entity
@Table(name="bookings")
public class Booking {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	private int booking_id;
@Column(name="bkdate")
private String bkdate;
@Column(name="b_days")
private int booking_days	;
@Column(name="p_status")
private boolean payment_status;	

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="cust_id")

	private Customer customer;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="venue_id")

	private Venues venue;

//	@OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL , mappedBy = "booking")
//	private Request request;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="vname",referencedColumnName = "vname")

	private Venues vname;

	public Booking() {
		System.out.println("in ctor of "+getClass().getName());
	}

	public Booking(String bkdate, int booking_days, boolean payment_status, Customer customer, Venues venues,
			 Venues vname) {
		super();
		this.bkdate = bkdate;
		this.booking_days = booking_days;
		this.payment_status = payment_status;
		this.customer = customer;
		this.venue = venues;
//		this.request = request;
		this.vname = vname;
	}

	public int getBooking_id() {
		return booking_id;
	}

	public void setBooking_id(int booking_id) {
		this.booking_id = booking_id;
	}

	public String getBkdate() {
		return bkdate;
	}

	public void setBkdate(String bkdate) {
		this.bkdate =  bkdate;
	}

	public int getBooking_days() {
		return booking_days;
	}

	public void setBooking_days(int booking_days) {
		this.booking_days = booking_days;
	}

	public boolean isPayment_status() {
		return payment_status;
	}

	public void setPayment_status(boolean payment_status) {
		this.payment_status = payment_status;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Venues getVenues() {
		return venue;
	}

	public void setVenues(Venues venues) {
		this.venue = venues;
	}

//	public Request getRequest() {
//		return request;
//	}

//	public void setRequest(Request request) {
//		this.request = request;
//	}

	public Venues getVname() {
		return vname;
	}

	public void setVname(Venues vname) {
		this.vname = vname;
	}

	@Override
	public String toString() {
		return "Booking [booking_id=" + booking_id + ", bkdate=" + bkdate + ", booking_days=" + booking_days
				+ ", payment_status=" + payment_status + ", customer=" + customer + ", venues=" + venue + ", request="
			 + ", vname=" + vname + "]";
	}







	
}
