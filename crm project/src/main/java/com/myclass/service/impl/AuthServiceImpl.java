package com.myclass.service.impl;

import org.mindrot.jbcrypt.BCrypt;

import com.myclass.dto.UserDTO;
import com.myclass.entity.User;
import com.myclass.repository.RoleRepository;
import com.myclass.repository.UserRepository;
import com.myclass.repository.impl.RoleRepositoryImpl;
import com.myclass.repository.impl.UserRepositoryImpl;
import com.myclass.service.AuthService;
import com.myclass.util.Mapper;

public class AuthServiceImpl implements AuthService{
	
	private UserRepository userRepository;
	private RoleRepository roleRepository;
	
	public AuthServiceImpl() {
		userRepository = new UserRepositoryImpl();
		roleRepository = new RoleRepositoryImpl();
	}
	
	@Override
	public UserDTO login(String email, String password) {
		User entity = userRepository.findByEmail(email);
		if(entity == null) {
			return null;
		}else {
			if(BCrypt.checkpw(password, entity.getPassword())) {
				UserDTO user = Mapper.convertToDTO(entity, UserDTO.class);
				user.setRoleName(roleRepository.findById(user.getRoleId()).getName());
				return user;
			}else {
				return null;
			}
		}
	}
	
}
