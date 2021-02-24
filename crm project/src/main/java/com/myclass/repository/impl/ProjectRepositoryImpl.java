package com.myclass.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.myclass.connection.MySQLConnection;
import com.myclass.dto.ProjectDTO;
import com.myclass.entity.Project;
import com.myclass.repository.ProjectRepository;

public class ProjectRepositoryImpl implements ProjectRepository{

	@Override
	public List<ProjectDTO> findAll() {
		List<ProjectDTO> projects = new ArrayList<>();
		try {
			Connection connection = MySQLConnection.getConnection();
			String sql = "SELECT * FROM users u, project p WHERE u.id = p.leader";
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				ProjectDTO project = new ProjectDTO();
				project.setId(resultSet.getInt("p.id"));
				project.setLeaderName(resultSet.getString("fullname"));
				project.setLeader(resultSet.getInt("u.id"));
				project.setName(resultSet.getString("name"));
				project.setStartDate(resultSet.getDate("startdate"));
				project.setEndDate(resultSet.getDate("enddate"));
				projects.add(project);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return projects;
	}

	@Override
	public int insert(Project entity) {
		try {
			Connection connection = MySQLConnection.getConnection();
			String sql = "INSERT INTO project(name, startdate, enddate, leader)"
					+ "VALUES(?, ?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, entity.getName());
			statement.setDate(2, entity.getStartDate());
			statement.setDate(3, entity.getEndDate());
			statement.setInt(4, entity.getLeader());
			return statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public Project findById(int id) {
		try {
			Connection connection = MySQLConnection.getConnection();
			String sql = "SELECT * FROM project WHERE id = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();
			if(resultSet.next()) {
				Project project = new Project();
				project.setId(resultSet.getInt("id"));
				project.setLeader(resultSet.getInt("leader"));
				project.setName(resultSet.getString("name"));
				project.setStartDate(resultSet.getDate("startdate"));
				project.setEndDate(resultSet.getDate("enddate"));
				return project;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void deleteByLeader(int leader) {
		try {
			Connection connection = MySQLConnection.getConnection();
			String sql = "DELETE FROM project WHERE leader = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, leader);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int update(Project entity) {
		try {
			Connection connection = MySQLConnection.getConnection();
			String sql = "UPDATE project SET name = ?, startdate = ?, enddate = ?, leader = ? WHERE id = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, entity.getName());
			statement.setDate(2, entity.getStartDate());
			statement.setDate(3, entity.getEndDate());
			statement.setInt(4, entity.getLeader());
			statement.setInt(5, entity.getId());
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
			String sql = "DELETE FROM project WHERE id = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
