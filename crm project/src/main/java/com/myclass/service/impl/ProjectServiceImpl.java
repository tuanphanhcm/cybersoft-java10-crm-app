package com.myclass.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.myclass.dto.ProjectDTO;
import com.myclass.entity.Project;
import com.myclass.repository.ProjectRepository;
import com.myclass.repository.UserRepository;
import com.myclass.repository.impl.ProjectRepositoryImpl;
import com.myclass.repository.impl.UserRepositoryImpl;
import com.myclass.service.ProjectService;
import com.myclass.util.Mapper;

public class ProjectServiceImpl implements ProjectService{
	
	private ProjectRepository repository;
	private UserRepository userRepository;
	
	public ProjectServiceImpl() {
		repository = new ProjectRepositoryImpl();
		userRepository = new UserRepositoryImpl();
	}
	
	@Override
	public List<ProjectDTO> findAll() {
		List<ProjectDTO> projects = repository.findAll();
		for(ProjectDTO project : projects) {
			project.setUsers(userRepository.findByProjectId(project.getId()));
		}
		return projects;
	}

	@Override
	public List<ProjectDTO> findByLeaderId(int leaderId) {
		List<ProjectDTO> projects = new ArrayList<>();
		for(ProjectDTO project : repository.findAll()) {
			if(project.getLeader() == leaderId) {
				projects.add(project);
			}
		}
		return projects;
	}

	@Override
	public int insert(ProjectDTO projectDTO) {
		Project entity = Mapper.convertToDTO(projectDTO, Project.class);
		return repository.insert(entity);
	}

	@Override
	public ProjectDTO findById(int id) {
		Project entity = repository.findById(id);
		if(entity == null) {
			return null;
		}else {
			return Mapper.convertToDTO(entity, ProjectDTO.class);
		}
	}
	
}
