package com.myclass.repository;

import java.util.List;
import com.myclass.dto.UserDTO;
import com.myclass.entity.User;

public interface UserRepository {
	
	User findByEmail(String email);
	List<UserDTO> findAll();
	int insert(User entity);
	User findById(int id);
	int update(User entity);
	void delete(int id);
	int removeUserFromProject(int userId, int projectId);
	List<User> findByProjectId(int projectId);
	
}
