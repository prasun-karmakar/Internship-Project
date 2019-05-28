package com.signify.internship.project.demo;

import java.util.ResourceBundle;

public class ApplicationSingleton {
	private static enum Singleton {
        INSTANCE;               

        private ResourceBundle bundle;

        private Singleton() {
            System.out.println("Singleton instance is created: " + 
            System.currentTimeMillis());

            bundle = ResourceBundle.getBundle("MessageBundle");
        }

        private ResourceBundle getResourceBundle() {
            return bundle;
        }

        private String getResourceAsString(String name) {
            return bundle.getString(name);
        }
    };

    private ApplicationSingleton() {}

    public static ResourceBundle getResourceBundle() {
        return Singleton.INSTANCE.getResourceBundle();
    }

    public static String getResourceAsString(String name) {
        return Singleton.INSTANCE.getResourceAsString(name);
    }
}
