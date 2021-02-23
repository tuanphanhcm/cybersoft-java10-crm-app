package com.myclass.entity;

public class User {
	/* properties */
	private int		id;
	private String 	email;
	private String 	password;
	private String 	fullname;
	private String	address;
	private String	phone;
	private int 	roleId;

	/* constructors */
	public User() {
		this.id 		= 0;
		this.email 		= "";
		this.password 	= "";
		this.fullname 	= "";
		this.address 	= "";
		this.phone 		= "";
		this.roleId 	= 3;
	}
	
	public User(String email, String password, String fullname, String address, String phone, int roleId) {
		this.id 		= 0;
		this.email 		= email;
		this.password 	= password;
		this.fullname 	= fullname;
		this.address 	= address;
		this.phone 		= phone;
		this.roleId 	= roleId;
	}

	/* getters/setters */
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
