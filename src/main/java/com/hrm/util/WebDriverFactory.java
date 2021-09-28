package com.hrm.util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class WebDriverFactory {
	
	public static final int MAX_TIME_ELEMENT_TO_LOAD=20;
	
	public static WebDriver createDriver() {
	
		final boolean IF_RUN_TESTS_ON_SELENIUM_GRID =
            Boolean.parseBoolean( Config.getProperty("seleniumgrid.runtests"));

		WebDriver driver =( IF_RUN_TESTS_ON_SELENIUM_GRID ) ?
				createDriverForRemoteExecution() : createDriverForLocalExecution();
        driver.manage().timeouts().implicitlyWait( MAX_TIME_ELEMENT_TO_LOAD, TimeUnit.SECONDS );
                    
        return driver;
	}
	
	
	public static WebDriver createDriverForLocalExecution() {
		final String BROWSER_TYPE = Config.getProperty("local.browser.type");
		switch (BROWSER_TYPE) {
		case "FIREFOX":
			System.out.println("Opening firefox browser");
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\Drivers\\geckodriver.exe");
			return new FirefoxDriver();
		case "CHROME":
			System.out.println("Opening chrome browser");
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
			return new ChromeDriver();
		case "IE":
			System.out.println("Opening IE browser");
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\Drivers\\IEDriverServer.exe");
			return new InternetExplorerDriver();
			
		default:
			System.out.println("browser : " + BROWSER_TYPE + " is invalid, Launching Chrome as browser of choice..");
			System.out.println("Opening chrome browser");
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
			return new ChromeDriver();
		}
	}
	
	public static WebDriver createDriverForRemoteExecution() {
		return null;
	}
	
}
