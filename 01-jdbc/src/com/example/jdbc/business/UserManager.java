package com.example.jdbc.business;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.jdbc.dao.abstracts.UserDaoManagerHelper;
import com.example.jdbc.entitiy.User;

public class UserManager implements UserManagerHelper {

	private UserDaoManagerHelper userDaoManagerHelper;

	public UserManager(UserDaoManagerHelper userDaoManagerHelper) {
		this.userDaoManagerHelper = userDaoManagerHelper;
	}

	@Override
	public boolean create(User object) throws SQLException {
		return  userDaoManagerHelper.create(object);
	}

	@Override
	public List<User> read() throws SQLException {
		return new ArrayList<User>();
	}

	@Override
	public boolean update(User object) throws SQLException {
		
		return false;
	}

	@Override
	public boolean delete(User object) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}



}
