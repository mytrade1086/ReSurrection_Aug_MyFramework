package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import config.BrowserConfig;
import utils.WebUtil;

public class Base {
	public WebDriver driver;
	public WebUtil el;
	public static ThreadLocal<WebDriver> tl = new ThreadLocal<WebDriver>();

	static Date date = new Date();
	static SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy HH-mm");
	static String strDate = dateFormat.format(date);

	public static ExtentSparkReporter spark;
	public static ExtentReports extent;
	public static ExtentTest test;

	
	public static void setExtent() {
		spark = new ExtentSparkReporter("./" + "\\ExtentReports\\ExtentReport.html");
		spark.loadXMLConfig(
				"D:\\ResurrectionJavaAug\\ReSurrection_Aug_MyFramework\\src\\main\\java\\config\\ExtentReportConfig.xml");
		extent = new ExtentReports();
		extent.attachReporter(spark);
	}

	public static void flushExtent() {
		if (extent != null) {
			extent.flush();
		}
	}

	public WebDriver init_Driver(Properties prop) {

//		String env=System.getProperty("env");
//		if(env==null) {
//	    env="QA";	
//		}
//		
//		
//		switch(env) {
//		
//		case env :
//			
//			
//			
//		break;
//			
//			
//		
//		
//		}
//			
		if (prop.getProperty("browser").trim().equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver85.exe");
			driver = new ChromeDriver(BrowserConfig.getChromeOptions());
			tl.set(driver);

		} else if (prop.getProperty("browser").trim().equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
			driver = new FirefoxDriver();
			tl.set(driver);
		}

		else if (prop.getProperty("browser").trim().equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", "./Drivers/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			tl.set(driver);
		}

		tl.get().manage().deleteAllCookies();
		tl.get().manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		tl.get().manage().window().maximize();
		tl.get().get(prop.getProperty("url"));

//		normal = 1;
//		staticvar = 1;

		return tl.get();
	}

//	private void init_remoteWebDriver(String browserName) {
//		if (browserName.equalsIgnoreCase("chrome")) {
//			DesiredCapabilities cap = DesiredCapabilities.chrome();
//			cap.setCapability(ChromeOptions.CAPABILITY, BrowserConfig.getChromeOptions());
//			try {
//				tl.set(new RemoteWebDriver(new URL(prop.getProperty("huburl")), cap));
//			} catch (MalformedURLException e) {
//				e.printStackTrace();
//			}
//		}
//
//		else if (browserName.equalsIgnoreCase("firefox")) {
//			DesiredCapabilities cap = DesiredCapabilities.firefox();
//			cap.setCapability(ChromeOptions.CAPABILITY, optionsManager.getFirefoxOptions());
//			try {
//				tlDriver.set(new RemoteWebDriver(new URL(prop.getProperty("huburl")), cap));
//			} catch (MalformedURLException e) {
//				e.printStackTrace();
//			}
//		}
//
//	}
//	

	public Properties init_Prop() {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("./src/main/java/config/QA_config.properties");
		} catch (FileNotFoundException e) {
			System.out.println("Problem with properties file");
			e.printStackTrace();
		}
		Properties prop = new Properties();
		try {
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}

	public String getScreenshot() {
		File src = ((TakesScreenshot) tl.get()).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis() + ".png";
		File destination = new File(path);
		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return path;
//
//	}
	}
}
