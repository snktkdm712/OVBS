package com.app.pojos;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="venues" ,schema = "your_schema")
public class Venues implements Serializable {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	private int v_id;
	@Column(name="vname", unique = false)
	private String vname;
	@Column(name="specific_area")
	private String specific_area;
	@Column(name="city")
	private String city;   
	@Column(name="vaddress")
	private String vaddress;
	@Column(name="vrate")
	private int vrate;
	@Column(name="vservices")
	private boolean ExtraVenueServices;
	@Lob
	@Column(name="description")
	private String description;
	@Column(name="contact_no")
	private String contact_no;
	
//	@OneToMany(mappedBy = "venues",cascade = CascadeType.ALL )
//	private Set <Request>requests;
	
	@OneToMany(mappedBy = "venues")
	@JsonIgnore
	private List <AvailableDates> availabledates;
	
	@OneToMany(mappedBy = "venue")
	@JsonIgnore
	private List <Booking> bookings ;
	
	@OneToMany(mappedBy = "vname")
	@JsonIgnore
	private List <Booking> booking ;
	
	public Venues() {
		System.out.println("in ctor of "+getClass().getName());
	}

	public Venues(String vname, String specific_area, String city, String vaddress, int vrate,
			boolean extraVenueServices, String description, String contact_no) {
		super();
		this.vname = vname;
		this.specific_area = specific_area;
		this.city = city;
		this.vaddress = vaddress;
		this.vrate = vrate;
		ExtraVenueServices = extraVenueServices;
		this.description = description;
		this.contact_no = contact_no;
	}

	public int getV_id() {
		return v_id;
	}

	public void setV_id(int v_id) {
		this.v_id = v_id;
	}

	public String getVname() {
		return vname;
	}

	public void setVname(String vname) {
		this.vname = vname;
	}

	public String getSpecific_area() {
		return specific_area;
	}

	public void setSpecific_area(String specific_area) {
		this.specific_area = specific_area;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getVaddress() {
		return vaddress;
	}

	public void setVaddress(String vaddress) {
		this.vaddress = vaddress;
	}

	public int getVrate() {
		return vrate;
	}

	public void setVrate(int vrate) {
		this.vrate = vrate;
	}

	public boolean isExtraVenueServices() {
		return ExtraVenueServices;
	}

	public void setExtraVenueServices(boolean extraVenueServices) {
		ExtraVenueServices = extraVenueServices;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getContact_no() {
		return contact_no;
	}

	public void setContact_no(String contact_no) {
		this.contact_no = contact_no;
	}

//	public Set<Request> getRequests() {
//		return requests;
//	}
//
//	public void setRequests(Set<Request> requests) {
//		this.requests = requests;
//	}

	public List<AvailableDates> getAvailabledates() {
		return availabledates;
	}

	public void setAvailabledates(List<AvailableDates> availabledates) {
		this.availabledates = availabledates;
	}

	public List<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}

	public List<Booking> getBooking() {
		return booking;
	}

	public void setBooking(List<Booking> booking) {
		this.booking = booking;
	}

	@Override
	public String toString() {
		return "Venues [v_id=" + v_id + ", vname=" + vname + ", specific_area=" + specific_area + ", city=" + city
				+ ", vaddress=" + vaddress + ", vrate=" + vrate + ", ExtraVenueServices=" + ExtraVenueServices
				+ ", description=" + description + ", contact_no=" + contact_no
				+ ", availabledates=" + availabledates + ", bookings=" + bookings + ", booking=" + booking + "]";
	}

	


	
}
