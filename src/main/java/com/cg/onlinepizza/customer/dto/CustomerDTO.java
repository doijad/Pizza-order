package com.cg.onlinepizza.customer.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CustomerDTO {
	
	private int cId;
	
	@NotNull
	@Size(min = 3 , message= "customer Name atleast 3char")
	private String cName;
	
	@NotEmpty
	@Email(message = "Wrong email")
	private String cEmail;
	
	@NotEmpty
	private String cAddress;
	
	@NotEmpty
	private long cMobileNo;
	
	
	public CustomerDTO () {}

	public CustomerDTO(int cId, @NotNull @Size(min = 3, message = "customer Name atleast 3char") String cName,
			@NotEmpty @Email(message = "Wrong email") String cEmail, @NotEmpty String cAddress,
			@NotEmpty long cMobileNo) {
		super();
		this.cId = cId;
		this.cName = cName;
		this.cEmail = cEmail;
		this.cAddress = cAddress;
		this.cMobileNo = cMobileNo;
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

	public long getcMobileNo() {
		return cMobileNo;
	}

	public void setcMobileNo(long cMobileNo) {
		this.cMobileNo = cMobileNo;
	}
	
	
	

}
