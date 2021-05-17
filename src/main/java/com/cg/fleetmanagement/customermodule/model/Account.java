//package com.cg.fleetmanagement.customermodule.model;
//
//import java.util.List;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.OneToMany;
//import javax.persistence.OneToOne;
//import javax.persistence.Table;
//
//@Entity
//@Table(name = "Admin_Account")
//public class Account {
//	@Id
//	@NotEmpty
//	@Size(min=3, max=6, message = "Admin Id should be between 3 to 6 characters")
//	@GeneratedValue
//	private int adminId;
//	@NotEmpty(message = "Password must not be empty")
//	@Size(min=8, max=20, message="Password should be between 2 and 8 characters")
//	@Pattern(regexp="^(?=.*[a-z])(?=.*\\d)(?=.*[A-Z])(?=.*[@#$%!]).{8,20}", message="Password must contain atleast one upper case, one lower case a digit and a special character")
//	private String password;
//	
//	@OneToMany(targetEntity=CustomerUnit.class)  
//	private List<CustomerUnit> customerUnit;
//	
//	public int getAdminId() {
//		return adminId;
//	}
//
//	public void setAdminId(int adminId) {
//		this.adminId = adminId;
//	}
//
//	public String getPassword() {
//		return password;
//	}
//
//	public void setPassword(String password) {
//		this.password = password;
//	}
//
//	public List<CustomerUnit> getCustomerUnit() {
//		return customerUnit;
//	}
//
//	public void setCustomerUnit(List<CustomerUnit> customerUnit) {
//		this.customerUnit = customerUnit;
//	}
//
//
//	
//	
//	
//	
//
//}
