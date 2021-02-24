package com.myclass.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.myclass.dto.ProjectUserDTO;
import com.myclass.dto.UserDTO;
import com.myclass.entity.ProjectUser;
import com.myclass.entity.User;
import com.myclass.repository.ProjectUserRepository;
import com.myclass.repository.UserRepository;
import com.myclass.repository.impl.ProjectUserRepositoryImpl;
import com.myclass.repository.impl.UserRepositoryImpl;
import com.myclass.service.ProjectUserService;
import com.myclass.util.Mapper;

public class ProjectUserServiceImpl implements ProjectUserService {
	
	private ProjectUserRepository repository;
	private UserRepository userRepository;
	
	public ProjectUserServiceImpl() {
		repository = new ProjectUserRepositoryImpl();
		userRepository = new UserRepositoryImpl();
	}
	
	@Override
	public List<ProjectUserDTO> findByProjectId(int projectId) {
		List<ProjectUserDTO> list = new ArrayList<>();
		for(ProjectUser entity : repository.findByProjectId(projectId)) {
			ProjectUserDTO projectUserDTO = Mapper.convertToDTO(entity, ProjectUserDTO.class);
			projectUserDTO.setUserName(userRepository.findById(projectUserDTO.getUserId()).getFullName());
			list.add(projectUserDTO);
		}
		return list;
	}

	@Override
	public List<UserDTO> usersHasNotJoin(int projectId) {
		List<UserDTO> users = new ArrayList<>();
		for(User entity : repository.usersHasNotJoin(projectId)) {
			users.add(Mapper.convertToDTO(entity, UserDTO.class));
		}
		return users;
	}

	@Override
	public int insert(ProjectUserDTO projectUserDTO) {
		ProjectUser entity = Mapper.convertToDTO(projectUserDTO, ProjectUser.class);
		return repository.insert(entity);
	}

}
