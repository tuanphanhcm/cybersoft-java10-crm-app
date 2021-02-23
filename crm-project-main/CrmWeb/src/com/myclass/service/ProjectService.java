package com.myclass.service;

import java.util.List;

import org.modelmapper.ModelMapper;

import com.myclass.dto.ProjectDto;
import com.myclass.entity.Project;
import com.myclass.repository.ProjectRepository;

public class ProjectService {
	private ProjectRepository 	projectRepository;
	private ModelMapper			modelMapper;

	public ProjectService() {
		projectRepository 	= new ProjectRepository();
		modelMapper			= new ModelMapper();
	}

	public List<ProjectDto> getAll() {
		return projectRepository.findAll();
	}

	public int deleteUser(int idDelete) {
		return projectRepository.remove(idDelete);
	}

	public int add(ProjectDto projectDto) {
		// TODO Auto-generated method stub
		try {
			Project entity = new Project();
			entity.setName(projectDto.getName());
			entity.setDescription(projectDto.getDescription());
			entity.setStartDate(projectDto.getStartDate());
			entity.setEndDate(projectDto.getEndDate());
			entity.setCreateUser(projectDto.getCreateUser());
			return projectRepository.save(entity);
		} catch (Exception e) {
			// TODO: handle exception
			return -1;
		}

	}

	public int update(ProjectDto dto) {
		// TODO Auto-generated method stub
		Project project = new Project();
		project.setId(dto.getId());
		project.setDescription(dto.getDescription());
		project.setName(dto.getName());
		project.setStartDate(dto.getStartDate());
		project.setEndDate(dto.getEndDate());
		project.setCreateUser(dto.getCreateUser());
		return projectRepository.edit(project);
	}

	public ProjectDto getById(int id) {
		Project project = projectRepository.findById(id);
		ProjectDto dto = new ProjectDto();
		dto.setId(project.getId());
		dto.setName(project.getName());
		dto.setDescription(project.getDescription());
		dto.setStartDate(project.getStartDate());
		dto.setEndDate(project.getEndDate());
		dto.setCreateUser(project.getCreateUser());

		return dto;
	}

}
