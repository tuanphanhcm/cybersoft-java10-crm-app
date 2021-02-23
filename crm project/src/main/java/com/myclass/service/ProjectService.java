package com.myclass.service;

import java.util.List;
import com.myclass.dto.ProjectDTO;

public interface ProjectService {
	
	List<ProjectDTO> findAll();
	List<ProjectDTO> findByLeaderId(int leaderId);
	int insert(ProjectDTO projectDTO);
	ProjectDTO findById(int id);
}
