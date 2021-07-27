package com.hexad.smartshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hexad.smartshop.constants.ErrorMessageConstants;
import com.hexad.smartshop.exception.CustomerException;
import com.hexad.smartshop.logging.SmartShopLoggingHelper;
import com.hexad.smartshop.model.Customer;
import com.hexad.smartshop.repository.CustomerRepository;

@Transactional
@Service
public class CustomerDetailsService implements ICustomerDetailsService {

	private static String CLASS_NAME = CustomerDetailsService.class.getName();

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Customer registerCustomer(Customer customer) throws CustomerException {
		String methodName = CLASS_NAME + ".registerCustomer()";
		SmartShopLoggingHelper.debug(methodName, ErrorMessageConstants.START_METHOD);
		Customer registeredCustomer=null;
		try {
			registeredCustomer=customerRepository.save(customer);
		} catch (CustomerException exception) {
			SmartShopLoggingHelper.severe(ErrorMessageConstants.CUSTOMER_CREATING_ERROR_ID,
					ErrorMessageConstants.CUSTOMER_CREATING_ERROR_VALUE, new Object[] { exception.getMessage() }, exception);
			throw new CustomerException(ErrorMessageConstants.CUSTOMER_CREATING_ERROR_ID,
					ErrorMessageConstants.CUSTOMER_CREATING_ERROR_VALUE, exception, new Object[] { exception.getMessage() });
		}
		SmartShopLoggingHelper.debug(methodName, ErrorMessageConstants.END_METHOD);
		return registeredCustomer;
	}

	@Override
	public Customer updateCustomer(Customer customer) throws CustomerException {
		String methodName = CLASS_NAME + ".updateCustomer()";
		SmartShopLoggingHelper.debug(methodName, ErrorMessageConstants.START_METHOD);
		Customer updatedCustomer=null;
		try {
			updatedCustomer=customerRepository.save(customer);
		} catch (CustomerException exception) {
			SmartShopLoggingHelper.severe(ErrorMessageConstants.CUSTOMER_UPDATING_ERROR_ID,
					ErrorMessageConstants.CUSTOMER_UPDATING_ERROR_VALUE, new Object[] { exception.getMessage() }, exception);
			throw new CustomerException(ErrorMessageConstants.CUSTOMER_UPDATING_ERROR_ID,
					ErrorMessageConstants.CUSTOMER_UPDATING_ERROR_VALUE, exception, new Object[] { exception.getMessage() });
		}
		SmartShopLoggingHelper.debug(methodName, ErrorMessageConstants.END_METHOD);
		return updatedCustomer;
	}

	@Override
	public Customer getCustomerById(Integer customerId) throws CustomerException {
		String methodName = CLASS_NAME + ".getCustomerById()";
		Customer customer = null;
		SmartShopLoggingHelper.debug(methodName, ErrorMessageConstants.START_METHOD);
		try {
			customer = customerRepository.findOne(customerId);
		} catch (CustomerException exception) {
			SmartShopLoggingHelper.severe(ErrorMessageConstants.CUSTOMER_NOT_FOUND_ID, ErrorMessageConstants.CUSTOMER_NOT_FOUND_VALUE,
					new Object[] { exception.getMessage() }, exception);
			throw new CustomerException(ErrorMessageConstants.CUSTOMER_NOT_FOUND_ID, ErrorMessageConstants.CUSTOMER_NOT_FOUND_VALUE,
					exception, new Object[] { exception.getMessage() });
		}
		SmartShopLoggingHelper.debug(methodName, ErrorMessageConstants.END_METHOD);
		return customer;
	}

}
