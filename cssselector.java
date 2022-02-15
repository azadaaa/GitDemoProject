package cssselector;


import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import project.pages.OrangeHRPPages;

public class TestCase14 {

	OrangeHRPPages OrangeOR;
	WebDriver Driver;
	Properties prop;

	@Test(priority=1)
	@Parameters({"Browser","Url", })
	public void Login(String Browser, String Url) {

		if(Browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Soft\\Jarfiles\\chromedriver_win32\\chromedriver.exe");
			ChromeOptions co = new ChromeOptions();
			Driver 	= new ChromeDriver(co);
		} else if(Browser.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", "C:\\Soft\\Jarfiles\\IEDriverServer_x64_3.150.1\\IEDriverServer.exe");
			Driver 	= new InternetExplorerDriver();
		} 

		FileInputStream fileLoc;
		try {
			String PropertiesFileLoc ="C:/Users/karrivi/git/SeleniumAssignment/LiveProject/src/test/java/project/testdata/OrangeHRPTestdata.properties";
			fileLoc = new FileInputStream(PropertiesFileLoc);
			prop = new Properties();
			prop.load(fileLoc);
			//System.out.println(prop);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		OrangeOR = new OrangeHRPPages(Driver);
		Driver.manage().window().maximize();
		String Title = Driver.getTitle();
		System.out.println(Title);
		Driver.get(Url);

		String  Name = prop.getProperty("username");
			OrangeOR.settextforUserName(Name);
		String  Pswrd = prop.getProperty("password");
			OrangeOR.setTextforPassword(Pswrd);
			OrangeOR.setStaySignedInClick();
	}


	@Test(priority=2)
	public void pimTab() {
		WebElement PIM = Driver.findElement(By.cssSelector("#menu_pim_viewPimModule > b"));
		System.out.println(PIM.getText());
		PIM.click();
	}
	@Test(priority=3)
	public void timeTab() {
		WebElement Time = Driver.findElement(By.cssSelector("#menu_time_viewTimeModule > b"));
		System.out.println(Time.getText());
		Time.click();
	}

	@Test(priority=4)
	public void maintenance() {
		WebElement MNT = Driver.findElement(By.cssSelector("#menu_maintenance_purgeEmployee > b"));
		System.out.println(MNT.getText());
		MNT.click();
	}

	@Test(priority=5)
	public void assignLeaveTab() {
		WebElement Leave = Driver.findElement(By.cssSelector("#dashboard-quick-launch-panel-menu_holder > table > tbody > tr > td:nth-child(1) > div"));
		System.out.println(Leave.getText());
		Leave.click();
	}

	@Test(priority=6)
	public void timeSheetTab() {
		WebElement Timesheet = Driver.findElement(By.cssSelector("#dashboard-quick-launch-panel-menu_holder > table > tbody > tr > td:nth-child(1) > div"));
		System.out.println(Timesheet.getText());
		Timesheet.click();
	}	


	@Test(priority=7)
	public void close() {
		Driver.close();
	}

} 
