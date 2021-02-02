package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IVenueOwner;
import com.app.pojos.VenueOwner;

@Service
@Transactional
public class VenueOwnerService implements IVenueOwnerService {

	@Autowired
	private IVenueOwner venueOwnerDao;

	@Override
	public VenueOwner registerVenueOwner(VenueOwner newOwner) {
		
		return venueOwnerDao.save(newOwner);
	}

	@Override
	public List<VenueOwner> getAllVenueOwnerDetails() {
		
		return venueOwnerDao.findAll();
	}

	@Override
	public VenueOwner getVenueOwnerById(int id) {
		
		return venueOwnerDao.getOne(id);
	}

	@Override
	public void changePassword(String email, String newPassword) {
		venueOwnerDao.updatePassword(email, newPassword);
	}

	@Override
	public VenueOwner getVOwnerDetailsByEmail(String email) {
		
		return venueOwnerDao.findByEmail(email);
	}

	@Override
	public void deleteVenueOwnerDetails(int id) {
		venueOwnerDao.deleteById(id);
	}

	
	
}
