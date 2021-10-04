package com.example.jdbc.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class DbConfigUtil {

	private static final String PROPERTIES_NAME = "src\\db.properties";
	
	private DbConfigUtil() {

	}

	public static Properties readDbProperties() {
		Properties properties = new Properties();
		try (InputStream inputStream = new FileInputStream(PROPERTIES_NAME)){
			properties.load(inputStream);
		} catch (IOException | RuntimeException e) {
			LogUtils.severe("Properties bilgileri alýnamadý!!!");
			e.printStackTrace();
		}
		
		return properties;
	}

}
