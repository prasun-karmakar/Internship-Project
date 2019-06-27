package com.signify.internshipproject.useridentityservice.db;
import java.util.Properties;

import com.signify.internshipproject.useridentityservice.db.File;


public enum PropertyManager {
	   INSTANCE;   
    private Properties properties;


    private PropertyManager(){
    	try {
        properties = new Properties();
        File file=File.ConfigFile;
        properties.load(this.getClass().getClassLoader().getResourceAsStream(file.getValue()));
    	}
    	catch (Exception e) {
            throw new RuntimeException("Error when loading configuration file", e);
        }
    }


    public String getValue(String key) {
        return properties.getProperty(key);
    }

}
