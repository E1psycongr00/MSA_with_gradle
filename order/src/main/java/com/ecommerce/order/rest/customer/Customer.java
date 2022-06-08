package com.ecommerce.order.rest.customer;

import org.apache.ibatis.type.Alias;

@Alias("Customer")
public class Customer {

	private String userid;
	private String pwd;
	private String name;
	private String email;
	private String createDate;
	
	public Customer() {
	}

	public Customer(String userid, String pwd, String name, String email, String createDate) {
		this.userid = userid;
		this.pwd = pwd;
		this.name = name;
		this.email = email;
		this.createDate = createDate;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "Customer [userid=" + userid + ", pwd=" + pwd + ", name=" + name + ", email=" + email + ", createDate="
				+ createDate + "]";
	}

}
