package com.example.jdbc.dao.concreate;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.jdbc.dao.abstracts.UserDaoManagerHelper;
import com.example.jdbc.entitiy.Address;
import com.example.jdbc.entitiy.Company;
import com.example.jdbc.entitiy.Geo;
import com.example.jdbc.entitiy.User;
import com.example.jdbc.utils.JdbcUtils;

public class UserDaoManager implements UserDaoManagerHelper<User> {
	List<String> list = new ArrayList<>();

	@Override
	public boolean create(User user) throws SQLException {
		String add = "INSERT INTO users (name,email,phone,web_site,address_id,company_id) VALUES (?,?,?,?,?,?)";
		int companyId = createCompany(user.getCompany());
		int geoId = createGeo(user.getAddress().getGeo());
		int addressId = createAddress(user.getAddress(), geoId);
		return createUser(user, addressId, companyId);

	}

	private boolean createUser(User user, int addressId, int companyId) {
		int affectedRows = 0;
		String insertSql = "INSERT INTO users (name,email,phone,web_site,address_id,company_id) VALUES (?,?,?,?,?,?)";
		PreparedStatement preparedStatement = JdbcUtils.getPreparedStatement(insertSql);
		try {
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getEmail());
			preparedStatement.setString(3, user.getPhone());
			preparedStatement.setString(4, user.getWebsite());
			preparedStatement.setInt(5, addressId);
			preparedStatement.setInt(6, companyId);
			affectedRows = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return affectedRows > 0;

	}

	private int createAddress(Address address, int geoId) {
		int addressId = 0;
		String insertSql = "INSERT INTO address (street,city,zipcode,geo_id) VALUES (?,?,?,?)";
		PreparedStatement preparedStatement = JdbcUtils.getPreparedStatement(insertSql);
		try {
			preparedStatement.setString(1, address.getStreet());
			preparedStatement.setString(2, address.getCity());
			preparedStatement.setString(3, address.getZipcode());
			preparedStatement.setInt(4, geoId);
			try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
	            if (generatedKeys.next()) {
	                address.setId(generatedKeys.getInt(1));
	            }
	        }catch (Exception e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.closeConnectionAndPreparedStatement();
		}
		return address.getId();
	}

	private int createGeo(Geo geo) {
		int geoId = 0;
		String insertSql = "INSERT INTO geo (lat,lgn) VALUES (?,?)";
		PreparedStatement preparedStatement = JdbcUtils.getPreparedStatement(insertSql);
		try {
			preparedStatement.setDouble(1, geo.getLat());
			preparedStatement.setDouble(2, geo.getLgn());
			try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
	            if (generatedKeys.next()) {
	                geo.setId(generatedKeys.getInt(1));
	            }
	            else {
	                throw new SQLException("Hata oluþtu.");
	            }
	        }
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.closeConnectionAndPreparedStatement();
		}
		return geo.getId();
	}

	private int createCompany(Company company) {
		int companyId = 0;
		String insertSql = "INSERT INTO company (name,catch_phrase,bs) VALUES (?,?,?)";
		PreparedStatement preparedStatement = JdbcUtils.getPreparedStatement(insertSql);
		try {
			preparedStatement.setString(1, company.getName());
			preparedStatement.setString(2, company.getCatchPhrase());
			preparedStatement.setString(3, company.getBs());
			 try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
		            if (generatedKeys.next()) {
		                company.setId(generatedKeys.getInt(1));
		            }
		            else {
		                throw new SQLException("Hata oluþtu.");
		            }
		        }
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.closeConnectionAndPreparedStatement();
		}
		return company.getId();
	}

	@Override
	public List<User> read() throws SQLException {

		/*
		 * String read = "SELECT * FROM users"; try { Statement statement =
		 * JdbcUtils.getStatement(); ResultSet result = statement.executeQuery(read);
		 * while (result.next()) { list.add(result.getString("id"));
		 * list.add(result.getString("name")); list.add(result.getString("user_name"));
		 * list.add(result.getString("email")); list.add(result.getString("phone"));
		 * list.add(result.getString("web_site"));
		 * list.add(result.getString("address_id"));
		 * list.add(result.getString("company_id")); } } catch (SQLException e) {
		 * e.printStackTrace(); } finally {
		 * 
		 * JdbcUtils.closeConnectionAndStatement();
		 * 
		 * }
		 */
		return null;
	}

	@Override
	public boolean update(User user) throws SQLException {
		String update = "UPDATE users SET name = ? , email = ?, phone = ? , web_site = ?  where  user_name = ?";
		try {
			PreparedStatement preparedStatement = JdbcUtils.getPreparedStatement(update);
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getEmail());
			preparedStatement.setString(3, user.getPhone());
			preparedStatement.setString(4, user.getWebsite());
			preparedStatement.setString(5, user.getName());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.closeConnectionAndPreparedStatement();
		}
		return true;
	}

	@Override
	public boolean delete(int id) throws SQLException {
		String delete = "delete FROM users where id = ? ";
		try {
			PreparedStatement preparedStatement = JdbcUtils.getPreparedStatement(delete);
			preparedStatement.setInt(1, id);
			preparedStatement.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.closeConnectionAndPreparedStatement();
		}

		return true;
	}

}
