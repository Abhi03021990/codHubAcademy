package frameworkUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {
	Properties properties;
	public PropertiesReader(String path) throws FileNotFoundException, IOException {
		// TODO Auto-generated constructor stub
		properties = new Properties();
		properties.load(new FileInputStream(path));	
	}
	public String getData(String key) {
		return properties.getProperty(key);
	}

}
