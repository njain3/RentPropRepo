package com.rentprop.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the payment database table.
 * 
 */
@Entity
@NamedQuery(name="Payment.findAll", query="SELECT p FROM Payment p")
public class Payment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="PAYMENT_ID")
	private int paymentId;

	private String date;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="PAYMENT_DATE")
	private Date paymentDate;

	private String status;

	//bi-directional many-to-one association to Apartment
	@ManyToOne
	@JoinColumn(name="APARTMENT_ID")
	private Apartment apartment;

	//bi-directional many-to-one association to Resident
	@ManyToOne
	@JoinColumn(name="RESIDENT_ID")
	private Resident resident;

	public Payment() {
	}

	public int getPaymentId() {
		return this.paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Date getPaymentDate() {
		return this.paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Apartment getApartment() {
		return this.apartment;
	}

	public void setApartment(Apartment apartment) {
		this.apartment = apartment;
	}

	public Resident getResident() {
		return this.resident;
	}

	public void setResident(Resident resident) {
		this.resident = resident;
	}

}