package framework;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import frameworkUtils.PropertiesReader;

public class PropertiesReaderTest {
	PropertiesReader config;
	@BeforeTest
	public void setPath() throws FileNotFoundException, IOException {
		config = new PropertiesReader("D:/Java Training/codHubAcademy/framework/config.properties");
		
	}
	@Test(dataProvider = "test1")
	public void testGetdata(String key , String expectedVal) {
		String actual =config.getData(key);
		Assert.assertEquals(actual ,expectedVal);
		
	}
	@DataProvider(name="test1")
	public Object[][] propertiesReaderValue(){
		Object keyValpairs [][] = {{"browser","chrome"} ,{"environment" ,"QA"} ,{"QAurl" ,"https://www.bing.co.in"}};
		return keyValpairs;
		
	}

}
