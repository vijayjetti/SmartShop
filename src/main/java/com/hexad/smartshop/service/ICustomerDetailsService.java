package com.hexad.smartshop.service;

import com.hexad.smartshop.model.Address;
import com.hexad.smartshop.model.Customer;

public interface ICustomerDetailsService {

	public String registerCustomer(Customer customer);

	public Customer updateCustomer(Customer customer);

	public Customer getCustomerById(Integer customerId);

	public String registerAddress(Address customer);
}
