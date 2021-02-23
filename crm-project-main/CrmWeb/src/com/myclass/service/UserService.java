package com.myclass.service;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.modelmapper.ModelMapper;

import com.myclass.dto.UserDto;
import com.myclass.entity.User;
import com.myclass.repository.UserRepository;

public class UserService {
	private UserRepository 	userRepository;
	private ModelMapper 	modelMapper;

	public UserService() {
		userRepository 	= new UserRepository();
		modelMapper 	= new ModelMapper();
	}

	public List<UserDto> getAllUser() {
		return userRepository.getAll();
	}

	public int saveUser(UserDto dto) {
		String hashedPassword = BCrypt.hashpw(dto.getPassword(), BCrypt.gensalt());
		String fullName = dto.getFirstName() + " " + dto.getLastName();
		
		dto.setPassword(hashedPassword);
		dto.setFullname(fullName);
		
		User entity = modelMapper.map(dto, User.class);
		return userRepository.addUser(entity);
	}

	public int updateUser(UserDto dto) {
		User entity = userRepository.findById(dto.getId());
		
		String hashedPassword = entity.getPassword();
		String fullName = dto.getFirstName() + " " + dto.getLastName();
		
		if(!dto.getPassword().isEmpty())
			hashedPassword = BCrypt.hashpw(dto.getPassword(), BCrypt.gensalt()); 
		
		dto.setPassword(hashedPassword);
		dto.setFullname(fullName);

		entity = modelMapper.map(dto, User.class);
		return userRepository.editUser(entity);
	}

	public int deleteUser(int id) {
		return userRepository.remove(id);
	}

	public UserDto getById(int id) {
		User entity = userRepository.findById(id);
		UserDto dto = new UserDto();
		
		dto = modelMapper.map(entity, UserDto.class);
		dto.splitFullname();

		return dto;
	}

	public UserDto checkLogin(UserDto dto) {
		User entity = userRepository.findByEmail(dto.getEmail());
		
		if(entity == null)
			return null;
		
		String databasePassword = entity.getPassword();
		String clientPassword	= dto.getPassword();
		
		if(!BCrypt.checkpw(clientPassword, databasePassword))
			return null;
		
		UserDto checkedDto = new UserDto();
		checkedDto = modelMapper.map(entity, UserDto.class);
		return checkedDto;
	}

}
