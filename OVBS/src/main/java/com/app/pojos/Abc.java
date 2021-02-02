package com.app.pojos;

public class Abc {
private int booking_id;
private String bkdate;
private int b_days;
private boolean p_status;
private int cust_id;
private int venue_id;
private String vname;
public Abc(int booking_id, String bkdate, int b_days, boolean p_status, int cust_id, int venue_id, String vname) {
	super();
	this.booking_id = booking_id;
	this.bkdate = bkdate;
	this.b_days = b_days;
	this.p_status = p_status;
	this.cust_id = cust_id;
	this.venue_id = venue_id;
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
	this.bkdate = bkdate;
}
public int getB_days() {
	return b_days;
}
public void setB_days(int b_days) {
	this.b_days = b_days;
}
public boolean isP_status() {
	return p_status;
}
public void setP_status(boolean p_status) {
	this.p_status = p_status;
}
public int getCust_id() {
	return cust_id;
}
public void setCust_id(int cust_id) {
	this.cust_id = cust_id;
}
public int getVenue_id() {
	return venue_id;
}
public void setVenue_id(int venue_id) {
	this.venue_id = venue_id;
}
public String getVname() {
	return vname;
}
public void setVname(String vname) {
	this.vname = vname;
}


}
