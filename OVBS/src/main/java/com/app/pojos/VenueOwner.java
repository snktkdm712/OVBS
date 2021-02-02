package com.app.pojos;

import java.awt.Image;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "venueowner")
public class VenueOwner {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int vOwner_id;
	@Column(name = "firstName")
	private String FirstName;
	@Column(name = "lastName")
	private String lastName;
	@Column(name = "email", unique = true)
	private String email;
	@Column(name = "contact_no", unique = true)
	private long contact_no;
	@Column(name = "vname")
	private String vname;
	@Column(name = "role")
	private String role;
	@Column(name = "password")
	private String password;

	public VenueOwner() {
		System.out.println("in ctor of " + getClass().getName());
	}

	public VenueOwner(String firstName, String lastName, String email, long contact_no, String vname, String role,
			String password) {
		super();
		FirstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.contact_no = contact_no;
		this.vname = vname;
		this.role = role;
		this.password = password;
	}

	public int getvOwner_id() {
		return vOwner_id;
	}

	public void setvOwner_id(int vOwner_id) {
		this.vOwner_id = vOwner_id;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
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

	public String getVname() {
		return vname;
	}

	public void setVname(String vname) {
		this.vname = vname;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "VenueOwner [vOwner_id=" + vOwner_id + ", FirstName=" + FirstName + ", lastName=" + lastName + ", email="
				+ email + ", contact_no=" + contact_no + ", vname=" + vname + ", role=" + role + "]";
	}

}
