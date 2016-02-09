package com.webcalc.calculate.testUtilities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.webcalc.calculate.pageObjects.CalculatorPage;

public class CalculatePageUtilities extends CalculatorPage{
	
	private static CalculatorPage page = new CalculatorPage(driver);
	public static String _add = "";
	public static String _sub = "";
	public static String _mult = "";
	public static String _div = "";

	public CalculatePageUtilities(WebDriver driver) {
		super(driver);
	}

	public enum Operation {
		ADD (1),
		SUBTRACT (2),
		MULTIPLY (3),
		DIVIDE (4);
		
		@SuppressWarnings("unused")
		private final int opNumber;
		
		private Operation(final int op) {
			opNumber = op;
		}
	}
	
	public String getAddString() {
		return _add;
	}
	public String getSubString() {
		return _sub;
	}
	public String getMultString() {
		return _mult;
	}
	public String getDivString() {
		return _div;
	}
	
	public String performOperation(String n1, String n2, Operation operation) throws InterruptedException {
		page.pushNumberButton(n1);
		
		switch (operation) {
			case ADD: {
				page.getPlusButton().click();
				break;
			}
			case SUBTRACT: {
				page.getMinusButton().click();
				break;
			}
			case MULTIPLY: {
				page.getMultiplicationButton().click();
				break;
			}
			case DIVIDE: {
				page.getDivideButton().click();
				break;
			}
		}
		page.pushNumberButton(n2);
		page.getEqualsButton().click();
		String sresult = page.getResult().getText();
		return sresult; 
	}
	
	public void readFile() {
		String fileToParse = "Demo.csv";
        BufferedReader fileReader = null;

        try
        {
            String line = "";
            //Create the file reader
            fileReader = new BufferedReader(new FileReader(fileToParse));
             
            //Read the file line by line
            while ((line = fileReader.readLine()) != null) 
            {
                	if(line.contains("Addition")) {
                		_add = line;
                	}
                	if(line.contains("Subtraction")) {
                		_sub = line;
                	}
                	if(line.contains("Multiplication")){
                		_mult = line;
                	}
                	if(line.contains("Division")) {
                		_div = line;
                	}
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        } 
        finally
        {
            try {
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
	}
}