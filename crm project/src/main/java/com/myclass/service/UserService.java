package com.myclass.service;

import java.util.List;

import com.myclass.dto.UserDTO;

public interface UserService {
	
	List<UserDTO> findAll();
	int insert(UserDTO userDTO);
	UserDTO findById(int id);
	int update(UserDTO userDTO);
	void delete(int id);
	List<UserDTO> findNormalUser();
	List<UserDTO> findByProjectId(int projectId);
	
}
