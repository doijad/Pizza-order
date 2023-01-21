package com.cg.onlinepizza.customer.entity;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="Customer")
public class Customer  {
	@Id
	private int cId;
	private String cName;
	private long cMobileNo;
	private String cEmail;
	private String cAddress;
	
	public Customer() {}
	public Customer(int cId, String cName, long cMobileNo, String cEmail, String cAddress) {
		super();
		this.cId = cId;
		this.cName = cName;
		this.cMobileNo = cMobileNo;
		this.cEmail = cEmail;
		this.cAddress = cAddress;
	}
	public int getcId() {
		return cId;
	}
	public void setcId(int cId) {
		this.cId = cId;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public long getcMobileNo() {
		return cMobileNo;
	}
	public void setcMobileNo(long cMobileNo) {
		this.cMobileNo = cMobileNo;
	}
	public String getcEmail() {
		return cEmail;
	}
	public void setcEmail(String cEmail) {
		this.cEmail = cEmail;
	}
	public String getcAddress() {
		return cAddress;
	}
	public void setcAddress(String cAddress) {
		this.cAddress = cAddress;
	}
	@Override
	public String toString() {
		return "Customer [cId=" + cId + ", cName=" + cName + ", cMobileNo=" + cMobileNo + ", cEmail=" + cEmail
				+ ", cAddress=" + cAddress + "]";
	}

	
	
}




