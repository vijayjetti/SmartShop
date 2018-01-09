package com.hexad.smartshop.repository;

import com.hexad.smartshop.model.Address;
import com.hexad.smartshop.model.Customer;

public interface ICustomerRepository {

	public String registerCustomer(Customer customer);

	public Customer updateCustomer(Customer customer);

	public Customer getCustomerById(Integer customerId);
	
	public String registerAddress(Address address);

}
