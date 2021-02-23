package com.myclass.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.myclass.connection.DbConnection;
import com.myclass.dto.ProjectDto;
import com.myclass.entity.Project;

public class ProjectRepository {

	public List<ProjectDto> findAll() {
		Connection conn = DbConnection.getConnection();

		if (conn == null)
			return null;

		List<ProjectDto> projectList = new ArrayList<ProjectDto>();
		String query = "SELECT\r\n"
				+ "	P.id,\r\n"
				+ "	P.`name`,\r\n"
				+ "	P.startDate,\r\n"
				+ "	P.endDate,\r\n"
				+ "	U.fullname createUserName\r\n"
				+ "FROM\r\n"
				+ "	PROJECT P,\r\n"
				+ "	`USER`	U\r\n"
				+ "WHERE\r\n"
				+ "	P.createUser = U.id\r\n"
				+ "ORDER BY\r\n"
				+ "	P.id;";
		try {
			PreparedStatement statement = conn.prepareStatement(query);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				ProjectDto dto = new ProjectDto();

				dto.setId(resultSet.getInt("id"));
				dto.setName(resultSet.getString("name"));
				dto.setStartDate(resultSet.getDate("startDate"));
				dto.setEndDate(resultSet.getDate("endDate"));
				dto.setCreateUserName(resultSet.getString("createUserName"));

				projectList.add(dto);
			}
			
			return projectList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public int remove(int idDelete) {
		// TODO Auto-generated method stub
		Connection conn = DbConnection.getConnection();
		String query = "DELETE FROM PROJECT WHERE id=?";
		try {
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, idDelete);
			statement.executeUpdate();
			return 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return -1;
	}

	public int save(Project entity) {
		// TODO Auto-generated method stub
		Connection conn = DbConnection.getConnection();
		String query = "INSERT INTO PROJECT (name , description , startDate , endDate , createUser) value ( ? , ? , ? , ? , ?)";

		try {
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, entity.getName());
			statement.setString(2, entity.getDescription());
			statement.setString(3, entity.getStartDate());
			statement.setString(4, entity.getEndDate());
			statement.setInt(5, entity.getCreateUser());
			return statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}

	public Project findById(int id) {
		Connection conn = DbConnection.getConnection();
		
		if(conn == null)
			return null;
		
		String query = "SELECT\r\n"
				+ "	P.id,\r\n"
				+ "	P.`name`,\r\n"
				+ "	P.startDate,\r\n"
				+ "	P.endDate,\r\n"
				+ "	P.createUserName,\r\n"
				+ "	U.fullname `joinUserName`\r\n"
				+ "FROM\r\n"
				+ "	( SELECT\r\n"
				+ "			P.id,\r\n"
				+ "			P.`name`,\r\n"
				+ "			P.startDate,\r\n"
				+ "			P.endDate,\r\n"
				+ "			U.fullname createUserName\r\n"
				+ "		FROM\r\n"
				+ "			PROJECT P,\r\n"
				+ "			`USER`	U\r\n"
				+ "		WHERE\r\n"
				+ "			P.createUser = U.id ) AS P,\r\n"
				+ "	`USER`	U,\r\n"
				+ "	USER_PROJECT UP\r\n"
				+ "WHERE\r\n"
				+ "	P.id = UP.projectId \r\n"
				+ "	AND\r\n"
				+ "	U.id = UP.userId\r\n"
				+ "ORDER BY\r\n"
				+ "	P.id;";
		Project entity = null;
		try {
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				entity = new Project();
				entity.setId(resultSet.getInt("id"));
				entity.setName(resultSet.getString("name"));
				entity.setDescription(resultSet.getString("description"));
				entity.setStartDate(resultSet.getString("startDate"));
				entity.setEndDate(resultSet.getString("endDate"));
				entity.setCreateUser(resultSet.getInt("createUser"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return entity;
	}

	public int edit(Project project) {
		Connection conn = DbConnection.getConnection();
		String query = "UPDATE PROJECT SET  name= ? , description = ? , startDate = ? , endDate = ? , createUser = ? WHERE id = ?";
		try {
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, project.getName());
			statement.setString(2, project.getDescription());
			statement.setString(3, project.getStartDate());
			statement.setString(4, project.getEndDate());
			statement.setInt(5, project.getCreateUser());
			statement.setInt(6, project.getId());
			return statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}

}
