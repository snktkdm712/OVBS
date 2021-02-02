//package com.app.pojos;
//
//import javax.persistence.*;
//
//
//@Entity
//@Table(name="requests")
//public class Request {
//@Id
//@GeneratedValue(strategy =GenerationType.IDENTITY)
//	private  int req_id;
//
//@ManyToOne
//@JoinColumn(name="cust_id")
//private Customer customer;
//
//@ManyToOne
//@JoinColumn(name="ids")
//private Venues venues;
//
//@OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
//@JoinColumn(name="bkdate",referencedColumnName = "bkdate")
//private Booking booking;
//
//@Column(name="approve")
//private boolean approve;
//
//public Request() {
//	System.out.println("in ctor of "+getClass().getName());
//}
//
//public Request(Customer customer, Venues venues, Booking booking, boolean approve) {
//	super();
//	this.customer = customer;
//	this.venues = venues;
//	this.booking = booking;
//	this.approve = approve;
//}
//
//public int getReq_id() {
//	return req_id;
//}
//
//public void setReq_id(int req_id) {
//	this.req_id = req_id;
//}
//
//public Customer getCustomer() {
//	return customer;
//}
//
//public void setCustomer(Customer customer) {
//	this.customer = customer;
//}
//
//public Venues getVenues() {
//	return venues;
//}
//
//public void setVenues(Venues venues) {
//	this.venues = venues;
//}
//
//public Booking getBooking() {
//	return booking;
//}
//
//public void setBooking(Booking booking) {
//	this.booking = booking;
//}
//
//public boolean isApprove() {
//	return approve;
//}
//
//public void setApprove(boolean approve) {
//	this.approve = approve;
//}
//
//@Override
//public String toString() {
//	return "Request [req_id=" + req_id + ", customer=" + customer + ", venues=" + venues + ", booking=" + booking
//			+ ", approve=" + approve + "]";
//}
//
//
//
//}
//
