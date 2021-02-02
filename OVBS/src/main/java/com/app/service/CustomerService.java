package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.ICustomer;
import com.app.pojos.Customer;

@Service
public class CustomerService implements ICustomerService {

	@Autowired
	private ICustomer customerDao; // customer dao reference to persist data

	@Override
	public Customer registerCustomer(Customer newcustomer) {
		
		return customerDao.save(newcustomer);
	}

	@Override
	public List<Customer> getAllCustomers() {
		
		return customerDao.findAll();
	}

	@Override
	public Customer getCustomerByEmail(String email) {
		
		return customerDao.getCustomerByEmail(email);
	}

	@Override
	public Customer getcustomerById(int id) {
		
		return customerDao.getOne(id);
	}

	@Override
	public void changePassword(String newPassword,int id) {
		
		customerDao.updatePassword(newPassword,id);
		
	}
	
	public Customer updateCustomerDetails(Customer updatedCustomer) {
		return customerDao.save(updatedCustomer);
	}

	@Override
	public void deleteCustomerDetails(int id) {
		// TODO Auto-generated method stub
		customerDao.deleteById(id);
	}
}
