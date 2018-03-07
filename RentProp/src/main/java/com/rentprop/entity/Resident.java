package com.rentprop.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;
import java.util.List;


/**
 * The persistent class for the resident database table.
 * 
 */
@Entity
@NamedQuery(name="Resident.findAll", query="SELECT r FROM Resident r")
public class Resident implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="RESIDENT_ID")
	private int residentId;

	private String address;

	@Column(name="EMAIL_ID")
	private String emailId;

	@Column(name="FIRST_NAME")
	private String firstName;

	@Column(name="LAST_NAME")
	private String lastName;

	private String password;

	@Column(name="PHONE_NUMBER")
	private BigInteger phoneNumber;

	@Column(name="USER_TYPE")
	private String userType;

	//bi-directional many-to-one association to MaintenanceRequest
	@OneToMany(mappedBy="resident")
	private List<MaintenanceRequest> maintenanceRequests;

	//bi-directional many-to-one association to Payment
	@OneToMany(mappedBy="resident")
	private List<Payment> payments;

	//bi-directional many-to-one association to Reply
	@OneToMany(mappedBy="resident")
	private List<Reply> replies;

	//bi-directional many-to-one association to Apartment
	@ManyToOne
	@JoinColumn(name="APARTMENT_ID")
	private Apartment apartment;

	//bi-directional one-to-one association to User
	@OneToOne
	@JoinColumn(name="USER_ID")
	private User user;

	public Resident() {
	}

	public int getResidentId() {
		return this.residentId;
	}

	public void setResidentId(int residentId) {
		this.residentId = residentId;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmailId() {
		return this.emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public BigInteger getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(BigInteger phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getUserType() {
		return this.userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public List<MaintenanceRequest> getMaintenanceRequests() {
		return this.maintenanceRequests;
	}

	public void setMaintenanceRequests(List<MaintenanceRequest> maintenanceRequests) {
		this.maintenanceRequests = maintenanceRequests;
	}

	public MaintenanceRequest addMaintenanceRequest(MaintenanceRequest maintenanceRequest) {
		getMaintenanceRequests().add(maintenanceRequest);
		maintenanceRequest.setResident(this);

		return maintenanceRequest;
	}

	public MaintenanceRequest removeMaintenanceRequest(MaintenanceRequest maintenanceRequest) {
		getMaintenanceRequests().remove(maintenanceRequest);
		maintenanceRequest.setResident(null);

		return maintenanceRequest;
	}

	public List<Payment> getPayments() {
		return this.payments;
	}

	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}

	public Payment addPayment(Payment payment) {
		getPayments().add(payment);
		payment.setResident(this);

		return payment;
	}

	public Payment removePayment(Payment payment) {
		getPayments().remove(payment);
		payment.setResident(null);

		return payment;
	}

	public List<Reply> getReplies() {
		return this.replies;
	}

	public void setReplies(List<Reply> replies) {
		this.replies = replies;
	}

	public Reply addReply(Reply reply) {
		getReplies().add(reply);
		reply.setResident(this);

		return reply;
	}

	public Reply removeReply(Reply reply) {
		getReplies().remove(reply);
		reply.setResident(null);

		return reply;
	}

	public Apartment getApartment() {
		return this.apartment;
	}

	public void setApartment(Apartment apartment) {
		this.apartment = apartment;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}