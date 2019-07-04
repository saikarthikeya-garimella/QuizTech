/*
 * 
 */
package fr.epita.quiz.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

// TODO: Auto-generated Javadoc
/**
 * The Class Configuration.
 */
public class Configuration { // singleton class

	/** The properties. */
 private Properties properties; // loaded with constructor 
	
	/** The configuration. */
	public static Configuration configuration; // initialized the 
											 //first time you call getInstance
	
	/**
 											 * Instantiates a new configuration.
 											 *
 											 * @throws IOException Signals that an I/O exception has occurred.
 											 */
 											private Configuration() throws  IOException {
		File file = new File("database.properties");
		properties = new Properties();
		properties.load(new FileInputStream(file));
	}
	
	/**
	 * Gets the single instance of Configuration.
	 *
	 * @return single instance of Configuration
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static Configuration getInstance() throws  IOException {
		if (configuration == null) { // if there is no instance created yet
			configuration = new Configuration(); // initialize configuration
		}
		return configuration;
	}
	
	/**
	 * Gets the property value.
	 *
	 * @param property the property
	 * @return the property value
	 */
	public String getPropertyValue(String property) {
		return properties.getProperty(property);
	}
	
}
