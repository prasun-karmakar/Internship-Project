package com.signify.internship.project.db;

import java.util.Properties;


public enum PropertyManager {
	   INSTANCE;   
    private Properties properties;


    private PropertyManager(){
    	try {
        properties = new Properties();
        properties.load(this.getClass().getClassLoader().getResourceAsStream("config.properties"));
    	}
    	catch (Exception e) {
            throw new RuntimeException("Error when loading configuration file", e);
        }
    }


    public String getValue(String key) {
        return properties.getProperty(key);
    }

}


/*public enum PropertyManager {
	/*USERNAME("username"),
	PASSWORD("password"),
	DATABASE("database"),
	PORT("port"),
	HOST("host"),
	JDBC("jdbc");
	INSTANCE;
	private String value;
	

	
	Properties properties = new Properties();
	   private PropertyManager() {
        try {
        	/*InputStream file = new FileInputStream(new File("db.properties")) ;
            Properties properties = new Properties();
            properties.load(file);
     
            properties.load(Configuration.class.getClassLoader().getResourceAsStream("config.properties"));
        } catch (Exception e) {
            throw new RuntimeException("Error when loading configuration file", e);
        }
    }

    
    public String getValueForKey(String key) {
    	return properties.getProperty(key);
    
    }

    public void setValue(String value) {
        this.value=value;
    }
}*/

