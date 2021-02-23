package com.myclass.entity;

public class Role {
	/* properties */
	private String 	name;
	private String 	description;
	private int 	id;

	/* constructors */
	public Role(String name, String description, int id) {
		this.name 			= name;
		this.description 	= description;
		this.id 			= id;
	}
	
	public Role() {
		this.name 			= "";
		this.description 	= "";
		this.id 			= 0;
	}

	/* getters/setters */
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
