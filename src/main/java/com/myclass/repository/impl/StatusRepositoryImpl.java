package com.myclass.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.myclass.connection.MySQLConnection;
import com.myclass.entity.Status;
import com.myclass.repository.StatusRepository;

public class StatusRepositoryImpl implements StatusRepository {

	@Override
	public Status findById(int id) {
		try {
			Connection connection = MySQLConnection.getConnection();
			String sql = "SELECT * FROM status WHERE id = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();
			if(resultSet.next()) {
				Status status = new Status();
				status.setId(resultSet.getInt("id"));
				status.setName(resultSet.getString("name"));
				return status;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
