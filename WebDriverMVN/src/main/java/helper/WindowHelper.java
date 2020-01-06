package helper;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class WindowHelper extends StartWebDriver{

	public static void switchTo(int index){
		try {
			List<String> win = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(win.get(index));
		} catch (Exception e) {
			throw new IndexOutOfBoundsException("Invalid Windows Index "+index);
		}
	}
	
	public static void switchToIgnoringException(int index){
		try{
			List<String> win = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(win.get(index));
		} catch (Exception e) {
		
		}
	}
	
	public static void switchToParentWithClose(){
		List<String> win = new ArrayList<String>(driver.getWindowHandles());
		for(int i= 1;i<win.size();i++){
			driver.switchTo().window(win.get(i));
			driver.close();
		}
		driver.switchTo().window(win.get(0));
	}
	public static void back(){
		driver.navigate().back();
	}
	public static void forward(){
		driver.navigate().forward();
	}
	public static void refresh(){
		driver.navigate().refresh();
	}
	public static void navigateToPage(String url){
		driver.navigate().to(url);
	}
	public static void windowMaximize(){
		driver.manage().window().maximize();
	}
	

}
	
