package config;

import org.openqa.selenium.chrome.ChromeOptions;

public class BrowserConfig {
	
	public static ChromeOptions  getChromeOptions() {
		ChromeOptions co=new ChromeOptions();
		co.addArguments("start-maximized");
		co.addArguments("--incognito");
//		co.addArguments("");
//		co.addArguments("");
//		co.addArguments("");
			
//		ChromeOptions options = new ChromeOptions();
//		// Add the WebDriver proxy capability.
//		Proxy proxy = new Proxy();
//		proxy.setHttpProxy("myhttpproxy:3337");
//		options.setCapability("proxy", proxy);
		
//		// Add a ChromeDriver-specific capability.
//		options.addExtensions(new File("/path/to/extension.crx"));
//		ChromeDriver driver = new ChromeDriver(options);
		return co;
		
	}

}
