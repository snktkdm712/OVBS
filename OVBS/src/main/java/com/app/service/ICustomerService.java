package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.pojos.Customer;

public interface ICustomerService {


	public Customer registerCustomer(Customer newcustomer);
	
	public List<Customer> getAllCustomers();
	
	public Customer getCustomerByEmail(String email);
	
	public Customer getcustomerById(int id);
	
	public void changePassword(String newPassword,int id);
	
	public Customer updateCustomerDetails(Customer updatedCustomer);
	
	public void deleteCustomerDetails(int id);
}
