package com.example.jdbc.runner;

import java.sql.SQLException;

import com.example.jdbc.business.UserManager;
import com.example.jdbc.business.UserManagerHelper;
import com.example.jdbc.dao.abstracts.UserDaoManagerHelper;
import com.example.jdbc.dao.concreate.UserDaoManager;
import com.example.jdbc.entitiy.Address;
import com.example.jdbc.entitiy.Company;
import com.example.jdbc.entitiy.Geo;
import com.example.jdbc.entitiy.User;
import com.example.jdbc.utils.JdbcUtils;

public class Runner {
	public static void main(String[] args) {
		// JdbcUtils.getConnection();
		User user = new User();
		user.setName("bekir");
		user.setEmail("bekir zeyveli");
		user.setPhone("111111111111");
		user.setWebsite("zeyveli");
		
		
		Address address =new Address();
		address.setStreet("malatya");
		address.setCity("istanbul");
		address.setZipcode("10000");
		
		Geo geo =new Geo();
		geo.setLat(1200000);
		geo.setLgn(102220);
		address.setGeo(geo);
		
		Company company = new Company();
		company.setName("zeyveli");
		company.setCatchPhrase("malatya");
		company.setBs("istanbul");
		
		user.setAddress(address);
		user.setCompany(company);
	
		UserManagerHelper<User> userManagerHelper  = new UserManager(new UserDaoManager());
		try {
			userManagerHelper.create(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}
}
