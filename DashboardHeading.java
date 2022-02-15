package DashboardHeading;


import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase9 {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {


		System.setProperty("webdriver.chrome.driver", "C:\\Soft\\Jarfiles\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		//Minimizing
		driver.manage().window().setPosition(new Point(-1000, 0));
		Thread.sleep(3000);
		//Restoring
		driver.manage().window().maximize();
		Thread.sleep(3000);
		//Close
		driver.close();
	}


} 