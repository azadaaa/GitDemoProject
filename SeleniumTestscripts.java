package SeleniumTestscripts;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import project.pages.OrangeHRPPages;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class TestCase13 {

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


	@Test (priority=2)
	public void pimTab() {
		OrangeOR.setPIM();
		OrangeOR.setTextforEmployeeName("Linda Anderson");
		OrangeOR.setPIMSearch();
	}

	 @Test (priority=3)
     public void fullPageScreenshot() throws IOException {

         String Filename1 = "OrangeHRMPage";

         AShot Screen = new AShot();
         Screenshot sshot1 = Screen.shootingStrategy(ShootingStrategies.viewportPasting(200)).takeScreenshot(Driver);

         String Dest1 = System.getProperty("user.dir") + "/Screenshots/" + Filename1 + ".jpg";

         File FinalDestination = new File(Dest1);

         ImageIO.write(((Screenshot) sshot1).getImage(), "jpg", FinalDestination);



     }


	@Test(priority=4)
	public void close() {
		Driver.close();
	}

} 