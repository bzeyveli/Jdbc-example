package com.example.jdbc.business;

import java.sql.SQLException;
import java.util.List;

import com.example.jdbc.entitiy.User;

public interface UserManagerHelper {
	boolean create(User user) throws SQLException;

	List<User> read() throws SQLException;

	boolean update(User user) throws SQLException;

	boolean delete(User user) throws SQLException;
}
