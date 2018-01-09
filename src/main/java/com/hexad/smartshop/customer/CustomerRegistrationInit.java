package com.hexad.smartshop.customer;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hexad.smartshop.constants.URLConstants;
import com.hexad.smartshop.model.Address;
import com.hexad.smartshop.model.Customer;
import com.hexad.smartshop.service.ICustomerDetailsService;

@RestController
public class CustomerRegistrationInit {

	private final Logger logger = LoggerFactory.getLogger(CustomerRegistrationInit.class);

	@Autowired
	private ICustomerDetailsService customerService;

	@GetMapping(value = URLConstants.GET_CUSTOMER)
	public Customer getCustomerById(@PathVariable Integer customerId) {
		logger.info("getting Customer:", customerId);
		return customerService.getCustomerById(customerId);
	}

	@PostMapping(value = URLConstants.ADD_CUSTOMER)
	public void addCustomer(@RequestBody Customer customer) {
		logger.info("Registering Customer:", customer.getCustomerId());
		Address add1 = new Address("home street1", "home city1", "Karnataka1", new Long(560036));
		Address add2 = new Address("office street2", "office city2", "Karnataka2", new Long(560037));
		Address add3 = new Address("office street3", "office city3", "Karnataka3", new Long(560038));
		List<Address> addresses = Arrays.asList(add1,add2,add3);
		customer = new Customer("Vijay", "vijay@gmail.com", "8880775555", addresses);
		/*Address add1 = new Address("home street1", "home city1", "Karnataka1", new Long(560036), customer);*/
		customerService.registerCustomer(customer);
	}

	@PutMapping(value = URLConstants.UPDATE_CUSTOMER)
	public void updateCustomer(@RequestBody Customer customer) {
		customerService.updateCustomer(customer);
	}

}
