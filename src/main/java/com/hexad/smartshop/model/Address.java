package com.hexad.smartshop.model;

import java.io.Serializable;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "ADDRESS")
@Cacheable
public class Address implements Serializable {

	private static final long serialVersionUID = -7226842657955828855L;

	@Id
	@Column(name = "ADDRESS_ID", unique = true, nullable = false)
	@TableGenerator(name = "TABLE_GEN", table = "CUST_SEQUENCER", pkColumnName = "SEQ_NAME", valueColumnName = "SEQ_COUNT", pkColumnValue = "ADDR_SEQ_NEXT_VAL", initialValue = 100, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "TABLE_GEN")
	private Long addressId;

	@Column(name = "STREET")
	private String street;

	@Column(name = "CITY")
	private String city;

	@Column(name = "STATE")
	private String state;

	@Column(name = "PIN")
	private Long pin;

	//@ManyToOne(fetch = FetchType.LAZY, targetEntity = Customer.class)
//	@ManyToOne(cascade=CascadeType.ALL)
	/*@JoinColumn(name = "CUSTOMER_ID", nullable = false, updatable = true)
	private Customer customer;
*/
	public Address() {
	}
//	(1, home city1, 560036, Karnataka1, home street1, null)
	public Address(String street, String city, String state, Long pin) {
		this.street = street;
		this.city = city;
		this.state = state;
		this.pin = pin;
//		this.customer = customer;
	}
	public Long getAddressId() {
		return addressId;
	}
	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Long getPin() {
		return pin;
	}
	public void setPin(Long pin) {
		this.pin = pin;
	}
	/*public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}*/

}
