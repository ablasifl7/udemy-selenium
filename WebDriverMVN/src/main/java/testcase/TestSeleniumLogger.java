package testcase;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import helper.LinkHelper;
import helper.LoggerHelper;
import helper.*;

public class TestSeleniumLogger extends StartWebDriver {

	private static final Logger logger = LoggerHelper.getLogger(TestSeleniumLogger .class);

	@Test
	public void openWePage(){
		LinkHelper.clickLink("File a Bug");
		logger.info("Click on Link [File a Bug]");
		TextBoxHelper.typeInTextBox("Bugzilla_login", file.getUsername());
		logger.info("Type the Username");
		TextBoxHelper.typeInTextBox("Bugzilla_password",file.getPassword());
		logger.info("Type the Password");
		try{
			ButtonHelper.clickButton("as");
		}catch (Exception e){
			logger.error("Not able to Click on the Button : ",e);
		}
		
		
	
		//ButtonHelper.clickButton("log_in");

	}

}
