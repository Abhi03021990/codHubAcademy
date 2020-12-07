package actions;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import frameworkUtils.CoreUtils;
import ui.ExpediaHomePage;

public class ExpediaReusableActions extends CoreUtils{
	public void enterText(String xpath , String text) throws AWTException {
		//driver.findElement(By.xpath("//button[@aria-label='Leaving from']")).click()
		
		typeText(xpath, text);
		pressDownArrow(xpath);
		pressEnter(xpath);
		Robot robot = new Robot();	
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);	
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		
	}
	public void selectDate(String dateInMMDDYYYY) {
		String month = dateInMMDDYYYY.split("/")[0];
		String date = dateInMMDDYYYY.split("/")[1];
		String year = dateInMMDDYYYY.split("/")[2];
		click("//button[@id='d1-btn']");
		//WebElement dateContainer = getElement(ExpediaHomePage.DATE_PICKER);
		
		//List<WebElement> months = dateContainer.findElements(By.xpath("//div[@class='uitk-new-date-picker-menu-months-container']//div[@class='uitk-new-date-picker-month']"));
		List<WebElement> months = driver.findElements(By.xpath("//div[@class='uitk-new-date-picker-menu-months-container']//div[@class='uitk-new-date-picker-month']"));
		
		for (WebElement individualMonth : months) {
			String monthAndyear = individualMonth.findElement(By.xpath("//h2")).getText();
			//compare year
			if(year.trim().equals(monthAndyear.split(" ")[1].trim())) {
				//check for month
				if(monthAndyear.split(" ")[0].trim().equals(getMonth(month).trim())) {
					individualMonth.findElement(By.xpath("//button[@data-day='2']"));
					click("//span[text()='Done']");
					
				}
			}
			
		}
		
		
		
		
		
	}
	
	private  String getMonth(String month) { 
		if(Month.JANUARY.getValue()==Integer.parseInt(month)) {
			return Month.JANUARY.getDisplayName(TextStyle.FULL, Locale.ENGLISH);
		}else if(Month.FEBRUARY.getValue()==Integer.parseInt(month)) {
			return Month.FEBRUARY.getDisplayName(TextStyle.FULL, Locale.ENGLISH);
		}else if(Month.MARCH.getValue()==Integer.parseInt(month)) {
			return Month.MARCH.getDisplayName(TextStyle.FULL, Locale.ENGLISH);
		}else if(Month.APRIL.getValue()==Integer.parseInt(month)) {
			return Month.APRIL.getDisplayName(TextStyle.FULL, Locale.ENGLISH);
		}else if(Month.MAY.getValue()==Integer.parseInt(month)) {
			return Month.MAY.getDisplayName(TextStyle.FULL, Locale.ENGLISH);
		}else if(Month.JUNE.getValue()==Integer.parseInt(month)) {
			return Month.JUNE.getDisplayName(TextStyle.FULL, Locale.ENGLISH);
		}else if(Month.JULY.getValue()==Integer.parseInt(month)) {
			return Month.JULY.getDisplayName(TextStyle.FULL, Locale.ENGLISH);
		}else if(Month.AUGUST.getValue()==Integer.parseInt(month)) {
			return Month.AUGUST.getDisplayName(TextStyle.FULL, Locale.ENGLISH);
		}
		else if(Month.SEPTEMBER.getValue()==Integer.parseInt(month)) {
			return Month.SEPTEMBER.getDisplayName(TextStyle.FULL, Locale.ENGLISH);
		}else if(Month.OCTOBER.getValue()==Integer.parseInt(month)) {
			return Month.OCTOBER.getDisplayName(TextStyle.FULL, Locale.ENGLISH);
		}else if(Month.NOVEMBER.getValue()==Integer.parseInt(month)) {
			return Month.NOVEMBER.getDisplayName(TextStyle.FULL, Locale.ENGLISH);
		}else if(Month.DECEMBER.getValue()==Integer.parseInt(month)) {
			return Month.DECEMBER.getDisplayName(TextStyle.FULL, Locale.ENGLISH);
		}
		return null;
	}
	/*
	 * public static void main(String[] args) { //String month =
	 * ExpediaReusableActions.getMonth("13"); System.out.println(month); }
	 */

}
