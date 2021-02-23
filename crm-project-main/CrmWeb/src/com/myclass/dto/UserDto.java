package com.myclass.dto;

public class UserDto {
	/* properties */
	private int 	id;
	private String 	password;
	private String 	email;
	private String 	address;
	private String 	fullname;
	private String 	phone;
	private int 	roleId;
	private String 	firstName;
	private String 	lastName;
	private String 	roleName;

	/* constructors */
	public UserDto(int id, String email, String password, String address, String firstName, String lastName, String phone,
			int roleId) {
		this.id 		= id;
		this.password 	= password;
		this.email 		= email;
		this.address 	= address;
		this.phone 		= phone;
		this.firstName 	= firstName;
		this.lastName 	= lastName;
		this.roleId 	= roleId;
	}

	public UserDto() {
		this.id 		= 0;
		this.password 	= "";
		this.email 		= "";
		this.address 	= "";
		this.fullname 	= "";
		this.phone 		= "";
		this.roleId 	= 0;
		this.roleName 	= "";
	}

	public UserDto(String email, String password, String address, String firstName, String lastName, String phone,
			int roleId) {
		this.password 	= password;
		this.email 		= email;
		this.address 	= address;
		this.phone 		= phone;
		this.firstName 	= firstName;
		this.lastName 	= lastName;
		this.roleId 	= roleId;
	}

	public UserDto(String email, String password) {
		this.password 	= password;
		this.email 		= email;
	}

	/* getters/setters */
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/* methods */
	public boolean splitFullname() {
		if("".equals(fullname))
			return false;
		
		int idx = fullname.lastIndexOf(' ');
		if(idx == -1)
			return false;
		
		this.firstName 	= fullname.substring(0, idx	);
		this.lastName	= fullname.substring(idx + 1);
		
		return true;
	}
}
