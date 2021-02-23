package com.myclass.dto;

public class RoleDto {
	/* properties */
	public	String	name;
	public	String	description;
	public	int		id;
	
	/* constructors */
	public RoleDto(int id, String name, String description) {
		this.name 			= name;
		this.description 	= description;
		this.id 			= id;
	}
	
	public RoleDto() {
		this.name 			= "";
		this.description 	= "";
		this.id 			= 0;
	}

	public RoleDto(String name, String description) {
		this.name 			= name;
		this.description 	= description;
	}

	/* getter/setters */
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	

}
