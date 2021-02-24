package com.myclass.service.impl;

import java.util.ArrayList;
import java.util.List;
import com.myclass.dto.ProjectDTO;
import com.myclass.entity.Project;
import com.myclass.repository.ProjectRepository;
import com.myclass.repository.ProjectUserRepository;
import com.myclass.repository.TaskRepository;
import com.myclass.repository.impl.ProjectRepositoryImpl;
import com.myclass.repository.impl.ProjectUserRepositoryImpl;
import com.myclass.repository.impl.TaskRepositoryImpl;
import com.myclass.service.ProjectService;
import com.myclass.util.Mapper;

public class ProjectServiceImpl implements ProjectService{
	
	private ProjectRepository repository;
	private ProjectUserRepository projectUserRepository;
	private TaskRepository taskRepository;
	
	public ProjectServiceImpl() {
		repository = new ProjectRepositoryImpl();
		projectUserRepository = new ProjectUserRepositoryImpl();
		taskRepository = new TaskRepositoryImpl();
	}
	
	@Override
	public List<ProjectDTO> findAll() {
		List<ProjectDTO> projects = repository.findAll();
		return projects;
	}

	@Override
	public List<ProjectDTO> findByLeader(int leader) {
		List<ProjectDTO> projects = new ArrayList<>();
		for(ProjectDTO project : repository.findAll()) {
			if(project.getLeader() == leader) {
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

	@Override
	public int update(ProjectDTO projectDTO) {
		Project entity = Mapper.convertToDTO(projectDTO, Project.class);
		return repository.update(entity);
	}

	@Override
	public void delete(int projectId) {
		projectUserRepository.deleteByProjectId(projectId);
		taskRepository.deleteByProjectId(projectId);
		repository.delete(projectId);
	}
	
}
