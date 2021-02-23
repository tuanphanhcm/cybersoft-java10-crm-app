package com.myclass.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;

import com.myclass.dto.RoleDto;
import com.myclass.entity.Role;
import com.myclass.repository.RoleRepository;

public class RoleService {
	private RoleRepository 	roleRepository;
	private ModelMapper 	modelMapper;

	public RoleService() {
		roleRepository 	= new RoleRepository();
		modelMapper 	= new ModelMapper();
	}

	public List<RoleDto> getAll() {
		// b1 goi ham chay cau lenh truy van lay du lieu
		List<Role> entities = roleRepository.findAll(); // tra ve List<Role>

		// b2 mapping tham chieu du lieu tu entity sang dto
		List<RoleDto> listRoleDto = new ArrayList<RoleDto>();
		for (Role entity : entities) {
			/*
			 * use modelMapper to map entity to dto syntax: OrderDTO orderDTO =
			 * modelMapper.map(order, OrderDTO.class) 
			 * author: Grey
			 */
			RoleDto dto = new RoleDto();
			dto = modelMapper.map(entity, RoleDto.class);
			listRoleDto.add(dto);
		}
		// b3 tra ve dto
		return listRoleDto;
	}
	
	public int insert(RoleDto dto) {
		Role entity = new Role();
		
		entity = modelMapper.map(dto, Role.class);

		return roleRepository.addRole(entity);
	}

	public RoleDto findById(int id) {
		RoleDto dto 	= new RoleDto();
		Role 	entity 	= roleRepository.findById(id);
		
		dto = modelMapper.map(entity, RoleDto.class);
		
		return dto;
	}

	public int editRole(RoleDto dto) {
		Role entity = new Role();
		
		entity = modelMapper.map(dto, Role.class);
		
		return roleRepository.editRole(entity);
	}

	public int deleteRole(int id) {
		return roleRepository.removeRole(id);
	}

}
