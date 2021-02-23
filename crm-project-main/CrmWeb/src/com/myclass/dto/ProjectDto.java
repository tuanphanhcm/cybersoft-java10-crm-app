package com.myclass.dto;

import java.util.Date;
import java.util.List;

public class ProjectDto {
	/* properties */
	private int 			id;
	private String 			name;
	private String 			description;
	private Date 			startDate;
	private Date 			endDate;
	private int 			createUser;
	private String 			createUserName;
	private List<String> 	joinUsers;

	/* constructors */
	public ProjectDto(int id, String name, String description, Date startDate, Date endDate, int createUser,
			String createUserName, List<String> joinUsers) {
		this.id 			= id;
		this.name 			= name;
		this.description 	= description;
		this.startDate 		= startDate;
		this.endDate 		= endDate;
		this.createUser 	= createUser;
		this.createUserName = createUserName;
		this.joinUsers		= joinUsers;
	}
	
	public ProjectDto() {
		this.id 			= 0;
		this.name 			= "";
		this.description 	= "";
		this.startDate 		= null;
		this.endDate 		= null;
		this.createUser 	= 0;
		this.createUserName = "";
		this.joinUsers		= null;
	}

	/* getters/setters */
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getCreateUser() {
		return createUser;
	}

	public void setCreateUser(int createUser) {
		this.createUser = createUser;
	}

	public String getCreateUserName() {
		return createUserName;
	}

	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}

	public List<String> getJoinUsers() {
		return joinUsers;
	}

	public void setJoinUsers(List<String> joinUsers) {
		this.joinUsers = joinUsers;
	}

}
