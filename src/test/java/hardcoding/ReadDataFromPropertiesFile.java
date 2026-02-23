package hardcoding;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadDataFromPropertiesFile {

	public static void main(String[] args) throws IOException {
		
		//Create a java representation object of physical file
		FileInputStream fis = new FileInputStream("C:\\Users\\gpras\\OneDrive\\Desktop\\Q SPIDERS\\commondata.properties");
		
		//Create a object of properties file
		Properties prop = new Properties();
		
		//load all the data from fis to prop
		prop.load(fis);
		
		//Reading the data
		String BROWSER = prop.getProperty("Browser");
		String URL = prop.getProperty("URL");
		String USERNAME = prop.getProperty("Username");
		String PASSWORD = prop.getProperty("Password");
		
		System.out.println(BROWSER);
		System.out.println(URL);
		System.out.println(USERNAME);
		System.out.println(PASSWORD);
		
	}

}
