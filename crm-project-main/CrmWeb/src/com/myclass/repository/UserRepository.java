package com.myclass.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.myclass.connection.DbConnection;
import com.myclass.dto.UserDto;
import com.myclass.entity.User;

public class UserRepository {
	public int addUser(User user) {
		Connection conn = DbConnection.getConnection();
		
		if(conn == null)
			return 0;
		
		String query = "INSERT INTO USER (email , password , fullname , address , phone, roleid) value (? , ? , ? , ? , ?, ?)";
		try {
			PreparedStatement statement = conn.prepareStatement(query);

			statement.setString(1, user.getEmail());
			statement.setString(2, user.getPassword());
			statement.setString(3, user.getFullname());
			statement.setString(4, user.getAddress());
			statement.setString(5, user.getPhone());
			statement.setInt(6, user.getRoleId());

			return statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int remove(int id) {
		Connection conn = DbConnection.getConnection();
		
		if(conn == null)
			return 0;
		
		String query = "DELETE FROM USER WHERE id=?";
		try {
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, id);
			
			return statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int editUser(User userEdit) {
		Connection conn = DbConnection.getConnection();
		
		if(conn == null)
			return 0;
		
		String query = "UPDATE USER SET email = ?, password = ?, fullname = ?, address = ?, phone = ?, roleid = ? WHERE id = ?";
		try {
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, userEdit.getEmail());
			statement.setString(2, userEdit.getPassword());
			statement.setString(3, userEdit.getFullname());
			statement.setString(4, userEdit.getAddress());
			statement.setString(5, userEdit.getPhone());
			statement.setInt(6, userEdit.getRoleId());
			statement.setInt(7, userEdit.getId());
			
			return statement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}

	public User findById(int id) {
		Connection conn = DbConnection.getConnection();
		
		if(conn == null)
			return null;
		
		String query = "SELECT * FROM USER WHERE id=?";
		try {
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				User entity = new User();
				
				entity.setId(resultSet.getInt("id"));
				entity.setEmail(resultSet.getString("email"));
				entity.setPassword(resultSet.getString("password"));
				entity.setAddress(resultSet.getString("address"));
				entity.setFullname(resultSet.getString("fullname"));
				entity.setPhone(resultSet.getString("phone"));
				entity.setRoleId(resultSet.getInt("roleid"));
				
				return entity;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// method get all userDto
	public List<UserDto> getAll() {
		Connection conn = DbConnection.getConnection();
		
		if(conn == null)
			return null;
		
		List<UserDto> users = new ArrayList<UserDto>();
		String query = "SELECT\r\n"
						+ "	U.id,\r\n"
						+ "	U.email,\r\n"
						+ "	U.fullname,\r\n"
						+ "	U.phone,\r\n"
						+ "	R.`name` `roleName`\r\n"
					+ "FROM\r\n"
						+ "	ROLE R,\r\n"
						+ "	USER U\r\n"
					+ "WHERE\r\n"
						+ "	R.id = U.roleid\r\n"
					+ "ORDER BY\r\n"
						+ "	U.id;";
		try {
			PreparedStatement statement = conn.prepareStatement(query);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				UserDto dto = new UserDto();
				
				dto.setId(resultSet.getInt("id"));
				dto.setEmail(resultSet.getString("email"));
				dto.setFullname(resultSet.getString("fullname"));
				dto.setPhone(resultSet.getString("phone"));
				dto.setRoleName(resultSet.getString("roleName"));
				
				users.add(dto);
			}
			
			return users;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public User findByEmail(String email) {
		Connection conn = DbConnection.getConnection();
		
		if(conn == null)
			return null;
		
		String query = "SELECT * FROM USER WHERE email = ?";
		try {
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, email);
			ResultSet resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				User entity = new User();
				
				entity.setId(resultSet.getInt("id"));
				entity.setEmail(resultSet.getString("email"));
				entity.setPassword(resultSet.getString("password"));
				entity.setAddress(resultSet.getString("address"));
				entity.setFullname(resultSet.getString("fullname"));
				entity.setPhone(resultSet.getString("phone"));
				entity.setRoleId(resultSet.getInt("roleid"));
				
				return entity;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

}
