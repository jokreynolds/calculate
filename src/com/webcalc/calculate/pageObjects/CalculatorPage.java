package com.webcalc.calculate.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CalculatorPage {
	public static WebDriver driver;
	
	public CalculatorPage(WebDriver driver) {	
	}
	
	public WebElement getPlusButton() {
		return driver.findElement(By.id("BtnPlus"));
	}
	
	public WebElement getMinusButton() {
		return driver.findElement(By.id("BtnMinus"));
	}
	
	public WebElement getMultiplicationButton() {
		return driver.findElement(By.id("BtnMult"));
	}
	
	public WebElement getDivideButton() {
		return driver.findElement(By.id("BtnDiv"));
	}
	
	public WebElement getEqualsButton() {
		return driver.findElement(By.id("BtnCalc"));
	}
	
	public WebElement getResult() throws InterruptedException  {
		Thread.sleep(2000); //This is not a good way to wait, the whole program stops.  Need to make an element wait
		//This is what element inspector states is the path to the result, but it does not provide the correct element.
		WebElement ele = driver.findElement(By.cssSelector("div#histframe > ul > li > p.r"));
		return ele;
	}

	public void pushNumberButton(String numberString) {
		boolean sign = false;
		char[] stringArray = numberString.toCharArray();
		String button = "";
		for (char single : stringArray) {
			if(single == '-') {
				sign = true;
			}
			else {
				button = "Btn" + single;
				driver.findElement(By.id(button)).click();
			}
		}
		if(sign) {
			driver.findElement(By.id("BtnSign")).click();
		}
	}
}