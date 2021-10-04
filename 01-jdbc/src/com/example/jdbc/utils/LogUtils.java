package com.example.jdbc.utils;

import java.util.logging.Level;
import java.util.logging.Logger;

public final class LogUtils {

	private static final Logger LOGGER = Logger.getLogger(LogUtils.class.getName());

	static {
		LOGGER.setLevel(Level.CONFIG);
	}

	private LogUtils() {

	}

	public static void info(String msg) {
		if (LOGGER.isLoggable(Level.INFO)) {
			LOGGER.info(msg);
		}
	}

	public static void warning(String msg) {
		if (LOGGER.isLoggable(Level.INFO)) {
			LOGGER.warning(msg);
		}
	}

	public static void severe(String msg) {
		if (LOGGER.isLoggable(Level.INFO)) {
			LOGGER.severe(msg);
		}
	}

}
