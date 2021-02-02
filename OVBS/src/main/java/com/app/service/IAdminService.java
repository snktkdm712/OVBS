package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.pojos.Admin;


public interface IAdminService {

	public List<Admin>getAllAdmins();
	// add new Admin details
	public Admin registerAdmin(Admin admin);
	public Admin getAdminById(int id);
	public void changePassword(String newPassword,String email);
	public Optional<Admin> getAdminByEmail(String email);
}
