package com.app.pojos;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="availabledates")
public class AvailableDates implements Serializable{
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;

@Column(name="start_date")
@DateTimeFormat(pattern = "yyyy-MM-dd")
@JsonProperty(value = "start_date")
@JsonIgnore
private LocalDate start_date;

@Column(name="end_date")
@DateTimeFormat(pattern = "yyyy-MM-dd")
@JsonProperty(value = "end_date")
@JsonIgnore
private LocalDate end_date;

@Column(name="bookstatus")
private boolean bookstatus;

@ManyToOne
@JsonIgnore
@JoinColumn(name="v_id")
private Venues venues;

public AvailableDates() {
	System.out.println("in ctor of "+getClass().getName());
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public LocalDate getStart_date() {
	return start_date;
}

public void setStart_date(LocalDate start_date) {
	this.start_date = start_date;
}

public LocalDate getEnd_date() {
	return end_date;
}

public void setEnd_date(LocalDate end_date) {
	this.end_date = end_date;
}

public Venues getVenues() {
	return venues;
}

public void setVenues(Venues venues) {
	this.venues = venues;
}

@Override
public String toString() {
	return "AvailableDates [id=" + id + ", start_date=" + start_date + ", end_date=" + end_date + ", venues=" + venues
			+ "]";
}

public AvailableDates(LocalDate start_date, LocalDate end_date, Venues venues) {
	super();
	this.start_date = start_date;
	this.end_date = end_date;
	this.venues = venues;
}




}
