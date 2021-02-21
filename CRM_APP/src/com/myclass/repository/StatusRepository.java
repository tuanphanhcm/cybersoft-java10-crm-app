package com.myclass.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.myclass.connection.DbConnection;
import com.myclass.entity.Status;

public class StatusRepository {
	public List<Status> findAll(){
		List<Status> status = new ArrayList<>();
		Connection connection = DbConnection.getConnection();
		String query = "SELECT * FROM status";
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet resultSet =  statement.executeQuery();
			while(resultSet.next()) {
				Status entity = new Status();
				entity.setId(resultSet.getInt("id"));
				entity.setName(resultSet.getNString("name"));
				status.add(entity);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}
}
