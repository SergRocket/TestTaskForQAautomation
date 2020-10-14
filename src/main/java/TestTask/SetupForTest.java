package TestTask;

import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SetupForTest {
    //initialize webDriver
   public WebDriver webDriver = new ChromeDriver();
    LoginPage loginPage;
 @Before
    public void PrepeareTest (){
     //setting webDriver location
     loginPage = new LoginPage(webDriver);
     System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
 }

}

