package com.example.jdbc.dao.abstracts;

import java.sql.SQLException;
import java.util.List;

import com.example.jdbc.entitiy.User;

public interface UserDaoManagerHelper<User> {
	
	boolean create(User user) throws SQLException;

	List<User> read() throws SQLException;

	boolean update(User user) throws SQLException;

	boolean delete(int userId) throws SQLException;
}
