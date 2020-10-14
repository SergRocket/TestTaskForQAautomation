package TestTask;

import org.junit.After;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public WebDriver webDriver = new ChromeDriver();

    public LoginPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    @Test
    public void LoginTest() throws InterruptedException {
        //open login page
        webDriver.get("http://demo.hospitalrun.io/#/login");
        Thread.sleep(1000);
        webDriver.findElement(By.id("identification")).sendKeys("hr.doctor@hospitalrun.io");
        webDriver.findElement(By.id("password")).sendKeys("HRt3st12");
        Thread.sleep(1000);
        //login
        webDriver.findElement(By.xpath("//*[@id=\"ember480\"]/div/form/div[2]/button")).click();
        Thread.sleep(6000);
        //check if the login was successful
        Assert.assertTrue(webDriver.getCurrentUrl().contains("#/patients"));

    }

    @After
    public void Teardown() {
        if (webDriver != null) ;
        System.out.print("Test was completed");
    }
}
