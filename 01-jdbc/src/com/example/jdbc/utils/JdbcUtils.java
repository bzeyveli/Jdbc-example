package com.example.jdbc.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public final class JdbcUtils {
	private static Connection connection = null;
	private static Statement statement = null;
	private static PreparedStatement preparedStatement = null;

	private JdbcUtils() {

	}

	public static Connection getConnection() {

		try {
			LogUtils.info("Db properties okunuyor...");
			Properties properties = DbConfigUtil.readDbProperties();
			LogUtils.info("Db properties okundu.");
			LogUtils.info("Db baðlantýsý kuruluyor...");
			connection = DriverManager.getConnection(properties.getProperty("db.url"),
					properties.getProperty("db.user"), properties.getProperty("db.password"));
			LogUtils.info("Db baðlantýsý kuruldu.");
		} catch (SQLException e) {
			LogUtils.severe("Db baðlantýsý kurulamadý!!!");
			e.printStackTrace();
		}
		return connection;
	}

	public static Statement getStatement() {
		try {
			connection.commit();
			connection = getConnection();
			statement = connection.createStatement();
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return statement;
	}

	public static PreparedStatement getPreparedStatement(String sql) {
	     String columnNames[] = new String[] { "id" };
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(sql,columnNames);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return preparedStatement;
	}

	public static void close() {
		closeConnection();
		closeStatement();
		closePreparedStatement();
	}

	public static void closeConnectionAndStatement() {
		closeConnection();
		closeStatement();
	}

	public static void closeConnectionAndPreparedStatement() {
		closeConnection();
		closePreparedStatement();
	}

	public static void closeConnection() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void closeStatement() {
		try {
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void closePreparedStatement() {
		try {
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void rollback() {
		if(connection != null) {
			try {
				connection.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
