package keywordTest;

import java.io.IOException;

import org.testng.annotations.Test;

import helper.StartWebDriver;
import helper.WindowHelper;
import keyword.KeywordStepDfn;

public class TestKeywordDriver extends StartWebDriver{
	@Test
	public void testBugzilla() throws IOException{
		String aFilePath = "C:\\Users\\defaultuser0\\keyword\\Data.xlsx";
		String  bSheetName = "Bugzilla";
		KeywordStepDfn.performactionWithKeyword(aFilePath, bSheetName);
	}
	
	@Test
	public void testCoadingtBat() throws IOException{
		String aFilePath = "C:\\Users\\defaultuser0\\keyword\\Data.xlsx";
		String  bSheetName = "Codingbat";
		WindowHelper.navigateToPage("https://codingbat.com/java");
		KeywordStepDfn.performactionWithKeyword(aFilePath, bSheetName);
	}

}
