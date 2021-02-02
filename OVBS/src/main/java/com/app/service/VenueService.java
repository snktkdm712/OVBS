package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.IVenues;
import com.app.pojos.Venues;

@Service
public class VenueService implements IVenueService {

	@Autowired
	private IVenues venueDao;
	
	@Override
	public Venues addVenue(Venues newVenue) {
		
		return venueDao.save(newVenue);
	}

	@Override
	public List<Venues> getAllVenues() {

		return venueDao.findAll();
	}

	@Override
	public List<Venues> getv1() {
		// TODO Auto-generated method stub
		return venueDao.findbyloc("Koregaon Park");
	}

	@Override
	public List<Venues> getv2() {
		// TODO Auto-generated method stub
		return venueDao.findbyloc("shivajinagar");
	}

	@Override
	public List<Venues> getv3() {
		// TODO Auto-generated method stub
		return venueDao.findbyloc("balajinagar");
	}

	@Override
	public List<Venues> getv4() {
		// TODO Auto-generated method stub
		return venueDao.findbyloc("vimannagar");
	}

	@Override
	public Venues getvdetails(String vname) {
		
		return venueDao.findbyname(vname);
	}

}
