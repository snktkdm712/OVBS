package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.app.dao.IAdminDao;
import com.app.pojos.Admin;


@Service
@Transactional
public class AdminServiceImpl implements IAdminService {
	// dependency
	@Autowired
	private IAdminDao adminDao;
	
	@Override
	public Admin registerAdmin(Admin admin) {
		return adminDao.save(admin);
	}

	@Override
	public List<Admin> getAllAdmins() {
		// TODO Auto-generated method stub
	
		return adminDao.findAll();
	}

	@Override
	public Admin getAdminById(int id) {

		return adminDao.findById(id).get();
	}

	@Override
	public void changePassword(String newPassword, String email) {
		
		adminDao.updatePassword(newPassword, email);
		
	}

	@Override
	public Optional<Admin> getAdminByEmail(String email) {
		
		return adminDao.findByEmail(email);
	}
	
	
	







	

}
