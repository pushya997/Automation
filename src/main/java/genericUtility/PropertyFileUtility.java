package genericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileUtility {
public String toReadtheDataFromProperties(String Key) throws IOException {
	FileInputStream fis=new FileInputStream("C:\\Users\\gpras\\OneDrive\\Desktop\\Q SPIDERS\\commondata.properties");
	Properties prop=new Properties();
	prop.load(fis);
	String value = prop.getProperty(Key);
	String	env = System.getProperty(Key);
	if(env!=null&&env.length()>0) {
		return env;
	}
	return value;
	
	
	
}
}
