package com.hexad.smartshop.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.hexad.smartshop.model.Customer;
import com.hexad.smartshop.repository.ICustomerRepository;

public class CustomerDetailsServiceTest {

	@InjectMocks
	private CustomerDetailsService customerDetailsService;
	
	@Mock
	private ICustomerRepository customerRepository;
	
	@Before
	public void setUp() throws Exception {
		initMocks(this);
	}
	
	@Test
	public void testRegisterCustomer() {
		Customer customer = new Customer();
		when(customerRepository.registerCustomer(customer)).thenReturn("response");
		
		String response = customerDetailsService.registerCustomer(customer);
		assertEquals("Verify the resposne ","response", response);
		verify(customerRepository, times(1)).registerCustomer(customer);

	}
}
