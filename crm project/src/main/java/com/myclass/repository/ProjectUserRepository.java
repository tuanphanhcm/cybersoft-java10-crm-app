package com.myclass.repository;

import java.util.List;

import com.myclass.entity.ProjectUser;
import com.myclass.entity.User;

public interface ProjectUserRepository {
	
	List<ProjectUser> findByProjectId(int projectId);
	void deleteByProjectId(int projectId);
	List<User> usersHasNotJoin(int projectId);
	int insert(ProjectUser entity);
	
}
