package com.app.service;

import java.util.List;

import com.app.pojos.Venues;

public interface IVenueService {

	public Venues addVenue(Venues newVenue);
	public List<Venues> getAllVenues();
	public List<Venues> getv1();
	public List<Venues> getv2();
	public List<Venues> getv3();
	public List<Venues> getv4();
	public Venues getvdetails(String vname);
}
