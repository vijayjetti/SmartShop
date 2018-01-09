package com.hexad.smartshop.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "CUSTOMER_DETAIL")
public class Customer implements Serializable {

	private static final long serialVersionUID = -7600415208306161758L;

	@Id
	@Column(name = "CUSTOMER_ID")
	@TableGenerator(name = "TABLE_GEN", table = "CUST_SEQUENCER", pkColumnName = "SEQ_NAME", valueColumnName = "SEQ_COUNT", pkColumnValue = "CUSTOMER_SEQ_NEXT_VAL", initialValue = 1000, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "TABLE_GEN")
	private Integer customerId;

	@NotEmpty
	@Column(name = "CUSTOMER_NAME")
	private String customerName;

	@NotEmpty
	@Column(name = "EMAIL_ID")
	private String emailId;

	@NotEmpty
	@Column(name = "PHONE_NUMBER")
	private String phoneNumber;
//(1, home city1, 560036, Karnataka1, home street1, null)
//	@NotEmpty
//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "customer", cascade = CascadeType.ALL)
	
//	private List<Address> addresses = new ArrayList<Address>();
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name="Sample")
	private List<Address> addresses ;

	@Temporal(value = TemporalType.DATE)
	@Column(name = "REGISTRATION_DATE")
	private Date dateOfRegistration;

	public Customer() {
	}

//	public Customer(Integer customerId, String customerName, String emailId, String phoneNumber, List<Address> addresses) {
	public Customer(String customerName, String emailId, String phoneNumber, List<Address> addresses) {
//		this.customerId = customerId;
		this.customerName = customerName;
		this.emailId = emailId;
		this.phoneNumber = phoneNumber;
		this.addresses = addresses;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public Date getDateOfRegistration() {
		return dateOfRegistration;
	}

	/*public Address getAddresses() {
		return addresses;
	}

	public void setAddresses(Address addresses) {
		this.addresses = addresses;
	}*/

	public void setDateOfRegistration(Date dateOfRegistration) {
		this.dateOfRegistration = dateOfRegistration;
	}

}
