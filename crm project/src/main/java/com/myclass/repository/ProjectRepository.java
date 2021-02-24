package com.myclass.repository;

import java.util.List;

import com.myclass.dto.ProjectDTO;
import com.myclass.entity.Project;

public interface ProjectRepository {
	
	List<ProjectDTO> findAll();
	Project findById(int id);
	int insert(Project entity);
	int update(Project entity);
	void delete(int id);
	void deleteByLeader(int leader);
	
}
