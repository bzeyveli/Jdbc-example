package com.example.jdbc.dao.abstracts;

import java.sql.SQLException;
import java.util.List;

import com.example.jdbc.entitiy.User;

public interface UserDaoManagerHelper<T> {
	
	boolean create(T object) throws SQLException;

	List<T> read() throws SQLException;

	boolean update(T object) throws SQLException;

	boolean delete(int userId) throws SQLException;
}
