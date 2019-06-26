package com.signify.internshipproject.webappservice.db;
import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceBundleManager {
	
	

    public static String getString(final String BundleName, final String key,final int language_id) {
    	
    	switch (language_id) {
        case 1: 
        	Locale locale1=new Locale("en", "US");
        	ResourceBundle rb = ResourceBundle.getBundle(BundleName, locale1);
        	return rb.getString(key);
		case 2:
        	Locale locale2=new Locale("fr","FR");
        	ResourceBundle rb1 = ResourceBundle.getBundle(BundleName, locale2);
        	return rb1.getString(key);
		case 3:
			Locale locale3=new Locale("in","ID");
			ResourceBundle rb2 = ResourceBundle.getBundle(BundleName, locale3);
        	return rb2.getString(key);


        
    }
		return key;
		
          
    }
    
    
}





/*public class ResourceManager {

    private String bundleName = null;

    ResourceBundle resourceBundle = null;

    public ResourceManager(String bundle){
        this.bundleName = bundle;
        loadProperty();
    }

    public void loadProperty(){
        try{
            resourceBundle = ResourceBundle.getBundle(bundleName);
        } catch(Exception e){
           e.printStackTrace();
        }
    }

    public static void main(String a[]){
        try{
            ResourceManager pr = new ResourceManager("resources/");
        } catch(Exception e){
            e.printStackTrace();
        }
    }

}*/







/*public enum ResourceManager {
	        INSTANCE;               

	        private ResourceBundle bundle;

	        private ResourceManager() {
	        	try {
	        	 Locale locale=new Locale("en","US");
	        	 Locale.setDefault(new Locale("fr", "FR"));
				 ResourceBundle b1 = ResourceBundle.getBundle("MessageBundle", locale);
				 
	        
	        	}
	        	catch(Exception e) {
	        		throw new RuntimeException("Error when loading configuration file", e);
	        		
	        	}
	        	
	        }*/
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	   

	        /*private ResourceBundle getResourceBundle1() {
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
	    }*/
	


