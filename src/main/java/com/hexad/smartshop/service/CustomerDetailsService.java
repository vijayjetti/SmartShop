package com.hexad.smartshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hexad.smartshop.model.Address;
import com.hexad.smartshop.model.Customer;
import com.hexad.smartshop.repository.ICustomerRepository;

@Transactional
@Service
public class CustomerDetailsService implements ICustomerDetailsService {

	@Autowired
	private ICustomerRepository customerRepository;

	@Override
	public String registerCustomer(Customer customer) {
		return customerRepository.registerCustomer(customer);
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		return customerRepository.updateCustomer(customer);
	}

	@Override
	public Customer getCustomerById(Integer customerId) {
		return customerRepository.getCustomerById(customerId);
	}

	@Override
	public String registerAddress(Address address) {
		return customerRepository.registerAddress(address);
	}

}
