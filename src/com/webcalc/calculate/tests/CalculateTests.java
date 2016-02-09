package com.webcalc.calculate.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.webcalc.calculate.testUtilities.CalculatePageUtilities;

public class CalculateTests extends CalculatePageUtilities{
	private static String _n1 = "";
	private static String _n2 = "";
	private static String _result = "";
	private static final String baseURL = "http://web2.0calc.com";
	
	// ToDo:  setup logging and remove println statements
	CalculatePageUtilities cUtils = new CalculatePageUtilities(null);

	public CalculateTests(WebDriver driver) {
		super(driver);
	}
	
	public CalculateTests() {
		super(driver);
	}

	@BeforeClass
	public void runSetup() {
		cUtils.readFile();
		System.setProperty("webdriver.chrome.driver", "/Users/me/Downloads/chromedriver");
		driver = new ChromeDriver();
		driver.get(baseURL);
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void tearDown() {
		driver.close();
	}
	
	private void setVariables(String lineInfo) {
		final String DELIMITER = ",";
		String[] tokens = lineInfo.split(DELIMITER); 	
        _n1 = tokens[0];
        _n2 = tokens[1];
        _result = tokens[3];
	}

	@Test
	public void testAddition() throws InterruptedException {
		System.out.println("Starting testAddition");
		setVariables(cUtils.getAddString());
		String addResult = cUtils.performOperation(_n1, _n2, Operation.ADD);
		Assert.assertEquals(addResult, _result );
	}
	
	@Test
	public void testSubtraction() throws InterruptedException {
		System.out.println("Starting testSubtraction");
		setVariables(cUtils.getSubString());
		String subResult = cUtils.performOperation(_n1, _n2, Operation.SUBTRACT);
		Assert.assertEquals(subResult, _result);
	}
	
	@Test
	public void testMultiplication() throws InterruptedException {
		System.out.println("Starting testMultiplication");
		setVariables(cUtils.getMultString());
		String multResult = cUtils.performOperation(_n1, _n2, Operation.MULTIPLY);
		Assert.assertEquals(multResult, _result);
	}
	
	@Test
	public void testDivision() throws InterruptedException {
		System.out.println("Starting testDivision");
		setVariables(cUtils.getDivString());
		String divResult = cUtils.performOperation(_n1, _n2, Operation.DIVIDE);
		Assert.assertEquals(divResult, _result);
	}
}