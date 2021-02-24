package com.myclass.service;

import java.util.List;
import com.myclass.dto.ProjectDTO;

public interface ProjectService {
	
	List<ProjectDTO> findAll();
	List<ProjectDTO> findByLeader(int leader);
	ProjectDTO findById(int id);
	int insert(ProjectDTO projectDTO);
	int update(ProjectDTO projectDTO);
	void delete(int id);
	
}
