package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.IUserdao;
import com.app.pojos.User;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserdao userDao;
	
	@Override
	public void addCredintials(User u) {
		
		userDao.save(u);
	}

	@Override
	public User validateUser(String email, String password) {
		
		return userDao.findByEmailAndPassword(email,password);
	}

	@Override
	public void updatePassword(String email, String password) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(int id) {
		// TODO Auto-generated method stub
		
	}

	
	
//	  @Override public void updatePassword(String email, String newpassword) {
//	 
//	  userDao.updatePassword(email,newpassword);
//	  }

	
}
