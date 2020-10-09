package com.egen.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BILLING")
public class Billing {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="bill_id")
    private int billId;
	
	@Column(name = "billing_address1")
	private String billingAddress1;
	
	@Column(name = "billing_address2")
	private String billingAddress2;
	
	@Column(name = "billing_city")
	private String billingCity;
	
	@Column(name = "billing_state")
	private String billingState;
	
	@Column(name = "billing_zip_code")
	private int billingZipCode;
	
	protected Billing() {
	}
	
	public Billing(String billingAddress1, String billingAddress2, String billingCity, String billingState,
			int billingZipCode) {
		this.billingAddress1 = billingAddress1;
		this.billingAddress2 = billingAddress2;
		this.billingCity = billingCity;
		this.billingState = billingState;
		this.billingZipCode = billingZipCode;
	}

	public int getBillId() {
		return billId;
	}

	public String getBillingAddress1() {
		return billingAddress1;
	}

	public void setBillingAddress1(String billingAddress1) {
		this.billingAddress1 = billingAddress1;
	}

	public String getBillingAddress2() {
		return billingAddress2;
	}

	public void setBillingAddress2(String billingAddress2) {
		this.billingAddress2 = billingAddress2;
	}

	public String getBillingCity() {
		return billingCity;
	}

	public void setBillingCity(String billingCity) {
		this.billingCity = billingCity;
	}

	public String getBillingState() {
		return billingState;
	}

	public void setBillingState(String billingState) {
		this.billingState = billingState;
	}

	public int getBillingZipCode() {
		return billingZipCode;
	}

	public void setBillingZipCode(int billingZipCode) {
		this.billingZipCode = billingZipCode;
	}

	@Override
	public String toString() {
		return "billingAddress1=" + billingAddress1 + ", billingAddress2=" + billingAddress2 + ", billingCity="
				+ billingCity + ", billingState=" + billingState + ", billingZipCode=" + billingZipCode ;
	}
}
