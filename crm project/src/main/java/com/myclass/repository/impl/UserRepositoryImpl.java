package com.myclass.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.myclass.connection.MySQLConnection;
import com.myclass.dto.UserDTO;
import com.myclass.entity.User;
import com.myclass.repository.UserRepository;

public class UserRepositoryImpl implements UserRepository {

	@Override
	public User findByEmail(String email) {
		try {
			Connection connection = MySQLConnection.getConnection();
			String sql = "SELECT * FROM users WHERE email = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, email);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				User user = new User();
				user.setId(result.getInt("id"));
				user.setEmail(result.getString("email"));
				user.setFullName(result.getString("fullname"));
				user.setAvatar(result.getString("avatar"));
				user.setPassword(result.getString("password"));
				user.setRoleId(result.getInt("role_id"));
				return user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<UserDTO> findAll() {
		List<UserDTO> list = new ArrayList<>();
		try {
			Connection connection = MySQLConnection.getConnection();
			String sql = "SELECT * FROM users u, roles r WHERE u.role_id = r.id";
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				UserDTO user = new UserDTO();
				user.setId(resultSet.getInt("id"));
				user.setEmail(resultSet.getString("email"));
				user.setFullName(resultSet.getString("fullname"));
				user.setAvatar(resultSet.getString("avatar"));
				user.setPassword(resultSet.getString("password"));
				user.setRoleDescription(resultSet.getString("description"));
				user.setRoleId(resultSet.getInt("role_id"));
				list.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int insert(User entity) {
		try {
			Connection connection = MySQLConnection.getConnection();
			String sql = "INSERT INTO users(email, password, fullname, avatar, role_id)" + " VALUES(?, ?, ?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, entity.getEmail());
			statement.setString(2, entity.getPassword());
			statement.setString(3, entity.getFullName());
			statement.setString(4, entity.getAvatar());
			statement.setInt(5, entity.getRoleId());
			return statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public User findById(int id) {
		try {
			Connection connection = MySQLConnection.getConnection();
			String sql = "SELECT * FROM users WHERE id = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				User user = new User();
				user.setId(resultSet.getInt("id"));
				user.setEmail(resultSet.getString("email"));
				user.setFullName(resultSet.getString("fullname"));
				user.setAvatar(resultSet.getString("avatar"));
				user.setPassword(resultSet.getString("password"));
				user.setRoleId(resultSet.getInt("role_id"));
				return user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int update(User entity) {
		try {
			Connection connection = MySQLConnection.getConnection();
			String sql = "UPDATE users SET email = ?, password = ?, fullname = ?, avatar = ?,"
					+ "role_id = ? WHERE id = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, entity.getEmail());
			statement.setString(2, entity.getPassword());
			statement.setString(3, entity.getFullName());
			statement.setString(4, entity.getAvatar());
			statement.setInt(5, entity.getRoleId());
			statement.setInt(6, entity.getId());
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
			String sql = "DELETE FROM users WHERE id = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public int removeUserFromProject(int userId, int projectId) {
		try {
			Connection connection = MySQLConnection.getConnection();
			String sql = "UPDATE users SET project_id = null WHERE id = ? AND project_id = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, userId);
			statement.setInt(2, projectId);
			return statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<User> findByProjectId(int projectId) {
		List<User> entities = new ArrayList<>();
		try {
			Connection connection = MySQLConnection.getConnection();
			String sql = "SELECT * FROM users, user_project WHERE id = userid AND projectid = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, projectId);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				User user = new User();
				user.setId(result.getInt("id"));
				user.setEmail(result.getString("email"));
				user.setFullName(result.getString("fullname"));
				user.setAvatar(result.getString("avatar"));
				user.setPassword(result.getString("password"));
				user.setRoleId(result.getInt("role_id"));
				entities.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return entities;
	}

}
