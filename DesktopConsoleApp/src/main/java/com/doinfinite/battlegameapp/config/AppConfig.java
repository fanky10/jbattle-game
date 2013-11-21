package com.doinfinite.battlegameapp.config;

import java.io.IOException;
import java.util.Properties;

public class AppConfig {
	private static Properties configurationProperties = new Properties();

	private static Properties getConfigurationProperties() {
		if (configurationProperties.isEmpty()) {
			try {
				System.err.println(" it was EMPTY!");
				// load a properties file from class path, inside static method
				configurationProperties.load(AppConfig.class.getClassLoader()
						.getResourceAsStream("app-config.properties"));
			} catch (IOException ex) {
				// properties file not found, ignored
			}
		}
		return configurationProperties;
	}

	public static String getWelcomeMessage() {
		return getConfigurationProperties().getProperty("app.welcome");
	}

}
