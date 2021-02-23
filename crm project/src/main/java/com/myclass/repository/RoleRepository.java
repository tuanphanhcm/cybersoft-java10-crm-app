package com.myclass.repository;

import java.util.List;

import com.myclass.entity.Role;

public interface RoleRepository {
	
	List<Role> findAll();
	int insert(Role entity);
	Role findById(int id);
	int update(Role entity);
	void delete(int id);
	
}
