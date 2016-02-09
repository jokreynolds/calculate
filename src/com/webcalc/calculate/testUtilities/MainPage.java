package com.webcalc.calculate.testUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MainPage {
	
	protected static WebDriver driver;
	
	public static void main(String[] args) {
		//WebDriver driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "/usr/local/Library/Formula/");
		//WebDriver driver = new RemoteWebDriver(DesiredCapabilities.chrome());
		WebDriver driver = new ChromeDriver();
		driver.get("http://web2.0calc.com/");
		driver.manage().window().maximize();	
		System.out.println("URL" + driver.getCurrentUrl());
	}
	
	
}