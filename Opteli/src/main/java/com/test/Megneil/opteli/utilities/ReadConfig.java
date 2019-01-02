package com.test.Megneil.opteli.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

public Properties pro;
	
	public ReadConfig()
	{
		
		File src = new File("./Configuration/config.properties");
		
		//File f = new File("C://Users//Humera//git//SeleniumPractice//mavenproject//Configuration//config.properties");
		//
		try{
		FileInputStream fis = new FileInputStream(src);
		
		pro = new Properties();
		
		pro.load(fis);
		}
		catch(Exception e)
		{
			System.out.println("Exception is"+e.getMessage());
		}
		}
	
	public String getApplication()
	{
		String url = pro.getProperty("baseURL");
		return url;	
    }
	
	public String getClientID()
	{
		String ClientID = pro.getProperty("ClientID");
		return ClientID;
	}
	
	public String getUsername()
	{
		String username = pro.getProperty("username");
		return username;
	}
	
	public String getPassword()
	{
		String password = pro.getProperty("password");
		return password;
	}
	
	public String getChromepath()
	{
		String chromepath = pro.getProperty("chromepath");
		return chromepath;
	}
	
	public String getFirefoxpath()
	{
		String firefoxpath = pro.getProperty("firefoxpath");
		return firefoxpath;
	}
}
