package com.myclass.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.myclass.connection.DbConnection;
import com.myclass.entity.Role;

public class RoleRepository {
	
	public List<Role> findAll() {
		List<Role> roleList = new ArrayList<Role>();
		Connection conn = DbConnection.getConnection();
		
		// check whether connect to database
		if(conn == null)
			return null;
		
		// TRUY VẤN LẤY DỮ LIỆU
		String query = "SELECT * FROM ROLE";
		try {
			PreparedStatement statement = conn.prepareStatement(query);
			// Thực thi câu lệnh truy vấn
			ResultSet resultSet = statement.executeQuery();
			// Chuyển dữ liệu qua Role entity
			while (resultSet.next()) {
				Role entity = new Role();
				entity.setId(resultSet.getInt("id"));
				entity.setName(resultSet.getString("name"));
				entity.setDescription(resultSet.getString("description"));

				roleList.add(entity);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return roleList;
	}

	public int addRole(Role role) {
		Connection conn = DbConnection.getConnection();
		
		// check whether connect to database
		if(conn == null)
			return 0;
		
		String query ="INSERT INTO ROLE (name , description) value (? ,?)";
		try {
			PreparedStatement statement =  conn.prepareStatement(query);
			statement.setString(1, role.getName());
			statement.setString(2, role.getDescription());
			
			return statement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int removeRole(int id) {
		Connection conn = DbConnection.getConnection();
		
		if(conn == null)
			return 0;
		
		String query = "DELETE FROM ROLE WHERE id=?";
		try {
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, id);
			
			return statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
		
	}

	public Role findById(int id) {
		Connection conn = DbConnection.getConnection();
		
		if(conn == null)
			return null;
		
		String query = "SELECT * FROM ROLE WHERE id = ?";
		try {
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, id);
			//thực thi lệnh truy vấn
			ResultSet resultSet = statement.executeQuery();
			//chuyển dữ liệu qua entity
			while(resultSet.next()) {
				Role entity  = new Role();
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

	public int editRole(Role role) {
		Connection conn = DbConnection.getConnection();
		
		if(conn == null)
			return 0;
		
		String query = "UPDATE ROLE SET name = ? , description = ? WHERE id = ?";
		try {
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, role.getName());
			statement.setString(2, role.getDescription());
			statement.setInt(3, role.getId());
			
			return statement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}
}
