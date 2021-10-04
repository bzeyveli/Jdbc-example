package com.example.jdbc.business;

import java.sql.SQLException;
import java.util.List;

public interface UserManagerHelper<T> {
	boolean create(T object) throws SQLException;

	List<T> read() throws SQLException;

	boolean update(T object) throws SQLException;

	boolean delete(T object) throws SQLException;
}
