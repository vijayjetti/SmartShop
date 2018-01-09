package com.hexad.smartshop.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.hexad.smartshop.model.Address;
import com.hexad.smartshop.model.Customer;

@Repository
public class CustomerRepository implements ICustomerRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public String registerCustomer(Customer customer) {
		entityManager.persist(customer);
		return "Customer has been registered sucessfully !!";

	}

	@Override
	public Customer getCustomerById(Integer customerId) {
		return entityManager.find(Customer.class, customerId);
	}

	@Override
	public Customer updateCustomer(Customer modifiedCustomer) {
		Customer customerDetails = getCustomerById(modifiedCustomer.getCustomerId());
		customerDetails.setCustomerName(modifiedCustomer.getCustomerName());
		customerDetails.setEmailId(modifiedCustomer.getEmailId());
		customerDetails.setPhoneNumber(modifiedCustomer.getPhoneNumber());
		//customerDetails.setAddresses(modifiedCustomer.getAddresses());
		customerDetails.setDateOfRegistration(modifiedCustomer.getDateOfRegistration());
		entityManager.flush();
		return getCustomerById(modifiedCustomer.getCustomerId());
	}

	@Override
	public String registerAddress(Address address) {
		entityManager.persist(address);
		return "Address has been registered sucessfully !!";
	}

}
