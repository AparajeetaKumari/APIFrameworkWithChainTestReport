package config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.aventstack.chaintest.plugins.ChainTestListener;

public class ConfigReader {
	Properties pro = new Properties();
	public ConfigReader() 
	{
		
		try {
			File file = new File("src/main/resources/config.properties");
			FileInputStream fis = new FileInputStream(file);
			pro.load(fis);
			
		}
		catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	
	public String getProperty(String key) {
		ChainTestListener.log("Getting the Property");
		return pro.getProperty(key);
		
	}

}
