package com.hrm.util;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class Config{
	
	public static final String CONFIG_PRP="config.properties";
	static Properties prop;
	
	static{
		prop = new Properties();
	    String fileName = CONFIG_PRP;
	    try {
	    InputStream is = new FileInputStream(fileName);
	    prop.load(is);
	    }
	    catch(Exception e) {
	    	e.printStackTrace();
	    }
	}
	
	public static String getProperty(String key) {
			String value= prop.getProperty(key);
			if ((value != null) && (!value.isEmpty()))
                return value;
			else
				System.out.println(key+ " is not present in congiguration file" + CONFIG_PRP);
				return null;
	}
	
}
