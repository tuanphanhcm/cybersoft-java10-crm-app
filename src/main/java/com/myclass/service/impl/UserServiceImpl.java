package com.myclass.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.mindrot.jbcrypt.BCrypt;

import com.myclass.dto.UserDTO;
import com.myclass.entity.User;
import com.myclass.repository.ProjectRepository;
import com.myclass.repository.UserRepository;
import com.myclass.repository.impl.ProjectRepositoryImpl;
import com.myclass.repository.impl.UserRepositoryImpl;
import com.myclass.service.UserService;
import com.myclass.util.Mapper;

public class UserServiceImpl implements UserService{
	private UserRepository repository;
	private ProjectRepository projectRepository;
	
	public UserServiceImpl() {
		repository = new UserRepositoryImpl();
		projectRepository = new ProjectRepositoryImpl();
	}
	
	@Override
	public List<UserDTO> findAll() {
		return repository.findAll();
	}

	@Override
	public int insert(UserDTO userDTO) {
		String hash = BCrypt.hashpw(userDTO.getPassword(), BCrypt.gensalt(12));
		userDTO.setPassword(hash);
		User entity = Mapper.convertToDTO(userDTO, User.class);
		return repository.insert(entity);
	}

	@Override
	public UserDTO findById(int id) {
		User entity = repository.findById(id);
		if(entity == null) {
			return null;
		}else {
			return Mapper.convertToDTO(entity, UserDTO.class);
		}
		
	}

	@Override
	public int update(UserDTO userDTO) {
		User entity = repository.findById(userDTO.getId());
		if(entity != null) {
			entity.setEmail(userDTO.getEmail());
			entity.setFullName(userDTO.getFullName());
			entity.setAvatar(userDTO.getAvatar());
			entity.setRoleId(userDTO.getRoleId());
			if(!userDTO.getPassword().isEmpty()) {
				entity.setPassword(BCrypt.hashpw(userDTO.getPassword(), BCrypt.gensalt(12)));
			}
		}
		return repository.update(entity);
	}

	@Override
	public void delete(int id) {
		projectRepository.deleteByLeader(id);
		repository.delete(id);
	}
	
	public List<UserDTO> findNormalUser() {
		List<UserDTO> users = new ArrayList<>();
		for(UserDTO user : repository.findAll()) {
			if(user.getRoleName().equals("ROLE_USER")) {
				users.add(user);
			}
		}
		return users;
	}

	@Override
	public int removeUserFromProject(int userId, int projectId) {
		return repository.removeUserFromProject(userId, projectId);
	}
}
