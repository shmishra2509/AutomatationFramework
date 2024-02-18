package testcases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.learnautomation.base.BaseClass;
import com.learnautomation.dataProvider.ExcelReader;
import com.learnautomation.pages.HomePage;
import com.learnautomation.pages.LoginPage;

public class LoginTest extends BaseClass
{
	@Test(dataProvider = "TestData")
	public void validLogin(String uname,String pass)
	{
		LoginPage login=new LoginPage(driver);
		
		login.loginOption();
	
		HomePage homePage=login.loginToApplication(uname,pass);
		
		Assert.assertTrue(homePage.isManageDisplayed());
		
		homePage.signOutFromApplication();
	
		Assert.assertTrue(login.isSignInDisplayed());
	}
	
	@DataProvider(name = "TestData")
	public Object [][] getData()
	{
		Object[][]arr=ExcelReader.getDataFromExcel("LoginData");
		
		return arr;
	}
	
	

}
