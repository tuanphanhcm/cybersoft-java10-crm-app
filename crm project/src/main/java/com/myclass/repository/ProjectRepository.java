package com.myclass.repository;

import java.util.List;

import com.myclass.dto.ProjectDTO;
import com.myclass.entity.Project;

public interface ProjectRepository {
	
	List<ProjectDTO> findAll();
	int insert(Project entity);
	Project findById(int id);
	void deleteByLeader(int leader);
}
