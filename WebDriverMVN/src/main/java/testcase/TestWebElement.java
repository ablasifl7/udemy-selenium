package testcase;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TestWebElement extends helper.StartWebDriver{
	
	@Test
	public void findElement(){
		try {
			helper.LinkHelper.clickLink("File a Bug");
//			System.out.println("Selected : "+driver.findElement(By.id("Bugzilla_restrictlogin")).isSelected());
//			driver.findElement(By.id("Bugzilla_restrictlogin")).click();
//			System.out.println("Selected : "+driver.findElement(By.id("Bugzilla_restrictlogin")).isSelected());
			System.out.println("Seleted : "+helper.CheckBoxHelper.isChecked("Bugzilla_restrictlogin"));
			helper.CheckBoxHelper.clickCheckBox("Bugzilla_restrictlogin");
			System.out.println("Seleted : "+helper.CheckBoxHelper.isChecked("Bugzilla_restrictlogin"));
			helper.TextBoxHelper.typeInTextBox("Bugzilla_login", "ablasifl7@gmail.com");
			helper.TextBoxHelper.typeInTextBox("Bugzilla_password","Pa55w0rd");
			
			helper.ButtonHelper.clickButton("log_in");
			
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
	}
}
