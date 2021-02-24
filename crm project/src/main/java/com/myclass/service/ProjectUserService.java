package com.myclass.service;

import java.util.List;

import com.myclass.dto.ProjectUserDTO;
import com.myclass.dto.UserDTO;

public interface ProjectUserService {
	
	List<ProjectUserDTO> findByProjectId(int projectId);
	List<UserDTO> usersHasNotJoin(int projectId);
	int insert(ProjectUserDTO projectUserDTO);
}
