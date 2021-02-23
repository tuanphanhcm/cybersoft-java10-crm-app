package com.myclass.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.myclass.connection.MySQLConnection;
import com.myclass.entity.Role;
import com.myclass.repository.RoleRepository;

public class RoleRepositoryImpl implements RoleRepository{

	@Override
	public List<Role> findAll() {
		List<Role> roles = new ArrayList<>();
		try {
			Connection connection = MySQLConnection.getConnection();
			String sql = "SELECT * FROM roles";
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Role role = new Role();
				role.setId(resultSet.getInt("id"));
				role.setName(resultSet.getString("name"));
				role.setDescription(resultSet.getString("description"));
				roles.add(role);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return roles;
	}

	@Override
	public int insert(Role entity) {
		try {
			Connection connection = MySQLConnection.getConnection();
			String sql = "INSERT INTO roles(name, description) VALUES(?, ?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, entity.getName());
			statement.setString(2, entity.getDescription());
			return statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
		
	}

	@Override
	public Role findById(int id) {
		try {
			Connection connection = MySQLConnection.getConnection();
			String sql = "SELECT * FROM roles WHERE id = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();
			if(resultSet.next()) {
				Role entity = new Role();
				entity.setId(resultSet.getInt("id"));
				entity.setName(resultSet.getString("name"));
				entity.setDescription(resultSet.getString("description"));
				return entity;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int update(Role entity) {
		try {
			Connection connection = MySQLConnection.getConnection();
			String sql = "UPDATE roles SET name = ?, description = ? WHERE id = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, entity.getName());
			statement.setString(2, entity.getDescription());
			statement.setInt(3, entity.getId());
			return statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public void delete(int id) {
		try {
			Connection connection = MySQLConnection.getConnection();
			String sql = "DELETE FROM roles WHERE id = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
