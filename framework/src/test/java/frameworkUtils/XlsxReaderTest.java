package frameworkUtils;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class XlsxReaderTest {
	XlsxReader test;
	
  @BeforeTest
  public void initialize() throws FileNotFoundException, IOException {
	  test = new XlsxReader("D:\\Java Training\\codHubAcademy\\framework\\src\\test\\resources\\testData\\QA\\test.xlsx");
  }


  @Test(enabled = false)
  public void getDataTestStringintint() {
	  System.out.println(test.getData("Sheet1", 1, 1));
    Assert.assertEquals(test.getData("Sheet1", 1, 1), "https://www.bing.com");
  }

  @Test(enabled = false)
  public void getDataTestStringStringint() {
	  System.out.println(test.getData("Sheet1", "Url", 2));
	  Assert.assertEquals(test.getData("Sheet1", "Url", 2), "https://www.google.com");;
  }

  @Test(enabled = true)
  public void getDataTestStringStringString() {
	 // System.out.println(test.getData("Sheet1", "TC002", "Url"));
	  System.out.println(test.getData("Sheet1", "TC010", "Url"));
	  System.out.println(test.getData("Sheet1", "TC010", "username"));
	  Assert.assertEquals(test.getData("Sheet1", "TC002", "Url"), "https://www.google.com");;
  }

 
}
