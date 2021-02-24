package com.myclass.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.myclass.connection.MySQLConnection;
import com.myclass.entity.ProjectUser;
import com.myclass.entity.User;
import com.myclass.repository.ProjectUserRepository;

public class ProjectUserRepositoryImpl implements ProjectUserRepository {

	@Override
	public List<ProjectUser> findByProjectId(int projectId) {
		List<ProjectUser> list = new ArrayList<>();
		try {
			Connection connection = MySQLConnection.getConnection();
			String sql = "SELECT * FROM user_project WHERE projectid = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, projectId);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				ProjectUser projectUser = new ProjectUser();
				projectUser.setProjectId(resultSet.getInt("projectid"));
				projectUser.setUserId(resultSet.getInt("userid"));
				projectUser.setRole(resultSet.getString("role"));
				projectUser.setJoinDate(resultSet.getDate("joindate"));
				list.add(projectUser);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void deleteByProjectId(int projectId) {
		try {
			Connection connection = MySQLConnection.getConnection();
			String sql = "DELETE FROM user_project WHERE projectid = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, projectId);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<User> usersHasNotJoin(int projectId) {
		List<User> entities = new ArrayList<>();
		try {
			Connection connection = MySQLConnection.getConnection();
			String sql = "SELECT * FROM users WHERE id NOT IN"
					+ " (SELECT userid FROM user_project WHERE projectid = ?) AND role_id =3";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, projectId);
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {
				User entity = new User();
				entity.setId(resultSet.getInt("id"));
				entity.setEmail(resultSet.getString("email"));
				entity.setPassword(resultSet.getString("password"));
				entity.setFullName(resultSet.getString("fullname"));
				entity.setAvatar(resultSet.getString("avatar"));
				entity.setRoleId(resultSet.getInt("role_id"));
				entities.add(entity);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return entities;
	}

	@Override
	public int insert(ProjectUser entity) {
		try {
			Connection connection = MySQLConnection.getConnection();
			String sql = "INSERT INTO user_project VALUES(?, ?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, entity.getProjectId());
			statement.setInt(2, entity.getUserId());
			statement.setDate(3, entity.getJoinDate());
			statement.setString(4, entity.getRole());
			return statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
