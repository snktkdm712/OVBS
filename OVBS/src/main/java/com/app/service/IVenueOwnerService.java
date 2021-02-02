package com.app.service;

import java.util.List;

import com.app.pojos.VenueOwner;

public interface IVenueOwnerService {

	public VenueOwner registerVenueOwner(VenueOwner newOwner);
	public List<VenueOwner> getAllVenueOwnerDetails();
	public VenueOwner getVenueOwnerById(int id);
	public void changePassword(String email,String newPassword);
	public void deleteVenueOwnerDetails(int id);
	public VenueOwner getVOwnerDetailsByEmail(String email); 
}
