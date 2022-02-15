package testandpriority;


import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import project.pages.OrangeHRPPages;

public class TestCase7 {
	OrangeHRPPages OrangeOR;
	WebDriver Driver;
	Properties prop;

	@BeforeTest
	@Parameters({"Browser","Url", })
	public void OpenBrowser(String Browser, String Url) {

		if(Browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Soft\\Jarfiles\\chromedriver_win32\\chromedriver.exe");
			ChromeOptions co = new ChromeOptions();
			Driver 	= new ChromeDriver(co);
		} else if(Browser.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", "C:\\Soft\\Jarfiles\\IEDriverServer_x64_3.150.1\\IEDriverServer.exe");
			Driver 	= new InternetExplorerDriver();
		} 




		OrangeOR = new OrangeHRPPages(Driver);
		Driver.manage().window().maximize();
		String Title = Driver.getTitle();
		System.out.println(Title);
		Driver.get(Url);
	}

	@Test(priority=1)
	public void Login() {
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
		String  Name = prop.getProperty("username");
		OrangeOR.settextforUserName(Name);
		String  Pswrd = prop.getProperty("password");
		OrangeOR.setTextforPassword(Pswrd);
		OrangeOR.setStaySignedInClick();
	}

	@AfterTest
	public void close() {
		Driver.close();
	}
} 