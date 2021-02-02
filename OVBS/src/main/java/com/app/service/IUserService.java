package com.app.service;

import com.app.pojos.User;

public interface IUserService {

	public void addCredintials(User u);

	public User validateUser(String email, String password);

	public void updatePassword(String email, String password);

	public void deleteUser(int id);

//	void updatePassword(String email, String newpassword);
}
